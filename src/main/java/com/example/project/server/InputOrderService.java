package com.example.project.server;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface InputOrderService {

    boolean addNewInputOrder( int inputOrderId, int goodsNumber, double inputUnitPrice, int goodsId, Date time, String remark);
}
