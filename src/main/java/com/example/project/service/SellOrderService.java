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
     * 参数：包含 time， remark，type，customerId，warehouseId
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
     * 付款
     *
     */
    boolean paySellOrder(int sellOrderId);


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
}
