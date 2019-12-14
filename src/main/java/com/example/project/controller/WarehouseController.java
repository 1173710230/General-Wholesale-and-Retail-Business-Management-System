package com.example.project.controller;

import com.example.project.domain.Goods;
import com.example.project.domain.Warehouse;
import com.example.project.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
   * @return 返回所有仓库中所有的货物
   */
  @RequestMapping(value = "/getAllGoods", method = RequestMethod.GET)
  @ResponseBody
  public List<Goods> getGoodsFromAllWarehouse(){
    return warehouseService.getGoodsFromAllWarehouse();
  }

  /**
   * 得到某个仓库中的货物
   * @param warehoueId 需要获取货物的仓库id
   * @return 返回某个仓库中所有的货物
   */
  @RequestMapping(value = "/getGoodsFromWarehouse", method = RequestMethod.GET)
  @ResponseBody
  public List<Goods> getGoodsFromWarehouse(int warehoueId){
    return warehouseService.getGoodsFromCurrentWarehouse(warehoueId);
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

  /**
   * 按照商品name在某个仓库中查找商品
   * @param name 需要查找的name
   * @param warehoseId 需要查找的商品所在的仓库id
   * @return 查找到的商品列表
   */
  @RequestMapping(value = "/queryGoodsFromCurrentWarehouseByName", method = RequestMethod.GET)
  @ResponseBody
  public List<Goods> queryGoodsFromCurrentWarehoueByName(String name, int warehoseId){
    return warehouseService.queryGoodsFromCurrentWarehouseByName(name, warehoseId);
  }

  /**
   * 添加一种新的货物到某个仓库中（Goods表中没有的货物）
   * @param goodsNumber 货物的数量
   * @param goodsName 货物的名称
   * @param spec 货物的规格
   * @param warehouseId 仓库的id
   * @return 添加成功返回true， 反之返回false
   */
  @RequestMapping(value = "/addNewGoodsToWarehouse")
  @ResponseBody
  public boolean addNewGoods(double goodsNumber, String goodsName, String spec, int warehouseId){
    return warehouseService.addNewGoods(goodsNumber, goodsName, spec, warehouseId);
  }


  /**
   * 增加某种商品在某个仓库的数量
   * @param checkGoodsId 商品的id（可能不在货物表中，这时失败）
   * @param goodsNumber 增加的货物数量
   * @param warehouseId 仓库id
   * @return 当货物表中没有这个货物，增加失败，反之成功。
   */
  @RequestMapping(value = "/addGoodsToWarehouse")
  @ResponseBody
  public boolean addGoodsToWarehouse(int checkGoodsId, double goodsNumber, int warehouseId){
    return warehouseService.addGoodsToWareHouse(checkGoodsId, goodsNumber, warehouseId);
  }

  /**
   * 将货物从一个仓库中调拨到另一个仓库中
   * @param goodsId 需要调拨的货物id
   * @param oldWarehouseId 货物从该仓库id中调拨出去
   * @param newWarehouseId 货物被调拨到这个仓库
   * @param goodsNumber 调拨的货物数量
   * @return 当货物调拨成功时，返回true，反之，返回false.
   */
  @RequestMapping(value = "/warehouseTransfer")
  @ResponseBody
  public boolean warehouseTransfer(int goodsId, int oldWarehouseId, int newWarehouseId, double goodsNumber){
    return warehouseService.warehouseTransfer(goodsId, oldWarehouseId, newWarehouseId, goodsNumber);
  }

  /**
   * 获取所有仓库
   * @return 所有仓库的List
   */
  @RequestMapping(value = "/getAllWarehouse")
  @ResponseBody
  public List<Warehouse> getAllWarehouse(){
    return warehouseService.getAllWarehouses();
  }

  /**
   * 新建一个仓库
   * @param warehouseName 仓库的名称
   * @return 新建成功返回true，失败返回false
   */
  @RequestMapping(value = "/addWarehouse")
  @ResponseBody
  public boolean addWarehouse(String warehouseName){
    return warehouseService.addWarehouse(warehouseName);
  }

  /**
   * 修改仓库名
   * @param warehouseId  仓库id
   * @param newName  新名字
   * @return  修改成功返回true，否则返回false
   */
  @RequestMapping(value = "/updateEWarehouse")
  @ResponseBody
  public boolean updateWarehouse(int warehouseId, String newName){
    return warehouseService.updateWarehouse(warehouseId, newName);
  }

  /**
   * 删除一个仓库
   * @param warehouseId  待删除的仓库的id
   * @return  删除成功返回true，否则返回false
   */
  @RequestMapping(value = "/deleteWarehouse")
  @ResponseBody
  public boolean deleteWarehouse(int warehouseId){
    return  warehouseService.deleteWarehouse(warehouseId);
  }
}
