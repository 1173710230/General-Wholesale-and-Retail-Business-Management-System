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
        // 调用查询仓库货物关系表的方法，传入空对象返回所有仓库中货物。
        return goodsMapper.queryGoods(goods);
    }

    @Override
    public boolean deleteGoodsById(int goodsId) {
        try {
            // 调用按id删除方法，按货物id删除货物仓库关系
            goodsMapper.deleteGoodsById(goodsId);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifyGoodsById(int goodsId, String goodsName, String spec) {
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        goods.setGoodsSpecification(spec);
        goods.setRetailPrice(null);
        goods.setWholesalePrice(null);
        goods.setGoodsId(goodsId);
         System.out.println("asdasdasdasdsadasd" + goods);
        try {
            //修改货物表中货物信息（按id查询所需）
            goodsMapper.updateGoods(goods);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Goods> queryGoodsByName(String name) {
        Goods goods = new Goods();
        goods.setGoodsName(name);
        // 按名字查询货物货物信息（仓库中）
        return goodsMapper.queryGoods(goods);

    }

    @Override
    public boolean modifyGoodsPriceById(int goodsId, double wholesalePrice, double retailPrice) {
        Goods goods = new Goods();
        goods.setWholesalePrice(wholesalePrice);
        goods.setRetailPrice(retailPrice);
        goods.setGoodsId(goodsId);
        System.out.println("asdasdasdasdsadasd" + goods);
        try {
            //修改货物表中货物信息（按id查询所需）
            goodsMapper.updateGoods(goods);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public double getWholeSalePrice(int goodsId) {
        if(goodsMapper.queryDefaultPifaUnitPriceByGoodsId(goodsId) == null)
            return -1;
        else
            return goodsMapper.queryDefaultPifaUnitPriceByGoodsId(goodsId);
    }

    @Override
    public double getRetailPrice(int goodsId) {
        if(goodsMapper.queryDefaultRetailUnitPriceByGoodsId(goodsId) == null)
            return -1;
        else
            return goodsMapper.queryDefaultRetailUnitPriceByGoodsId(goodsId);
    }
}
