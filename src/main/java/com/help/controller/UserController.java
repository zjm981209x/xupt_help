package com.help.controller;

import com.help.entity.User;
import com.help.service.Impl.MailService;
import com.help.service.UserService;
import com.help.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用户
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    /**
     * 修改个人信息
     *
     * @param user
     * @param request
     * @return
     */
    @PutMapping("/")
    public String update(User user, HttpServletRequest request){
        String name = (String)request.getAttribute("username");
        User tmp = userService.selectByName(name);
        user.setUserId(tmp.getUserId());
        if(!user.getEmail().isEmpty()){
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(() -> {
                String to = user.getEmail();
                String subject = "message";
                String content = "您已成功将邮箱绑定到西邮帮帮帮！";
                mailService.send(to,subject,content);
            });
        }
        return userService.update(user) == 1 ? "success" : "error";
    }

    /**
     * 修改头像
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/")
    public String updateImage(@RequestParam("file") MultipartFile file,
                              HttpServletRequest request){
        String name = (String)request.getAttribute("username");
        String result = "error";
        if(!file.isEmpty()){
            String filename = file.getOriginalFilename();
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";
            result = userService.updateByName(name,filename) == 1 ? "success" : "error";
            try {
                FileUtil.upload(file.getBytes(),path,filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 查询当前用户个人信息
     *
     * @param request
     * @return
     */
    @GetMapping("/")
    public User selectByName(HttpServletRequest request){
        String name = (String) request.getAttribute("username");
        User user = userService.selectByName(name);
        user.setUserPw("");
        return user;
    }
}
