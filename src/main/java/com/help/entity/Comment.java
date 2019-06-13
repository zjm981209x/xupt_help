package com.help.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    /**
     * 评论id
     */
    private int commentId;
    /**
     * 任务id
     */
    private int taskId;
    /**
     * 发布评论的用户
     */
    private String user;
    /**
     * 发布评论的时间
     */
    private Timestamp time;
    /**
     * 评论具体内容
     */
    private String content;
}
