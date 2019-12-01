package com.example.project.controller;

import com.example.project.domain.SellOrder ;
import com.example.project.service.SellOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 这是一个销售单的controller模块，实现销售单的增删改查和状态变化等功能
 */
@Controller
@RequestMapping("/sellOrder")
public class SellOrderController {

 private final SellOrderService sellOrderService;

  @Autowired
  public SellOrderController(SellOrderService sellOrderService) {
    this.sellOrderService = sellOrderService;
  }

  /**
   * 增加一个销售单
   * @param goodsId 销售单中商品的id
   * @param sellUnitPrice 商品的单价
   * @param goodsNumber 实际上是总数量
   * @param customerId 顾客的id
   * @param remark 备注
   * @return 当总数量大于0和增加销售单成功时，返回true，其他返回false.
   */
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  @ResponseBody
  public boolean addSellOrder(int goodsId, double sellUnitPrice, double goodsNumber, int customerId, String remark){
    return goodsNumber>0 && sellOrderService.addSellOrder(new Date(System.currentTimeMillis()), goodsId, sellUnitPrice, goodsNumber, customerId, remark);
  }

  /**
   * 删除一个商品的订单
   * @param id 订单的id
   * @return 删除成功返回true，失败返回false
   */
  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  @ResponseBody
  public boolean deleteSellOrder(int id){
    return sellOrderService.deleteSellOrder(id);
  }

  /**
   * 更新一个销售单的信息（商品单id和销售单的状态不改变）
   * @param goodsNumber 销售单的数量
   * @param sellUnitPrice 销售商品的单价
   * @param remark 备注
   * @param goodsId 商品的id
   * @param customerId 顾客的id
   */
  @RequestMapping(value = "/update", method = RequestMethod.GET)
  @ResponseBody
  public boolean update(double goodsNumber, double sellUnitPrice, String remark, int goodsId, int customerId){
    //id = -1 表示无id， status为-1 表示异常状态，就只是为了修改使用，下层不使用id和状态进行修改，只考虑其他属性
    return  sellOrderService.modifySellOrder(new SellOrder(-1, goodsNumber, sellUnitPrice, -1,
        new Date(System.currentTimeMillis()).toLocaleString(), remark, goodsId, customerId));
  }

  /**
   * 得到所有的未审核的订单
   * @return 返回当前未审核的销售单
   */
  @RequestMapping("/getAllSellOrderUnderCheck")
  @ResponseBody
  public List<SellOrder> allSellOrderUnderCheck(){
    return sellOrderService.getUncheckedSellOrder();
  }

  /**
   * 得到所有的未付款的订单
   * @return 返回所有的未付款的订单
   */
  @RequestMapping("/getUnreceiptedOrder")
  @ResponseBody
  public List<SellOrder> getUnreceiptedOrder(){
    return sellOrderService.getUnpaidOrder();
  }

  /**
   * 得到所有的已付款未退款的订单
   * @return 返回所有的已付款的订单
   */
  @RequestMapping("/getRefundSellOrder")
  @ResponseBody
  public List<SellOrder> getRefundSellOrder(){
    return sellOrderService.getUnRefundOrder();
  }

  /**
   * 审核一个销售单是否通过审核
   * @param sellOrderId 需要审核的销售单
   * @param opinion 审核通过传入true，反之，传入false
   * @return 只要opinion和内部审核时有一个没通过返回false
   */
  @RequestMapping("/checkOrder")
  @ResponseBody
  public boolean checkOrder(int sellOrderId, boolean opinion){
    return sellOrderService.checkOrder(sellOrderId, opinion)&&opinion;
  }

  /**
   * 对销售单进行收款
   * @param sellOrderId 需要收款的销售单
   * @return 收款是否成功
   */
  @RequestMapping("/receipt")
  @ResponseBody
  public boolean receiptSellOrder(int sellOrderId){
    return sellOrderService.paySellOrder(sellOrderId);
  }

  /**
   * 对销售单进行退款
   * @param sellOrderId 需要退款的销售单
   * @return 退款是否成功
   */
  @RequestMapping("/refund")
  @ResponseBody
  public boolean refundSellOrder(int sellOrderId){
    return sellOrderService.refundSellOrder(sellOrderId);
  }


}
