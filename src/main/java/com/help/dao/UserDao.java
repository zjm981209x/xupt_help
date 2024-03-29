package com.help.dao;

import com.help.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    int insert(User user);
    User selectByName(String name);
    int update(User user);
    int updateByName(@Param("name") String name,@Param("image") String image);
}
