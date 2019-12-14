package com.example.project.controller;

import com.example.project.domain.SellOrder;
import com.example.project.service.CashierDeskService;
import com.example.project.service.CashierDeskServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

//这个类是收银台类，处理零售的业务
@Controller
@RequestMapping("/checkCount")
public class checkoutCounter {
  private final CashierDeskService cashierDeskService = new CashierDeskServiceImpl();

  /**
   * 对零售的销售单收款
   * @param sellOrderId 销售单的id
   * @return 收款成功返回true，失败返回false
   */
  @RequestMapping(value = "/checkOut", method = RequestMethod.GET)
  @ResponseBody
  public Double[] checkOut(int sellOrderId){
    //还需要修改，对应参数修改
    return cashierDeskService.gathering(null);
  }

}
