package com.example.project.server;

import com.example.project.domain.SellOrder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface SellOrderService {

    boolean addSellOrder(Date date, int goodsId, double sellUnitPrice, int sellsum, int customerId);

    boolean modifySellOrder(SellOrder sellOrder);

    boolean deleteSellOrder(int sellOrderId);

    List<SellOrder> getuncheckedSellOrder();

    boolean checkOrder(int sellOrderId);

    boolean receiptSellOrder(int sellOrderId);

    boolean refundSellOrder(int sellOrderId);

    List<SellOrder> getuncheckedOrder();

    List<SellOrder> getunreceiptedOrder();

}
