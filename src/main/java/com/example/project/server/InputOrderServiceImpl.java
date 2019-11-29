package com.example.project.server;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InputOrderServiceImpl implements InputOrderService{

    @Override
    public boolean addNewInputOrder(int inputOrderId, int goodsNumber, double inputUnitPrice, int goodsId, Date time, String remark) {
        return false;
    }
}
