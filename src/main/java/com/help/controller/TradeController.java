package com.help.controller;

import com.help.entity.Task;
import com.help.entity.Trade;
import com.help.service.TaskService;
import com.help.service.TradeServcie;
import com.help.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * 交易
 */
@RestController
@RequestMapping("trade")
public class TradeController {

    @Autowired
    private TradeServcie tradeServcie;

    @Autowired
    private TaskService taskService;

    /**
     * 添加交易信息
     *
     * @param trade
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/")
    public String insert(Trade trade,
                         @RequestParam("file") MultipartFile file,
                         HttpServletRequest request){
        String name = (String)request.getAttribute("username");
        if(!file.isEmpty()){
            String filename = file.getOriginalFilename();
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";
            trade.setImage(filename);
            try {
                FileUtil.upload(file.getBytes(),path,filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Trade result = tradeServcie.insert(trade);
        Task task = new Task();
        task.setType("trade");
        task.setStatus(-1);
        task.setPubUser(name);
        task.setTypeId(result.getTradeId());
        task.setTimer(new Timestamp(System.currentTimeMillis()));
        task.setSubUser("");
        return taskService.insert(task) != null ? "success" : "error";
    }

    /**
     * 传入交易id获取信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Trade selectById(@PathVariable int id){
        return tradeServcie.selectById(id);
    }

    /**
     * 获取所有交易信息
     *
     * @return
     */
    @GetMapping("/")
    public List<Trade> selectAll(){
        return tradeServcie.selectAll();
    }

    /**
     * 删除交易信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        return tradeServcie.deleteById(id) == 1 ? "success" : "error";
    }

    /**
     *
     * @return
     */
    @PostMapping("/empty")
    public String empty(){
        return "success";
    }
}
