package com.example.project.dao;

import com.example.project.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    void insertUser(User user);

//    public void setNameByUserId(@Param("userId") int userId, @Param("name") String name);
//
//    public void setPasswordByUserId(@Param("userId") int userId, @Param("password") String password);

    User searchUserByUserId(int userId);

    /**
     * 根据传入的user对象的非空属性查询用户。
     * @param user  查询的条件
     */
    List<User> queryUser(User user);

    /**
     * 根据传入的User对象的非空属性更新已有用户信息
     * @param user  用户id不为空的User对象
     */
    void updateUser(User user);

}
