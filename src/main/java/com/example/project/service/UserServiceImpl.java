package com.example.project.service;

import com.example.project.dao.UserMapper;
import com.example.project.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public boolean login(String name, String password) {
       // User user = this.userMapper.searchUserByUserId(userId);
        User user = userMapper.queryUser(new User(null,name,null,null)).get(0);
        // System.out.println(userId);
        System.out.println(password);
        if (user != null && user.getUserPassword().equals(password))
            return true;
        else
            return false;
    }

    @Override
    public boolean register(String userName, String password, Integer status) {
        try{
            User user = new User(null, userName, password, status);
            this.userMapper.insertUser(user);
            return true;
        } catch(DataAccessException ex){
            ex.printStackTrace();
           return false;
        }

    }

    @Override
    public boolean updateUserMessage(User user) {
        try{
            this.userMapper.updateUser(user);
            return true;
        } catch (DataAccessException ex){
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public User getUserById(int userId){
        User user = new User();
        user.setUserId(userId);
        return userMapper.queryUser(user).get(0);
    }


    @Override
    public User getUserByName(String name){
        User user = new User();
        user.setUserName(name);
        return userMapper.queryUser(user).get(0);
    }
}
