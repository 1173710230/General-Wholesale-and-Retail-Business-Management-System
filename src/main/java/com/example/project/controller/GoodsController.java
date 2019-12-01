package com.example.project.controller;

import com.example.project.domain.Goods;
import com.example.project.service.GoodsService;
import com.example.project.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 这是一个商品的controller模块，里面主要有增删改查的控制器
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
  private final GoodsService goodsService;
  private WarehouseService warehouseService;

  @Autowired
  public GoodsController(GoodsService goodsService, WarehouseService warehouseService) {
    this.goodsService = goodsService;
    this.warehouseService = warehouseService;
  }

  /**
   * 获取所有的商品
   * @return 所有商品的Goods
   */
  @RequestMapping("/allGoods")
  @ResponseBody
  public List<Goods> getAllGoods(){
    return goodsService.getAllWarehouseGoods();
  }

  /**
   * 在某个仓库中增加一种商品（这个商品可能在仓库中出现）
   * @param goodsNumber  商品的数量
   * @param goodsName 商品的名字
   * @param spec 商品的规格
   * @param warehouseId 仓库的id
   * @return 返回添加成功True，失败False
   */
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  @ResponseBody
  public Boolean addGoods(double goodsNumber, String goodsName, String spec, int warehouseId){
    return warehouseService.addNewGoods(goodsNumber, goodsName, spec, warehouseId);
  }

  /**
   * 删除所有仓库中的某种商品
   * @param id 要删除的商品id
   * @return 返回仓库中的所有商品
   */
  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  @ResponseBody
  public List<Goods> deleteGoods(int id){
    goodsService.deleteGoodsById(id);
    return goodsService.getAllWarehouseGoods();
  }

  /**
   * 修改一个商品的信息
   * @param id 要修改的商品id
   * @return 返回当前的所有商品
   */
  @RequestMapping(value = "/update", method = RequestMethod.GET)
  @ResponseBody
  public List<Goods> update(int id, String goodsName, String spec){
    goodsService.modifyGoodsById(id, goodsName, spec);
    return goodsService.getAllWarehouseGoods();
  }

  /**
   * 按照商品名字查询商品
   * @param name 商品名字
   * @return 返回查找到的商品名字
   */
  @RequestMapping("/queryGoodsByName")
  @ResponseBody
  public List<Goods> queryGoodsByName(String name){
    return goodsService.queryGoodsByName(name);
  }
}
