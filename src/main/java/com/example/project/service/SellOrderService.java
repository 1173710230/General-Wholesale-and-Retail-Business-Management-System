package com.example.project.service;

import com.example.project.domain.SellOrder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface SellOrderService {


    /**
     * 添加一个销售单
     *
     */
    boolean addSellOrder(Date date, int goodsId, double sellUnitPrice, int sellSum, int customerId, String remark);


    /**
     * 更新销售单，变化内容存到参数中
     *
     */
    boolean modifySellOrder(SellOrder sellOrder);


    /**
     * 按id删除销售单
     *
     */
    boolean deleteSellOrder(int sellOrderId);


    /**
     * 获取未确认的销售单
     *
     */
    List<SellOrder> getUncheckedSellOrder();


    /**
     * 审核销售单
     *
     */
    boolean checkOrder(int sellOrderId, boolean opinion);


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
     * 获取未付款的订单
     *
     */
    List<SellOrder> getUnpaidOrder();

}
