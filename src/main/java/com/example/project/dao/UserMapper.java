package com.example.project.dao;

import com.example.project.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public void insertUser(User user);

    public void setNameByUserId(@Param("userId") int userId, @Param("name") String name);

    public void setPasswordByUserId(@Param("userId") int userId, @Param("password") String password);

    public User searchUserByUserId(int userId);

    /**
     * 根据传入的user对象的非空属性查询用户。
     * @param user  查询的条件
     */
    void queryUser(User user);

}
