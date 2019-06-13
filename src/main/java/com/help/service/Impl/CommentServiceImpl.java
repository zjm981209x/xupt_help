package com.help.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.help.dao.CommentDao;
import com.help.entity.Comment;
import com.help.entity.PageResult;
import com.help.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;


    @Override
    public Comment insert(Comment comment) {
        commentDao.insert(comment);
        return comment;

    }

    @Override
    public List<Comment> selectById(int taskId) {
        return commentDao.selectById(taskId);

    }

    @Override
    public int deleteById(int commentId) {
        return commentDao.deleteById(commentId);
    }

    @Override
    public PageResult findByPage(int code, int size) {
        PageHelper.startPage(code,size);
        Page<Comment> page = commentDao.findByPage();
        PageResult result = new PageResult(page.getTotal(),page.getResult());
        return result;
    }


}
