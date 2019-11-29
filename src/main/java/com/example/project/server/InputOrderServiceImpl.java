package com.example.project.server;

import com.example.project.dao.*;
import com.example.project.domain.InputOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InputOrderServiceImpl implements InputOrderService{


    private final ImportOrderMapper importOrderMapper;


    @Autowired
    public InputOrderServiceImpl(ImportOrderMapper importOrderMapper) {
        this.importOrderMapper = importOrderMapper;
    }
    @Override
    public boolean addNewInputOrder(int goodsNumber, double inputUnitPrice, int goodsId, Date time, String remark) {
        InputOrder inputOrder = new InputOrder();
        inputOrder.setInputGoodsNumber(goodsNumber);
        inputOrder.setInputGoodsId(goodsId);
        inputOrder.setInputOrderRemark(remark);
        inputOrder.setInputTime(time);
        inputOrder.setInputUnitPrice(inputUnitPrice);
        importOrderMapper.insert(inputOrder);
        return true;
    }
}
