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
public class checkoutCounter {
  @Autowired
  private final SellOrderService sellOrderService;
  private List<SellOrder> currentSellOrders = new ArrayList<>();

  public checkoutCounter(SellOrderService sellOrderService) {
    this.sellOrderService = sellOrderService;
  }

  /**
   * 增加一个销售销售记录，并不传递给后台，只是暂存在controller中，等到添加一个完整的销售单时，
   * 一并传递给后台（由addSellOrder完成）
   *
   * @param goodsId 销售记录中商品的id
   * @param sellUnitPrice 商品的单价
   * @param goodsNumber 某种商品的数量
   * @return 当数量大于0，返回true，其他返回false.
   */
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  @ResponseBody
  public boolean addSellOrder(int goodsId, double sellUnitPrice, double goodsNumber){
    currentSellOrders.add(new SellOrder(-1, goodsNumber, sellUnitPrice, goodsId)); //因为我不知道sellOrderId，所以置成-1，之后service要改
    return goodsNumber>0;//goodsNumber>0 && sellOrderService.addSellOrder(new Date(System.currentTimeMillis()), goodsId, sellUnitPrice, goodsNumber, customerId, remark);
  }

  /**
   * 将销售记录构造一个销售单传递给后台，并清除当前暂存的销售记录
   *
   * @param warehouseId 销售单的仓库id
   * @param sellOrderType 销售单的类型 //0批发，1零售
   * @param sellOrderRemark 销售单的备注
   * @param customerId 顾客id
   * @return 销售单添加成功返回true，反之返回false
   */
  @RequestMapping(value = "/addNewSellOrder", method = RequestMethod.GET)
  @ResponseBody
  public boolean addSellOrderGroup(int warehouseId, int sellOrderType, String sellOrderRemark, int customerId){
    List<SellOrder> allSellOrderInGroup = new ArrayList<>(currentSellOrders);
    currentSellOrders.clear();  //清除当前销售记录
    //id = -1 表示无id， status为-1 表示异常状态，就只是为了修改使用，salary，profit同理，下层不使用id和状态等进行修改，只考虑其他属性
    return sellOrderService.addSellOrder(new SellOrderGroup(-1, new Date(System.currentTimeMillis()).toLocaleString(),
        sellOrderRemark, sellOrderType, -1, allSellOrderInGroup, customerId, -1.0, warehouseId, -1.0));
  }

  /**
   * 对零售单计算总价
   * @param sellOrderId 销售单的id
   * @return 零售单的总价
   */
  @RequestMapping(value = "/getTotalPrice", method = RequestMethod.GET)
  @ResponseBody
  public Double getSellOrderGroupTotalPrice(int sellOrderId){
    return sellOrderService.getSellOrderGroupTotalPrice(sellOrderId);
  }

  /**
   * 对零售的销售单计算利润
   * @param sellOrderId 销售单的id
   * @return 零售单的利润
   */
  @RequestMapping(value = "/getProfit", method = RequestMethod.GET)
  @ResponseBody
  public Double getSellOrderGroupProfit(int sellOrderId){
    return sellOrderService.getSellOrderGroupProfit(sellOrderId);
  }
}
