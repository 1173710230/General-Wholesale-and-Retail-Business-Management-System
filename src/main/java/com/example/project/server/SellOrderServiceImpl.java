package com.example.project.server;

import com.example.project.domain.SellOrder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SellOrderServiceImpl implements SellOrderService{

    @Override
    public boolean addSellOrder(Date date, int goodsId, double sellUnitPrice, int sellsum, int customerId) {
        return false;
    }

    @Override
    public boolean modifySellOrder(SellOrder sellOrder) {
        return false;
    }

    @Override
    public boolean deleteSellOrder(int sellOrderId) {
        return false;
    }

    @Override
    public List<SellOrder> getuncheckedSellOrder() {
        return null;
    }

    @Override
    public boolean checkOrder(int sellOrderId) {
        return false;
    }

    @Override
    public boolean receiptSellOrder(int sellOrderId) {
        return false;
    }

    @Override
    public boolean refundSellOrder(int sellOrderId) {
        return false;
    }

    @Override
    public List<SellOrder> getuncheckedOrder() {
        return null;
    }

    @Override
    public List<SellOrder> getunreceiptedOrder() {
        return null;
    }
}
