package com.example.project.controller;

import com.example.project.domain.SellOrder ;
import com.example.project.domain.SellOrderGroup;
import com.example.project.service.SellOrderService;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
public class SellOrderController{

  private final SellOrderService sellOrderService;
  private final UserService userService;

  @Autowired
  public SellOrderController(SellOrderService sellOrderService, UserService userService) {
    this.sellOrderService = sellOrderService;
    this.userService = userService;
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
   * @param isFree 商品是否为赠品，传递一个字符串，是传递“1”，不是传递“0”，使用","分隔（有顺序）；
   *               例：第一个是，第二个不是，第三个是赠品，传递“1,0,1”
   * @param discount 销售单的整体折扣
   * @return 销售单添加成功返回true，反之返回false
   */
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  @ResponseBody
  public boolean addSellOrderGroup(int warehouseId, int sellOrderType, String sellOrderRemark, int customerId,
                                   String goodsId, String sellUnitPrice,String goodsNumber, String isFree, double discount){
    List<SellOrder>  allSellOrderInGroup = new ArrayList<>();

    String[] goodsIds = goodsId.split(",");
    String[] sellUnitPrices = sellUnitPrice.split(",");
    String[] goodsNumbers = goodsNumber.split(",");
    String[] isFrees = isFree.split(",");

    for(int i = 0; i< goodsIds.length; i++){
      if (Integer.parseInt(isFrees[i])==0){
        allSellOrderInGroup.add(new SellOrder(-1, Double.valueOf(goodsNumbers[i]), 0.0, Integer.valueOf(goodsIds[i])));
      }else{
        allSellOrderInGroup.add(new SellOrder(-1, Double.valueOf(goodsNumbers[i]), Double.valueOf(sellUnitPrices[i]), Integer.valueOf(goodsIds[i])));
      }
    }

    Date date = new Date(System.currentTimeMillis());
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //id = -1 表示无id， status为-1 表示异常状态，就只是为了修改使用，salary，profit同理，下层不使用id和状态等进行修改，只考虑其他属性
    return sellOrderService.addSellOrder(new SellOrderGroup(-1, format.format(date),
        sellOrderRemark, sellOrderType, -1, allSellOrderInGroup, customerId, -1.0, warehouseId, -1.0, discount));
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
   * @param sellOrderGroupId 要修改销售单的id
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
  public boolean update(int sellOrderGroupId, int warehouseId, int sellOrderType, String sellOrderRemark, int customerId,
                        String goodsId, String sellUnitPrice,String goodsNumber){
    List<SellOrder> allSellOrderInGroup = new ArrayList<>();

    String[] goodsIds = goodsId.split(",");
    String[] sellUnitPrices = sellUnitPrice.split(",");
    String[] goodsNumbers = goodsNumber.split(",");

    for(int i = 0; i< goodsIds.length; i++){
      allSellOrderInGroup.add(new SellOrder(null, Double.valueOf(goodsNumbers[i]), Double.valueOf(sellUnitPrices[i]), Integer.valueOf(goodsIds[i])));
    }

    Date date = new Date(System.currentTimeMillis());
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return sellOrderService.modifySellOrder(new SellOrderGroup(sellOrderGroupId, format.format(date),
        sellOrderRemark, sellOrderType, 1, allSellOrderInGroup, customerId, -1.0, warehouseId, -1.0));
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
   * 得到所有的未付款批发单
   * @return 返回所有的未付款批发单
   */
  @RequestMapping("/getUnreceiptedOrder")
  @ResponseBody
  public List<SellOrderGroup> getUnreceiptedOrder(){
    return sellOrderService.getUnpaidOrder();
  }

  /**
   * 得到所有的未付款零售单
   * @return 返回所有的未付款零售单
   */
  @RequestMapping("/getUnpaidRetailOrder")
  @ResponseBody
  List<SellOrderGroup>  getUnpaidRetailOrder(){
    return sellOrderService.getUnpaidRetailOrder();
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
   * @param httpSession session对象前端自动传递
   * @param opinion 审核通过传入true，反之，传入false
   * @return 只要opinion和内部审核时有一个没通过返回false
   */
  @RequestMapping("/checkOrder")
  @ResponseBody
  public boolean checkOrder(HttpSession httpSession, int sellOrderId, boolean opinion){
    int userStatus = userService.getUserByName((String) httpSession.getAttribute("userName")).getStatus();
    System.out.println(userStatus);
    if(userStatus==0||  userStatus==1){ //只允许经理，店长check
      return sellOrderService.checkOrder(sellOrderId, opinion) && opinion;
    }else{ //不允许店员check
      return false;
    }
  }

  /**
   * 对销售单进行收款
   * @param sellOrderId 需要收款的销售单
   * @param payType 收款方式
   * @return 收款是否成功
   */
  @RequestMapping("/receipt")
  @ResponseBody
  public boolean receiptSellOrder(int sellOrderId, int payType){
    return sellOrderService.paySellOrder(sellOrderId, payType);
  }

  /**
   * 对销售单进行退款(只允许经理退款，不允许店长，店员退款）
   * @param httpSession session对象前端自动传递
   * @param sellOrderId 需要退款的销售单
   * @return 退款成功返回true， 反之返回false
   */
  @RequestMapping("/refund")
  @ResponseBody
  public boolean refundSellOrder(HttpSession httpSession, int sellOrderId){
    int userStatus = userService.getUserByName((String) httpSession.getAttribute("userName")).getStatus();
    if(userStatus==0){//只允许经理退款
      return sellOrderService.refundSellOrder(sellOrderId);
    }else { //不允许店长，店员退款
      return false;
    }
  }

  /**
   * 按照商品的id进行统计销售情况
   * @param goodsId 商品id
   * @return 包含该商品id的所有销售单
   */
  @RequestMapping("/statisticsSalesByGoodsId")
  @ResponseBody
  public List<SellOrderGroup>  statisticsSalesByGoodsId(int goodsId){
    return sellOrderService.statisticsSalesByGoodsId(goodsId);
  }

  /**
   * 按照顾客的id进行统计销售情况
   * @param customerId 顾客的id
   * @return 该顾客消费的所有订单
   */
  @RequestMapping("/statisticsSalesByCustomerId")
  @ResponseBody
  public List<SellOrderGroup>  statisticsSalesByCustomerId(int customerId){
    return sellOrderService.statisticsSalesByCustomerId(customerId);
  }

  /**
   * 修改消费获得积分的规则
   * @param integralRatio 每消费1元获得多少积分
   * @return 修改是否成功
   */
  @RequestMapping("/changeIntegralRatio")
  @ResponseBody
  public boolean changeIntegralRatio(double integralRatio){
    return sellOrderService.changeIntegralRatio(integralRatio);
  }

}
