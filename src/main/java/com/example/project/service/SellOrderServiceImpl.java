package com.example.project.service;

import com.example.project.dao.GoodsMapper;
import com.example.project.dao.SellOrderMapper;
import com.example.project.domain.Goods;
import com.example.project.domain.SellOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SellOrderServiceImpl implements SellOrderService{

    private final SellOrderMapper sellOrderMapper;

    private final GoodsMapper goodsMapper;

    @Autowired
    public SellOrderServiceImpl(SellOrderMapper sellOrderMapper, GoodsMapper goodsMapper) {
        this.sellOrderMapper = sellOrderMapper;
        this.goodsMapper = goodsMapper;
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
    public boolean checkOrder(int sellOrderId, boolean opinion) {
        SellOrder order = sellOrderMapper.getSellOrderById(sellOrderId);
        Integer goodsId = order.getSellGoodsId();
        Goods goods = new Goods();
        goods.setGoodsId(goodsId);
        if (!opinion) {
            List<Goods> goodsList = goodsMapper.queryGoods(goods);
            changeStatus(sellOrderId, 3);
            return goodsList.get(0).getGoodsNumber() > 0;
        }
        List<Goods> goodsList = goodsMapper.queryGoods(goods);
        if (goodsList.size() > 0) {
            if (goodsList.get(0).getGoodsNumber() > 0) {
                // 这时候可以确定库存 > 0
                return changeStatus(sellOrderId, 2);
            } else {
                // 没库存了，返回false
                return false;
            }
        } else {
            // 没有这个销售单ID，正常情况下应该不会走到这里
            return false;
        }
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
