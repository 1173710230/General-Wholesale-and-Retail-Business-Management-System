package com.example.project.controller;

import com.example.project.domain.SellOrder;
import com.example.project.domain.SellOrderGroup;
import com.example.project.service.SellOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//这个类是收银台类，处理零售的业务
@Controller
@RequestMapping("/checkCount")
public class CheckOutCounter {
  @Autowired
  private final SellOrderService sellOrderService;
  private List<SellOrder> currentSellOrders = new ArrayList<>();

  public CheckOutCounter(SellOrderService sellOrderService) {
    this.sellOrderService = sellOrderService;
  }

  /**
   * 获取所有零售单
   * @return 零售单的列表
   */
  @RequestMapping(value = "/getAllRetailOrder")
  @ResponseBody
  public List<SellOrderGroup> getAllRetailOrder(){
    return sellOrderService.getAllRetailOrder();
  }
}
