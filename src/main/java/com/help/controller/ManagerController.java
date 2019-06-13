package com.help.controller;

import com.help.entity.Manager;
import com.help.entity.Task;
import com.help.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 管理
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private ExpressService expressService;

    @Autowired
    private TradeServcie tradeServcie;

    /**
     * 删除任务所有信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        Task task = taskService.selectById(id);
        String type = task.getType();
        int typeId = task.getTypeId();
        if("food".equals(type)){
            foodService.deleteById(typeId);
        }else if("express".equals(type)) {
            expressService.deleteById(typeId);
        }else{
            tradeServcie.deleteById(typeId);
        }
        return managerService.deleteById(id) == 1 ? "success" : "error";
    }

    /**
     * 审核交易任务
     *
     * @param manager
     * @return
     */
    @PostMapping("/")
    public String passTrade(@RequestBody Manager manager){
        if(manager.getPass() == 1){
            return managerService.passTrade(manager.getId()) == 1 ? "success" : "error";
        }else{
            return "success";
        }
    }

    /**
     * 任务下架
     *
     * @return
     */
    @PutMapping("/{id}")
    public String update(@PathVariable int id){
        return managerService.update(id) == 1 ? "success" : "error";
    }

    /**
     * 管理员确认
     *
     * @param request
     * @return
     */
    @GetMapping("/")
    public String managerConfirm(HttpServletRequest request){
        String username = (String) request.getAttribute("username");
        return username.startsWith("admin@") ? "success" : "error";
    }
}
