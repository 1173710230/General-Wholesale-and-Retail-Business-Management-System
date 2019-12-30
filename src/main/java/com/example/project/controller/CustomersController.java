package com.example.project.controller;

import com.example.project.domain.Customer ;
import com.example.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 这是一个顾客的controller模块，里面主要有增删改查的功能
 */
@Controller
@RequestMapping("/customer")
public class CustomersController {
  private final CustomerService customerService;

  @Autowired
  public CustomersController(CustomerService customerService) {
    this.customerService = customerService;
  }

  /**
   * 获取所有的用户
   *
   * @return 所用用户的Customers
   */
  @RequestMapping("/allCustomers")
  @ResponseBody
  public List<Customer> getAllCustomers(){
    return customerService.getallCustomers();
  }

  /**
   * 增加一个顾客,参数还要修改
   * @param name 顾客姓名
   * @param tel 顾客联系方式
   * @param status 用户的状态, 0为批发， 1 为零售
   * @return 返回当前的顾客列表
   */
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  @ResponseBody
  public List<Customer> addCustomer(String name, String tel, int status){
    customerService.addCustomer(name, tel);
    return customerService.getallCustomers();
  }

  /**
   * 删除一个客户，由于前端删除时提供id（这个id理论上是一定存在的，不会出现删除一个不存在的id）
   * @param customerId 需要删除的顾客的id
   * @return 当前的客户的列表
   */
  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  @ResponseBody
  public List<Customer> deleteCustomer(Integer customerId){
    customerService.deleteCustomer(customerId);
    return customerService.getallCustomers();
  }

  /**
   * 修改一个客户的信息
   * @param name 新的客户的名字（前端没有输入时为null）
   * @param tel 新的客户的电话（前端没有输入时为null）
   * @return 返回当前的客户列表
   */
  @RequestMapping(value = "/update", method = RequestMethod.GET)
  @ResponseBody
  public List<Customer> update(int customerId, String name, String tel){
    customerService.modifyCustomer(customerId, name, tel);
    return customerService.getallCustomers();
  }

  /**
   * 按照名字查找顾客
   * @param name 顾客名字
   * @return 按照名字查找到的用户列表
   */
  @RequestMapping("/queryCustomerByName")
  @ResponseBody
  public List<Customer> queryCustomerByName(String name){
    return customerService.queryCustomerByName(name);
  }

  /**
   * 将某个用户的积分兑换为预存款值（100积分兑换1元预存款，多余的全兑，不足100积分不兑换）
   * @param customerId 需要兑换的用户账号
   * @return 兑换是否成功
   */
  @RequestMapping("/exchangeIntegral")
  @ResponseBody
  public boolean exchangeIntegral(int customerId){
    return customerService.exchangeIntegral(customerId);
  }

  /**
   * 充值某个用户的预存额
   * @param deposit 充值的预存款数量
   * @param customerId 用户的id
   * @return 充值是否成功
   */
  @RequestMapping("/addPreDeposit")
  @ResponseBody
  public boolean addPreDeposit(double deposit, int customerId){
    return customerService.addPreDeposit(deposit, customerId);
  }
}
