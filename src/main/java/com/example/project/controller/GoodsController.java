package com.example.project.controller;

import com.example.project.domain.Goods;
import com.example.project.server.GoodsService;
import com.example.project.server.WarehouseService;
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
  public GoodsController(GoodsService goodsService) {
    this.goodsService = goodsService;
  }

  /**
   * 获取所有的商品
   * @return 所有商品的Goods
   */
  @RequestMapping("/allGoods")
  @ResponseBody
  public List<Goods> getAllGoods(){
    return goodsService.getallWirehouseGoods();
  }

  /**
   * 在某个仓库中增加一种商品（这个商品可能在仓库中出现）
   * @param checkGoodsId 商品的id（根据这个商品id只进行查询商品的是否存在，不是新的商品id）
   * @param goodsNumber  商品的数量
   * @param goodsName 商品的名字
   * @param spec 商品的规格
   * @param warehouseId 仓库的id
   * @return 返回当前的仓库商品
   */
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  @ResponseBody
  public List<Goods> addGoods(int checkGoodsId, int goodsNumber, String goodsName, String spec, int warehouseId){
    warehouseService.addNewGoods(checkGoodsId, goodsNumber, goodsName, spec, warehouseId);
    return goodsService.getallWirehouseGoods();
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
    return goodsService.getallWirehouseGoods();
  }

  /**
   * 修改一个商品的信息, 还要改 TODO：未完成
   * @param id 要修改的商品id
   * @return 返回
   */
  @RequestMapping(value = "/update", method = RequestMethod.GET)
  @ResponseBody
  public List<Goods> update(int id){
    goodsService.modifyGoodsById(id);
    return goodsService.getallWirehouseGoods();
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
