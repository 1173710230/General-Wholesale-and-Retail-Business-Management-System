package com.example.project.server;

import com.example.project.domain.SellOrder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface SellOrderService {

    boolean addSellOrder(Date date, int goodsId, double sellUnitPrice, int sellSum, int customerId);

    boolean modifySellOrder(SellOrder sellOrder);

    boolean deleteSellOrder(int sellOrderId);

    List<SellOrder> getUncheckedSellOrder();

    boolean checkOrder(int sellOrderId);

    boolean paySellOrder(int sellOrderId);

    boolean refundSellOrder(int sellOrderId);

    List<SellOrder> getUnpaidOrder();

}
