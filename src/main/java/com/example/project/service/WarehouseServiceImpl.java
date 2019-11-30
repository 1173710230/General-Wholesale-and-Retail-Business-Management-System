package com.example.project.service;

import com.example.project.dao.*;
import com.example.project.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService{

    private final GoodsMapper goodsMapper;

    private final CustomerMapper customerMapper;

    private final SellOrderMapper sellOrderMapper;

    private final UserMapper userMapper;

    private final WareHouseMapper wareHouseMapper;

    @Autowired
    public WarehouseServiceImpl(GoodsMapper goodsMapper,
                                CustomerMapper customerMapper,
                                SellOrderMapper sellOrderMapper,
                                UserMapper userMapper,
                                WareHouseMapper wareHouseMapper) {
        this.goodsMapper = goodsMapper;
        this.customerMapper = customerMapper;
        this.sellOrderMapper = sellOrderMapper;
        this.userMapper = userMapper;
        this.wareHouseMapper = wareHouseMapper;
    }

    @Override
    public List<Goods> getGoodsFromAllWarehouse() {
        Goods goods = new Goods();
        return goodsMapper.queryGoods(goods);
    }

    @Override
    public List<Goods> queryGoodsByName(String name) {
        Goods goods = new Goods();
        goods.setGoodsName(name);
        return goodsMapper.queryGoods(goods);
    }

    @Override
    public boolean addGoodsToWareHouse(int checkGoodsId, double goodsNumber, int warehouseId){
        Goods goods = new Goods();
        goods.setGoodsId(checkGoodsId);
        goods.setGoodsNumber(goodsNumber);
        goods.setWarehouseId(warehouseId);
        try {
            wareHouseMapper.addGoodsToWarehouse(goods);
            return true;
        } catch (DataAccessException ex) {
            return false;
        }
    }

    @Override
    public boolean addNewGoods(int checkGoodsId, int goodsNumber, String goodsName, String spec, int warehouseId){
        try {
            Goods goods = new Goods();
            Goods goods1 = new Goods();
            // 查询一遍
            goods1.setGoodsId(checkGoodsId);
            if (goodsMapper.queryGoods(goods).contains(goods1)) {
                return false;
            }
            // 添加到Goods数据库
            Goods goods2 = new Goods();
            goods2.setGoodsName(goodsName);
            goods2.setGoodsSpecification(spec);
            goods2.setWarehouseId(warehouseId);
            goods2.setGoodsSpecification(spec);
            int gid = goodsMapper.addGoods(goods2);
            // 添加到货物仓库关系
            Goods goods3 = new Goods();
            goods3.setGoodsId(gid);
            goods3.setWarehouseId(warehouseId);
            goods3.setGoodsNumber((double) goodsNumber);
            wareHouseMapper.addGoodsToWarehouse(goods3);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
