package com.help.controller;

import com.help.entity.Food;
import com.help.entity.Task;
import com.help.service.FoodService;
import com.help.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * 外卖
 */
@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private FoodService foodService;

    /**
     * 新增外卖任务
     *
     * @param food
     * @param request
     * @return
     */
    @PostMapping("/")
    public String insert(@RequestBody Food food, HttpServletRequest request){
        String name = (String) request.getAttribute("username");
        Food result = foodService.insert(food);
        Task task = new Task();
        task.setTypeId(result.getFoodId());
        task.setType("food");
        task.setPubUser(name);
        task.setStatus(0);
        task.setSubUser("");
        task.setTimer(new Timestamp(System.currentTimeMillis()));
        return taskService.insert(task) != null ? "success" : "error";
    }

    /**
     * 获取所有外卖信息
     *
     * @return
     */
    @GetMapping("/")
    public List<Food> selectAll(){
        return foodService.selectAll();
    }

    /**
     * 传入外卖id获取信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Food selectById(@PathVariable int id){
        return foodService.selectById(id);
    }

    /**
     * 删除外卖信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        return foodService.deleteById(id) == 1 ? "success" : "error";
    }
}
