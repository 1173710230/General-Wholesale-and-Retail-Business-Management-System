package com.example.project.service;

import com.example.project.dao.GoodsMapper;
import com.example.project.dao.SellOrderMapper;
import com.example.project.domain.Goods;
import com.example.project.domain.SellOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SellOrderServiceImpl implements SellOrderService {

    private final SellOrderMapper sellOrderMapper;

    private final GoodsMapper goodsMapper;

    @Autowired
    public SellOrderServiceImpl(SellOrderMapper sellOrderMapper, GoodsMapper goodsMapper) {
        this.sellOrderMapper = sellOrderMapper;
        this.goodsMapper = goodsMapper;
    }

    @Override
    public boolean addSellOrder(Date date, int goodsId, double sellUnitPrice, Double sellNumber, int customerId, String remark) {
        SellOrder sellOrder = new SellOrder();
        sellOrder.setSellGoodsId(goodsId);
        //sellOrder.setSellTime(new SimpleDateFormat().format(date));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sellOrder.setSellTime(format.format(date));
        sellOrder.setSellUnitPrice(sellUnitPrice);
        sellOrder.setSellStatus(1);
        sellOrder.setCustomerId(customerId);
        sellOrder.setSellOrderRemark(remark);
        sellOrder.setSellNumber(sellNumber);
        // 新建进货单
        sellOrderMapper.addSellOrder(sellOrder);
        SellOrder sellOrder1 = new SellOrder();
        sellOrder1.setSellOrderId(sellOrder.getSellOrderId());
        sellOrder1.setCustomerId(customerId);
        //关联进货单与客户id
        sellOrderMapper.addSellOrderCustomerRelation(sellOrder1);
        return true;
    }

    @Override
    public boolean modifySellOrder(SellOrder sellOrder) {
        try {
            // 传入动态定义对象更新信息
            sellOrderMapper.updateSellOrder(sellOrder);
            return true;
        } catch (DataAccessException ex) {
            // 不存在这一订货单
            return false;
        }
    }

    @Override
    public boolean deleteSellOrder(int sellOrderId) {
        try {
            // 删除此id的订货单
            SellOrder order = sellOrderMapper.getSellOrderById(sellOrderId);
            if(order.getSellStatus() == 2 || order.getSellStatus() == 4)
                goodsMapper.addNumber(order.getSellGoodsId(),order.getSellNumber());
            sellOrderMapper.deleteSellOrder(sellOrderId);
            return true;
        } catch (DataAccessException ex) {
            //销售单不再数据库中
            return false;
        }
    }


    @Override
    public List<SellOrder> getUncheckedSellOrder() {
        // 获取未审核的订单
        SellOrder uncheckedOrder = new SellOrder();
        uncheckedOrder.setSellStatus(1);
        return sellOrderMapper.querySellOrder(uncheckedOrder);
    }

    @Override
    public boolean checkOrder(int sellOrderId, boolean opinion) {
        SellOrder order = sellOrderMapper.getSellOrderById(sellOrderId);
        assert order != null;   // 这个销售单必然存在，不然就是出错的
        // 如果opinion是false，不管库存够不够，都是审核不通过的
        if (!opinion) {
            return changeStatus(sellOrderId, 3);    // 这里审核不通过
        } else {
            // 用户点击了通过审核
            // 获得销售单填写的销量
            double sellNumber = order.getSellNumber();

            // 判断一个仓库的库存够不够，如果够，才允许审核通过，不够的话不允许审核通过
            Integer goodsId = order.getSellGoodsId();
            Goods goods = new Goods();
            goods.setGoodsId(goodsId);
            // V1.0 查询出来的是仓库1的库存
            List<Goods> goodsList = goodsMapper.queryGoods(goods);
            if (goodsList != null && goodsList.size() > 0) {
                // 查询到了这个货物的信息
                Goods result = goodsList.get(0);
                double stock = result.getGoodsNumber(); // 库存
                if (stock >= sellNumber) {
                    // 数量足够
                    // 减少库存
                    goodsMapper.reduceNumber(goodsId, sellNumber);
                    // 更改销售单状态
                    return changeStatus(sellOrderId, 2);
                } else {
                    // 数量不够，不允许审核通过
                    return false;
                }
            } else {
                // 没有这个货物的ID，正常情况下应该不会走到这里
                return false;
            }
        }

    }

    @Override
    public boolean paySellOrder(int sellOrderId) {
        return changeStatus(sellOrderId, 4);
    }

    @Override
    public boolean refundSellOrder(int sellOrderId) {
        SellOrder order = sellOrderMapper.getSellOrderById(sellOrderId);
        goodsMapper.addNumber(order.getSellGoodsId(),order.getSellNumber());
        return changeStatus(sellOrderId, 5);
    }

    @Override
    public List<SellOrder> getUnpaidOrder() {
        SellOrder uncheckedOrder = new SellOrder();
        uncheckedOrder.setSellStatus(2);
        return sellOrderMapper.querySellOrder(uncheckedOrder);
    }

    @Override
    public List<SellOrder> getUnRefundOrder() {
        SellOrder uncheckedOrder = new SellOrder();
        uncheckedOrder.setSellStatus(4);
        return sellOrderMapper.querySellOrder(uncheckedOrder);
    }
    /*----------------------------------------------------------*/

    /**
     * 修改状态，因为经常用所以就加了一个这个方便些。
     *
     * @param orderId 待修改的ID
     * @param status  新的状态
     * @return 成功true，否则false
     */
    private boolean changeStatus(int orderId, int status) {
        try {
            SellOrder order = new SellOrder();
            order.setSellOrderId(orderId);
            order.setSellStatus(status);
            sellOrderMapper.updateSellOrder(order);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }


}
