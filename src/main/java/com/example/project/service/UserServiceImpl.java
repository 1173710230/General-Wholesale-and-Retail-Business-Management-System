package com.example.project.service;

import com.example.project.dao.UserMapper;
import com.example.project.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public boolean login(Integer userId, String password) {
        User user = this.userMapper.searchUserByUserId(userId);

        if (user != null && user.getUserPassword().equals(password))
            return true;
        else
            return false;
    }

    @Override
    public void register(Integer userId, String userName, String password, Integer status) {
        User user = new User(userId, userName, password, status);
        this.userMapper.insertUser(user);
    }
}
