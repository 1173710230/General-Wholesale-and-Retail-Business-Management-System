package com.example.project.controller;

import com.example.project.domain.User;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//这个是用户的controller，处理用户的数据
@Controller
@RequestMapping("/user")
public class UserController {
  @Autowired
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }


  /**
   * 用户登录  //todo: 尚未完成拦截器
   * @param userId 用户id
   * @param password 用户的密码
   * @return 登录是否成功
   */
  @RequestMapping(value = "/login")
  @ResponseBody
  public boolean login(HttpServletRequest req, int userId, String password){
    //登录
    HttpSession session = req.getSession();
    int userStatus = userService.getUserById(userId).getStatus();
    session.setAttribute("userStatus", userStatus);
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
    return userService.register(userName, password, status);
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
    return userService.updateUserMessage(new User(userId, userName, password, status));
  }

}
