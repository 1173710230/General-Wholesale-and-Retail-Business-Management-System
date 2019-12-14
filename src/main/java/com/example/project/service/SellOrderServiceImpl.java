package com.example.project.service;

import com.example.project.dao.GoodsMapper;
import com.example.project.dao.SellOrderGroupMapper;
import com.example.project.dao.SellOrderMapper;
import com.example.project.domain.Goods;
import com.example.project.domain.SellOrder;
import com.example.project.domain.SellOrderGroup;
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

    private final SellOrderGroupMapper sellOrderGroupMapper;

    @Autowired
    public SellOrderServiceImpl(SellOrderMapper sellOrderMapper, GoodsMapper goodsMapper, SellOrderGroupMapper sellOrderGroupMapper) {
        this.sellOrderMapper = sellOrderMapper;
        this.goodsMapper = goodsMapper;
        this.sellOrderGroupMapper = sellOrderGroupMapper;
    }

    @Override
    public boolean addSellOrder(SellOrderGroup newSellOrderGroup) {
        //sellOrder.setSellTime(new SimpleDateFormat().format(date));

        SellOrderGroup sellOrderGroup = new SellOrderGroup();
        sellOrderGroup.setSellOrderRemark(newSellOrderGroup.getSellOrderRemark());
        sellOrderGroup.setCustomerId(newSellOrderGroup.getCustomerId());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sellOrderGroup.setSellTime(format.format(newSellOrderGroup.getSellTime()));
        sellOrderGroup.setSalary(0.0);
        sellOrderGroup.setProfit(0.0);
        sellOrderGroup.setSellStatus(0);
        sellOrderGroup.setSellOrderType(newSellOrderGroup.getSellOrderType());
        sellOrderGroup.setWarehouseId(newSellOrderGroup.getWarehouseId());
        // 新建进货单
        sellOrderGroupMapper.insertSellOrderGroup(sellOrderGroup);
        // sellOrderGroupMapper.addSellOrderCustomerRelation(sellOrderGroup);
        //关联进货单与客户id
        return true;
    }

    @Override
    public boolean modifySellOrder(SellOrderGroup sellOrderGroup) {
        try {
            // 传入动态定义对象更新信息
            sellOrderGroupMapper.updateSellOrderGroup(sellOrderGroup);
            return true;
        } catch (DataAccessException ex) {
            // 不存在这一订货单
            return false;
        }
    }

    @Override
    public boolean deleteSellOrder(int sellOrderGroupId) {
        try {
            // 删除此id的订货单
            SellOrderGroup sellOrderGroup = sellOrderGroupMapper.getSellOrderGroupById(sellOrderGroupId);
            if(sellOrderGroup.getSellStatus() == 2 || sellOrderGroup .getSellStatus() == 4)
            {
                List<SellOrder> sellOrderList = sellOrderGroup.getSellOrders();
                for(int i = 0; i<sellOrderList.size(); i++){
                    //货物回库
                    goodsMapper.addNumber(sellOrderList.get(i).getSellGoodsId(), sellOrderList.get(i).getSellNumber(), sellOrderGroup.getWarehouseId());
                   //删除销售单
                    sellOrderMapper.deleteSellOrder(sellOrderList.get(i).getSellOrderId());
                }
                sellOrderGroupMapper.deleteSellOrderGroupById(sellOrderGroupId);
            }
            return true;
        } catch (DataAccessException ex) {
            //销售单不再数据库中
            return false;
        }
    }


    @Override
    public List<SellOrderGroup> getUncheckedSellOrder() {
        // 获取未审核的订单
        SellOrderGroup uncheckedOrder = new SellOrderGroup();
        uncheckedOrder.setSellStatus(1);
        return sellOrderGroupMapper.querySellOrderGroup(uncheckedOrder);
    }

    @Override
    public boolean checkOrder(int sellOrderGroupId, boolean opinion) {
        // SellOrder order = sellOrderMapper.getSellOrderById(sellOrderId);
        SellOrderGroup sellOrderGroup = sellOrderGroupMapper.getSellOrderGroupById(sellOrderGroupId);
        assert sellOrderGroup != null;   // 这个销售单必然存在，不然就是出错的
        // 如果opinion是false，不管库存够不够，都是审核不通过的
        if (!opinion) {
            return changeStatus(sellOrderGroupId, 3);    // 这里审核不通过
        } else {
            // 用户点击了通过审核
            // 先判断一下货存是否充足
            List<SellOrder> sellOrderList = sellOrderGroup.getSellOrders();
            for (SellOrder sellOrder : sellOrderList) {
                double sellNumber = sellOrder.getSellNumber();
                // 判断一个仓库的库存够不够，如果够，才允许审核通过，不够的话不允许审核通过
                Integer goodsId = sellOrder.getSellGoodsId();
                Goods goods = new Goods();
                goods.setGoodsId(goodsId);
                List<Goods> goodsList = goodsMapper.queryGoods(goods);
                if (goodsList != null && goodsList.size() > 0) {
                    // 查询到了这个货物的信息
                    Goods result = goodsList.get(0);
                    double stock = result.getGoodsNumber(); // 库存
                    if (stock < sellNumber)
                        return false; // 数量不足
                }
            }

            //再 出库
            for (SellOrder sellOrder : sellOrderList) {
                double sellNumber = sellOrder.getSellNumber();
                // 判断一个仓库的库存够不够，如果够，才允许审核通过，不够的话不允许审核通过
                Integer goodsId = sellOrder.getSellGoodsId();
                Goods goods = new Goods();
                goods.setGoodsId(goodsId);
                List<Goods> goodsList = goodsMapper.queryGoods(goods);
                if (goodsList != null && goodsList.size() > 0) {
                    // 查询到了这个货物的信息
                    Goods result = goodsList.get(0);
                    double stock = result.getGoodsNumber(); // 库存
                    if (stock >= sellNumber) {
                        // 数量足够
                        // 减少库存
                        goodsMapper.reduceNumber(goodsId, sellNumber, sellOrderGroup.getWarehouseId());
                        // 更改销售单状态
                        // return changeStatus(sellOrderGroupId, 2);
                    }
                } else {
                    // 没有这个货物的ID，正常情况下应该不会走到这里
                    return false;
                }
            }

            return changeStatus(sellOrderGroupId, 2);
        }

    }

    @Override
    public boolean paySellOrder(int sellOrderGroupId) {
        return changeStatus(sellOrderGroupId, 4);
    }

    @Override
    public boolean refundSellOrder(int sellOrderGroupId) {

        try {
            SellOrderGroup order = sellOrderGroupMapper.getSellOrderGroupById(sellOrderGroupId);
            List<SellOrder> sellOrderList = order.getSellOrders();
            for (SellOrder sellOrder : sellOrderList) {
                goodsMapper.addNumber(sellOrder.getSellGoodsId(), sellOrder.getSellNumber(), order.getWarehouseId());
            }
            return changeStatus(sellOrderGroupId, 5);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SellOrderGroup>  getUnpaidOrder() {
        SellOrderGroup order = new SellOrderGroup();
        order.setSellStatus(2);
        return sellOrderGroupMapper.querySellOrderGroup(order);
    }

    @Override
    public List<SellOrderGroup> getUnRefundOrder() {
        SellOrderGroup order = new SellOrderGroup();
        order.setSellStatus(4);
        return sellOrderGroupMapper.querySellOrderGroup(order);
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
            SellOrderGroup order = new SellOrderGroup();
            order.setSellOrderGroupId(orderId);
            order.setSellStatus(status);
            sellOrderGroupMapper.updateSellOrderGroup(order);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Double getSellOrderGroupProfit(int sellOrderGroupId) {
        SellOrderGroup order = sellOrderGroupMapper.getSellOrderGroupById(sellOrderGroupId);
        return order.getProfit();
    }

    @Override
    public Double getSellOrderGroupTotalPrice(int sellOrderGroupId) {
        SellOrderGroup order = sellOrderGroupMapper.getSellOrderGroupById(sellOrderGroupId);
        return order.getSalary();
    }
}
