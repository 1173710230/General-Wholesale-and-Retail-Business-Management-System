package com.example.project.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface InputOrderService {


    /**
     * 添加一个进货单
     *
     */
    boolean addNewInputOrder( double goodsNumber, double inputUnitPrice, int goodsId, Date time, String remark, int warehouseId);
}
