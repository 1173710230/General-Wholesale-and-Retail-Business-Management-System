package com.example.project.service;

import com.example.project.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 用户登录验证
     * @param name  用户账号
     * @param password  用户密码
     * @return   如果用户输入的密码匹配成功返回true， 否则返回false
     */
    public boolean login(String name, String password);

    /**
     * 新用户注册
     * @param password  密码
     * @param userName  用户名
     * @param status  用户职位
     */
    public boolean register(String userName, String password, Integer status);

    /**
     * 更新用户信息
     * @param user  携带新用户信息的对象。(用户id不为空)
     */
    public boolean updateUserMessage(User user);

    /**
     * 按id查询用户
     */
    public User getUserById(int userId);

    /**
     * 按name查询用户
     */
    public User getUserByName(String name);
}
