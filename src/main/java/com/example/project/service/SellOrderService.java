package com.example.project.service;

import com.example.project.domain.SellOrder;
import com.example.project.domain.SellOrderGroup;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface SellOrderService {


    /**
     * 添加一个销售单对象
     * 参数：包含 time， remark，type，customerId，warehouseId ,list<sellOrder>
     *
     */
    boolean addSellOrder(SellOrderGroup newSellOrderGroup);


    /**
     * 更新销售单，变化内容存到参数中
     *
     */
    boolean modifySellOrder(SellOrderGroup sellOrderGroup);


    /**
     * 按id删除销售单
     *
     */
    boolean deleteSellOrder(int sellOrderId);


    /**
     * 获取未确认的销售单
     *
     */
    List<SellOrderGroup>  getUncheckedSellOrder();


    /**
     * 审核销售单
     *
     */
    boolean checkOrder(int sellOrderGroupId, boolean opinion);


    /**
     * 销售单付款
     * @param sellOrderId 销售单的id
     * @param payType 销售的付款方式， 0账户付款，1现金付款
     * @return 付款是否成功
     */
    boolean paySellOrder(int sellOrderId, int payType);


    /**
     * 按id退款
     *
     */
    boolean refundSellOrder(int sellOrderId);


    /**
     * 获取未付款（审核成功）的订单
     *
     */
    List<SellOrderGroup>  getUnpaidOrder();

    /**
     * 获取已付款未退款的订单
     *
     */
    List<SellOrderGroup>  getUnRefundOrder();

    /**
     * 获取销售单总价
     *
     */
    Double getSellOrderGroupTotalPrice(int sellOrderGroupId);

    /**
     * 获取销售单利润
     *
     */
    Double getSellOrderGroupProfit(int sellOrderGroupId);

    /**
     * 获取全部批发单
     */
    List<SellOrderGroup> getAllWholeSaleOrder();

    /**
     * 获取全部零售单
     */
    List<SellOrderGroup> getAllRetailOrder();

    /**
     * 以货品等为索引，统计销售情况
     */
    List<SellOrderGroup>  statisticsSalesByGoodsId(int goodsId);

    /**
     * 以客户等为索引，统计销售情况
     */
    List<SellOrderGroup>  statisticsSalesByCustomerId(int customerId);


}
