package com.example.project.controller;

import com.example.project.domain.User;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//这个是用户的controller，处理用户的数据
@Controller
@RequestMapping("/user")
public class UserController extends HttpServlet {
  @Autowired
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  /**
   * 处理请求，并实现登录功能，并将数据存储在session中
   * @param request 前端向controller传参
   * @param response  controller向前端处理
   * @throws IOException IOException
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
     request.setCharacterEncoding("utf-8");
     //接收参数
     int userId = Integer.parseInt(request.getParameter("userId"));
     String userPassword = request.getParameter("userPassword");
     boolean loginSuccess = userService.login(userId, userPassword);
     if(loginSuccess){
       HttpSession session = request.getSession();
       session.setAttribute("userId", userId);
       session.setAttribute("userPassword", userPassword);
       response.sendRedirect("/index.html");  //登录成功重定向到主页
     }else {  //登录失败，我这是重定向登录页面，要有修改告知我（ps: 这个页面暂时没有）。
       response.sendRedirect("/login.html");
     }
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
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
