package com.example.project.controller;

import com.example.project.domain.SellOrder ;
import com.example.project.domain.SellOrderGroup;
import com.example.project.service.SellOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 这是一个销售单的controller模块，实现销售单的增删改查和状态变化等功能
 * todo: 涉及user身份信息的部分未完成
 */
@Controller
@RequestMapping("/sellOrder")
public class SellOrderController {

 private final SellOrderService sellOrderService;

 //currentSellOrders里存储当前增加处理的销售订单的销售记录.只能同时增加一个订单
  private List<SellOrder> currentSellOrders = new ArrayList<>();
  //currentSellOrders里存储当前修改处理的销售订单的销售记录，只能同时修改一个订单
  private List<SellOrder> currentModifySellOrders = new ArrayList<>();

  @Autowired
  public SellOrderController(SellOrderService sellOrderService) {
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
   List<SellOrder>  allSellOrderInGroup = new ArrayList<>(currentSellOrders);
   currentSellOrders.clear();  //清除当前销售记录
   //id = -1 表示无id， status为-1 表示异常状态，就只是为了修改使用，salary，profit同理，下层不使用id和状态等进行修改，只考虑其他属性
   return sellOrderService.addSellOrder(new SellOrderGroup(-1, new Date(System.currentTimeMillis()).toLocaleString(),
       sellOrderRemark, sellOrderType, -1, allSellOrderInGroup, customerId, -1.0, warehouseId, -1.0));
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
   * 修改一条销售记录，并将结果暂存在controller(前端多次调用，没修改的要填上原来的默认值)
   *
   * @param sellNumber 销售记录的销售数量
   * @param sellUnitPrice 销售的单价
   * @param sellGoodsId 销售的商品id
   * @return sellNumber是否大于0
   */
  public boolean updateSellOrder(double sellNumber, double sellUnitPrice, int sellGoodsId){
    currentModifySellOrders.add(new SellOrder(-1, sellNumber, sellUnitPrice, sellGoodsId)); //因为我不知道sellOrderId，所以置成-1，之后service要改
    return sellNumber>0;
  }

  /**
   * 更新一个销售单的信息（商品单id和销售单的状态不改变）
   * @param warehouseId 仓库id
   * @param sellOrderType 销售的类型
   * @param sellOrderRemark 销售单的备注
   * @param customerId 顾客id
   * @return 更新成返回true，反之，返回false
   */
  @RequestMapping(value = "/updateNewSellOrder", method = RequestMethod.GET)
  @ResponseBody
  public boolean update(int warehouseId, int sellOrderType, String sellOrderRemark, int customerId){
    List<SellOrder> allSellOrderInGroup = new ArrayList<>(currentModifySellOrders);
    currentModifySellOrders.clear();
    //id = -1 表示无id， status为-1 表示异常状态，就只是为了修改使用，salary，profit同理，下层不使用id和状态等进行修改，只考虑其他属性
    return sellOrderService.modifySellOrder(new SellOrderGroup(-1, new Date().toLocaleString(),
        sellOrderRemark, sellOrderType, -1, allSellOrderInGroup, customerId, -1.0, warehouseId, -1.0));
  }

  /**
   * 得到所有的未审核的订单
   * @return 返回当前未审核的销售单
   */
  @RequestMapping("/getAllSellOrderUnderCheck")
  @ResponseBody
  public List<SellOrderGroup> allSellOrderUnderCheck(){
    return sellOrderService.getUncheckedSellOrder();
  }

  /**
   * 得到所有的未付款的订单
   * @return 返回所有的未付款的订单
   */
  @RequestMapping("/getUnreceiptedOrder")
  @ResponseBody
  public List<SellOrderGroup> getUnreceiptedOrder(){
    return sellOrderService.getUnpaidOrder();
  }

  /**
   * 得到所有的已付款未退款的订单
   * @return 返回所有的已付款的订单
   */
  @RequestMapping("/getRefundSellOrder")
  @ResponseBody
  public List<SellOrderGroup> getRefundSellOrder(){
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
    return sellOrderService.checkOrder(sellOrderId, opinion, 0)&&opinion;
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
