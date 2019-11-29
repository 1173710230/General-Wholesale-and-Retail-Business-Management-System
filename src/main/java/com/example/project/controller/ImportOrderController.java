package com.example.project.controller;

import com.example.project.server.InputOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 这是销售单的controller模块，负责新建一个销售单
 */
@Controller
@RequestMapping("/importOrder")
public class ImportOrderController {
  private final InputOrderService inputOrderService;

  @Autowired
  public ImportOrderController(InputOrderService inputOrderService) {
    this.inputOrderService = inputOrderService;
  }

  /**
   * 增加一个新进货单
   * @param inputOrderId 等会要删 TODO：
   * @param goodsNumber 商品的数量
   * @param inputUnitPrice 商品的单价
   * @param goodsId 货物的id
   * @param remark 备注
   * @return 增加成功返回true，反正返回false
   */
  @RequestMapping("/addNewImportOrder")
  @ResponseBody
  public boolean addNewImportOrder(int inputOrderId, int goodsNumber, double inputUnitPrice, int goodsId, String remark){
    //时间的格式要求？？？不清楚
    return inputOrderService.addNewInputOrder(inputOrderId, goodsNumber, inputUnitPrice, goodsId, new Date(System.currentTimeMillis()),remark);
  }

}