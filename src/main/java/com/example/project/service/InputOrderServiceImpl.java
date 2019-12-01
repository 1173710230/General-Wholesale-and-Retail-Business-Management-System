package com.example.project.service;

import com.example.project.dao.*;
import com.example.project.domain.Goods;
import com.example.project.domain.InputOrder;
import com.example.project.domain.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InputOrderServiceImpl implements InputOrderService{


    private final ImportOrderMapper importOrderMapper;

    private final WareHouseMapper wareHouseMapper;

    private final GoodsMapper goodsMapper;


    @Autowired
    public InputOrderServiceImpl(ImportOrderMapper importOrderMapper,
                                 WareHouseMapper wareHouseMapper,
                                 GoodsMapper goodsMapper) {
        this.importOrderMapper = importOrderMapper;
        this.wareHouseMapper = wareHouseMapper;
        this.goodsMapper = goodsMapper;
    }
    @Override
    public boolean addNewInputOrder(int goodsNumber, double inputUnitPrice, int goodsId, Date time, String remark) {
        InputOrder inputOrder = new InputOrder();
        inputOrder.setInputGoodsNumber(goodsNumber);
        inputOrder.setInputGoodsId(goodsId);
        inputOrder.setInputOrderRemark(remark);
        inputOrder.setInputTime(time.toLocaleString());
        inputOrder.setInputUnitPrice(inputUnitPrice);
        // 新建插入表
        importOrderMapper.insert(inputOrder);
        Goods goods = new Goods();
        goods.setWarehouseId(1);
        // goods.setGoodsNumber(Double.valueOf(goodsNumber));
        goods.setGoodsId(goodsId);
        // 在货物仓库关系表中添加数量（货物仓库初始化关系在addNewGoods中）
        List<Goods> gdx = goodsMapper.queryGoods(goods);
        if(gdx == null || gdx.size() == 0){
            return false;
        }
        goodsMapper.addNumber(goodsId, goodsNumber);
        return true;
    }
}
