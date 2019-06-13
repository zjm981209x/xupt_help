package com.help.controller;

import com.help.entity.Comment;
import com.help.entity.PageResult;
import com.help.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * 评论
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    @PostMapping("/")
    public String insert(@RequestBody Comment comment){
        return commentService.insert(comment) != null ? "success" : "error";
    }

    /**
     * 传入任务id获取相关评论
     *
     * @param taskId
     * @return
     */
    @GetMapping("/{taskId}")
    public List<Comment> selectById(@PathVariable int taskId){
        return commentService.selectById(taskId);
    }

    /**
     * 删除评论
     *
     * @param commentId
     * @return
     */
    @DeleteMapping("/{commentId}")
    public String deleteById(@PathVariable int commentId){
        return commentService.deleteById(commentId) == 1 ? "success" : "error";
    }

    /**
     * 评论分页查询
     *
     * @param pageNum
     * @return
     */
    @PutMapping("/{pageNum}")
    public PageResult findByPage(@PathVariable int pageNum){
        return commentService.findByPage(pageNum,5);
    }
}
