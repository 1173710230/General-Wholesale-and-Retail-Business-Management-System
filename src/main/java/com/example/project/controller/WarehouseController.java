package com.example.project.controller;

import com.example.project.domain.Goods;
import com.example.project.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 这是仓库controller模块
 */
@Controller
@RequestMapping("/warehouseController")
public class WarehouseController {
  private final WarehouseService warehouseService;

  @Autowired
  public WarehouseController(WarehouseService warehouseService) {
    this.warehouseService = warehouseService;
  }

  /**
   * 得到一个仓库中所有的货物
   * @return 返回一个仓库中所有的货物
   */
  @RequestMapping(value = "/getAllGoods", method = RequestMethod.GET)
  @ResponseBody
  public List<Goods> getGoodsFromAllWarehouse(){
    return warehouseService.getGoodsFromAllWarehouse();
  }

  /**
   * 按照商品name查找商品
   * @param name 需要查找的name
   * @return 查找到的商品列表
   */
  @RequestMapping(value = "/queryGoodsByName", method = RequestMethod.GET)
  @ResponseBody
  public List<Goods> queryGoodsByName(String name){
    return warehouseService.queryGoodsByName(name);
  }

}
