package com.example.project.dao;

import com.example.project.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    public void insertUser(User user);

    public void setNameByUserId(@Param("userId") String userId, @Param("name") String name);

    public void setPasswordByUserId(@Param("userId") String userId, @Param("password") String password);

    public User searchUserByUserId(String userId);

}
