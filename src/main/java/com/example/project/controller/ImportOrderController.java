package com.example.project.controller;

import com.example.project.service.InputOrderService;
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
   * @param goodsNumber 商品的数量
   * @param inputUnitPrice 商品的单价
   * @param goodsId 货物的id
   * @param remark 备注
   * @return 增加成功返回true，反之返回false
   */
  @RequestMapping("/addNewImportOrder")
  @ResponseBody
  public boolean addNewImportOrder( int goodsNumber, double inputUnitPrice, int goodsId, String remark){
    return inputOrderService.addNewInputOrder( goodsNumber, inputUnitPrice, goodsId, new Date(System.currentTimeMillis()),remark);
  }

}
