package com.help.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ManagerDao {
    int deleteById(int taskId);
    int passTrade(int taskId);
    int update(int taskId);
}
