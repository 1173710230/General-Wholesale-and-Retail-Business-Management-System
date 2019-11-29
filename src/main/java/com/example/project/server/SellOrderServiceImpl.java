package com.example.project.server;

import com.example.project.dao.SellOrderMapper;
import com.example.project.domain.SellOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SellOrderServiceImpl implements SellOrderService{

    private final SellOrderMapper sellOrderMapper;

    public SellOrderServiceImpl(SellOrderMapper sellOrderMapper) {
        this.sellOrderMapper = sellOrderMapper;
    }

    @Override
    public boolean addSellOrder(Date date, int goodsId, double sellUnitPrice, int sellSum, int customerId) {
        return false;
    }

    @Override
    public boolean modifySellOrder(SellOrder sellOrder) {
        try {
            sellOrderMapper.updateSellOrder(sellOrder);
            return true;
        } catch (DataAccessException ex) {
            return false;
        }
    }

    @Override
    public boolean deleteSellOrder(int sellOrderId) {
        try {
            sellOrderMapper.deleteSellOrder(sellOrderId);
            return true;
        } catch (DataAccessException ex) {
            return false;
        }
    }


    @Override
    public List<SellOrder> getUncheckedSellOrder() {
        SellOrder uncheckedOrder = new SellOrder();
        uncheckedOrder.setSellStatus(1);
        return sellOrderMapper.querySellOrder(uncheckedOrder);
    }

    @Override
    public boolean checkOrder(int sellOrderId) {
        return changeStatus(sellOrderId, 2);
    }



    @Override
    public boolean paySellOrder(int sellOrderId) {
        return changeStatus(sellOrderId, 4);
    }

    @Override
    public boolean refundSellOrder(int sellOrderId) {
        return changeStatus(sellOrderId, 5);
    }

    @Override
    public List<SellOrder> getUnpaidOrder() {
        SellOrder uncheckedOrder = new SellOrder();
        uncheckedOrder.setSellStatus(2);
        return sellOrderMapper.querySellOrder(uncheckedOrder);
    }

    /*----------------------------------------------------------*/
    /**
     * 修改状态，因为经常用所以就加了一个这个方便些。
     * @param orderId   待修改的ID
     * @param status    新的状态
     * @return  成功true，否则false
     */
    private boolean changeStatus(int orderId, int status) {
        try {
            SellOrder order = new SellOrder();
            order.setSellOrderId(orderId);
            order.setSellStatus(status);
            sellOrderMapper.updateSellOrder(order);
            return true;
        } catch (DataAccessException ex) {
            return false;
        }
    }


}
