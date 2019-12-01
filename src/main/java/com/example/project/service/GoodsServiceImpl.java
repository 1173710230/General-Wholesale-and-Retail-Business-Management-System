package com.example.project.service;

import com.example.project.dao.*;
import com.example.project.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{

    private final GoodsMapper goodsMapper;

    private final CustomerMapper customerMapper;

    private final SellOrderMapper sellOrderMapper;

    private final UserMapper userMapper;

    private final WareHouseMapper wareHouseMapper;

    @Autowired
    public GoodsServiceImpl(GoodsMapper goodsMapper,
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
    public List<Goods> getAllWarehouseGoods() {
        Goods goods = new Goods();
        return goodsMapper.queryGoods(goods);
    }

    @Override
    public boolean deleteGoodsById(int goodsId) {
        try {
            goodsMapper.deleteGoodsById(goodsId);
            return true;
        } catch (DataAccessException ex) {
            return false;
        }
    }

    @Override
    public boolean modifyGoodsById(int goodsId, String goodsName, String spec) {
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        goods.setGoodsSpecification(spec);
        goods.setGoodsId(goodsId);
        try {
            goodsMapper.updateGoods(goods);
            return true;
        } catch (DataAccessException ex) {
            return false;
        }
    }

    @Override
    public List<Goods> queryGoodsByName(String name) {
        Goods goods = new Goods();
        goods.setGoodsName(name);
        return goodsMapper.queryGoods(goods);

    }
}
