package com.example.project.controller;

import com.example.project.domain.User;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//这个是用户的controller，处理用户的数据
@Controller
@RequestMapping("/user")
public class userController {
  @Autowired
  private final UserService userService;

  public userController(UserService userService) {
    this.userService = userService;
  }


  /**
   * 用户登录 //todo: 尚未完成拦截器和session的部分，所以销售单涉及user只为还需要修改，但是前端可以先使用
   * @param userId 用户id
   * @param password 用户的密码
   * @return 登录是否成功
   */
  @RequestMapping(value = "/login")
  @ResponseBody
  public boolean login(int userId, String password){
    return userService.login(userId, password);
  }

  /**
   * 注册一个新用户
   * @param userName 用户名
   * @param password 密码
   * @param status 用户职位   0为经理，1为店长，2为店员
   * @return 注册成功返回true，失败返回false
   */
  @RequestMapping(value = "/register")
  @ResponseBody
  public boolean registerNewUser(String userName, String password, int status){
    userService.register(userName, password, status);
    return false; // 修改返回值
  }

  /**
   * 修改当前登录的用户信息
   * @param userId 用户id
   * @param userName 用户姓名
   * @param password 用户密码
   * @param status 用户职位   0为经理，1为店长，2为店员
   * @return 修改成功返回true，失败返回false
   */
  @RequestMapping(value = "/modify")
  @ResponseBody
  public boolean modifyUser(int userId, String userName, String password, int status){
    userService.updateUserMessage(new User(userId, userName, password, status));
    return false;  //要修改返回值
  }

}
