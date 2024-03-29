package com.help.dao;

import com.help.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TaskDao {
    int insert(Task task);
    List<Task> selectAll();
    List<Task> selectByStatus(int status);
    List<Task> selectByName(String name);
    int delete(int id);
    int cancel(int id);
    Task selectById(int id);
    int updateById(@Param("id") int id, @Param("name") String name);
}
