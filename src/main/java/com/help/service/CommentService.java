package com.help.service;

import com.help.entity.Comment;
import com.help.entity.PageResult;

import java.util.List;

public interface CommentService {

    Comment insert(Comment comment);

    List<Comment> selectById(int taskId);

    int deleteById(int commentId);

    PageResult findByPage(int code, int size);



}
