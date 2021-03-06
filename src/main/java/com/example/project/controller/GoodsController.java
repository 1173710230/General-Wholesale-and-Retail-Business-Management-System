package com.example.project.controller;

import com.example.project.domain.Goods;
import com.example.project.service.GoodsService;
import com.example.project.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 这是一个商品的controller模块，里面主要有增删改查的控制器
 */
@CrossOrigin
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
    System.out.println("调用allGoods");
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

  /**
   * 按照商品id修改其零售价和批发价
   * @param goodsId 需要修改的商品id
   * @param wholesalePrice 商品的新批发价
   * @param retailPrice 商品的新零售价
   * @return 修改成功，返回true；反正，返回false
   */
  @RequestMapping("/modifyGoodsPrice")
  @ResponseBody
  public boolean modifyGoodsPriceById(int goodsId, double wholesalePrice, double retailPrice){
    System.out.println(wholesalePrice);
    System.out.println(retailPrice);
    if(wholesalePrice==0&&retailPrice==0){return true;}  //价格都为0直接返回true，不修改
    else if(wholesalePrice==0){  //一个选项为0，对应为null
      return goodsService.modifyGoodsPriceById(goodsId, null, retailPrice);
    }else if(retailPrice==0){
      return goodsService.modifyGoodsPriceById(goodsId, wholesalePrice, null);
    }
    return goodsService.modifyGoodsPriceById(goodsId, wholesalePrice, retailPrice);
  }

  /**
   * 根据商品的id获取批发价或者零售价
   * @param goodsId 商品的id
   * @param priceKind 价格的种类（0：获取批发价；1：获取零售价）
   * @return 商品的批发价或者零售价(如果查询到的值为-1（出错或者没找到），返回0)
   */
  @RequestMapping("/getWholeSalePriceOrRetailPrice")
  @ResponseBody
  public double getWholeSalePrice(int goodsId, int priceKind){
    assert priceKind>=0;
    assert priceKind<=1;  //priceKind 只能为0或1
    if (priceKind==0) {
      if(goodsService.getWholeSalePrice(goodsId)==-1){return 0;}
      System.out.println(goodsService.getWholeSalePrice(goodsId));
      return goodsService.getWholeSalePrice(goodsId);
    }else {
      if(goodsService.getRetailPrice(goodsId)==-1){return 0; }
      System.out.println(goodsService.getRetailPrice(goodsId));
      return goodsService.getRetailPrice(goodsId);
    }
  }

}
