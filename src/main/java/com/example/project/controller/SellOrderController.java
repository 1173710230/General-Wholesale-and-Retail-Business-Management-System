package com.example.project.controller;

import com.example.project.domain.SellOrder ;
import com.example.project.domain.SellOrderGroup;
import com.example.project.service.SellOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 这是一个销售单的controller模块，实现销售单的增删改查和状态变化等功能
 *
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
   * 将构造一个新销售单传递给后台
   *
   * @param warehouseId 销售单的仓库id
   * @param sellOrderType 销售单的类型 //0批发，1零售
   * @param sellOrderRemark 销售单的备注
   * @param customerId 顾客id
   * @param goodsId 商品的id字符串，使用","分隔（有顺序）
   * @param sellUnitPrice 商品的单价数组，使用","分隔（有顺序）
   * @param goodsNumber 商品的数量数组，使用","分隔（有顺序）
   * @return 销售单添加成功返回true，反之返回false
   */
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  @ResponseBody
  public boolean addSellOrderGroup(int warehouseId, int sellOrderType, String sellOrderRemark, int customerId,
                                   String goodsId, String sellUnitPrice,String goodsNumber){
    List<SellOrder>  allSellOrderInGroup = new ArrayList<>();

    String[] goodsIds = goodsId.split(",");
    String[] sellUnitPrices = sellUnitPrice.split(",");
    String[] goodsNumbers = goodsNumber.split(",");

    for(int i = 0; i< goodsIds.length; i++){
      allSellOrderInGroup.add(new SellOrder(-1, Double.valueOf(goodsNumbers[i]), Double.valueOf(sellUnitPrices[i]), Integer.valueOf(goodsIds[i])));
    }

    Date date = new Date(System.currentTimeMillis());
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //id = -1 表示无id， status为-1 表示异常状态，就只是为了修改使用，salary，profit同理，下层不使用id和状态等进行修改，只考虑其他属性
    return sellOrderService.addSellOrder(new SellOrderGroup(-1, format.format(date),
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
   * 更新一个销售单的信息（商品单id和销售单的状态不改变）
   * @param warehouseId 销售单的仓库id
   * @param sellOrderType 销售单的类型 //0批发，1零售
   * @param sellOrderRemark 销售单的备注
   * @param customerId 顾客id
   * @param goodsId 商品的id字符串，使用","分隔（有顺序）
   * @param sellUnitPrice 商品的单价数组，使用","分隔（有顺序）
   * @param goodsNumber 商品的数量数组，使用","分隔（有顺序）
   * @return 更新成返回true，反之，返回false
   */
  @RequestMapping(value = "/updateSellOrder", method = RequestMethod.GET)
  @ResponseBody
  public boolean update(int warehouseId, int sellOrderType, String sellOrderRemark, int customerId,
                        String goodsId, String sellUnitPrice,String goodsNumber){
    List<SellOrder> allSellOrderInGroup = new ArrayList<>();

    String[] goodsIds = goodsId.split(",");
    String[] sellUnitPrices = sellUnitPrice.split(",");
    String[] goodsNumbers = goodsNumber.split(",");

    for(int i = 0; i< goodsIds.length; i++){
      allSellOrderInGroup.add(new SellOrder(-1, Double.valueOf(goodsNumbers[i]), Double.valueOf(sellUnitPrices[i]), Integer.valueOf(goodsIds[i])));
    }

    Date date = new Date(System.currentTimeMillis());
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //id = -1 表示无id， status为-1 表示异常状态，就只是为了修改使用，salary，profit同理，下层不使用id和状态等进行修改，只考虑其他属性
    return sellOrderService.modifySellOrder(new SellOrderGroup(-1, format.format(date),
        sellOrderRemark, sellOrderType, -1, allSellOrderInGroup, customerId, -1.0, warehouseId, -1.0));
  }

  /**
   * 得到所有的未审核的订单
   * @return 返回当前未审核的销售单，
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
   * 审核一个销售单是否通过审核（只允许经理，店长check，不允许店员check）
   * @param sellOrderId 需要审核的销售单
   * @param opinion 审核通过传入true，反之，传入false
   * @return 只要opinion和内部审核时有一个没通过返回false
   */
  @RequestMapping("/checkOrder")
  @ResponseBody
  public boolean checkOrder(int sellOrderId, boolean opinion){
    return sellOrderService.checkOrder(sellOrderId, opinion) && opinion;
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
   * 对销售单进行退款(只允许经理退款，不允许店长，店员退款）
   * @param sellOrderId 需要退款的销售单
   * @return 退款成功返回true， 反之返回false
   */
  @RequestMapping("/refund")
  @ResponseBody
  public boolean refundSellOrder(int sellOrderId){
    return sellOrderService.refundSellOrder(sellOrderId);
  }

}
