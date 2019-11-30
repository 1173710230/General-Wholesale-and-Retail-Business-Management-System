package com.example.project.service;

import com.example.project.dao.*;
import com.example.project.domain.Goods;
import com.example.project.domain.InputOrder;
import com.example.project.domain.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InputOrderServiceImpl implements InputOrderService{


    private final ImportOrderMapper importOrderMapper;

    private final WareHouseMapper wareHouseMapper;


    @Autowired
    public InputOrderServiceImpl(ImportOrderMapper importOrderMapper, WareHouseMapper wareHouseMapper) {
        this.importOrderMapper = importOrderMapper;
        this.wareHouseMapper = wareHouseMapper;
    }
    @Override
    public boolean addNewInputOrder(int goodsNumber, double inputUnitPrice, int goodsId, Date time, String remark) {
        InputOrder inputOrder = new InputOrder();
        inputOrder.setInputGoodsNumber(goodsNumber);
        inputOrder.setInputGoodsId(goodsId);
        inputOrder.setInputOrderRemark(remark);
        inputOrder.setInputTime(time.toLocaleString());
        inputOrder.setInputUnitPrice(inputUnitPrice);
        importOrderMapper.insert(inputOrder);
        Goods goods = new Goods();
        goods.setWarehouseId(1);
        goods.setGoodsNumber(Double.valueOf(goodsNumber));
        goods.setGoodsId(goodsId);
        wareHouseMapper.addGoodsToWarehouse(goods);
        return true;
    }
}
