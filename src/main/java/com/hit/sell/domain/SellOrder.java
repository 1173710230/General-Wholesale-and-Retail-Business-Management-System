package com.hit.sell.domain;

import java.sql.Time;
import java.sql.Timestamp;

public class SellOrder {
    private Integer outId;
    private Timestamp sellTime;
    private Integer orderStatus;
    private double sellUnitPrice;
    private Integer sellNumber;
    private String remark;
    private Integer goodsId;

    public SellOrder() {
    }

    public SellOrder(Integer outId, Timestamp sellTime, Integer orderStatus, double sellUnitPrice, Integer sellNumber, String remark, Integer goodsId) {
        this.outId = outId;
        this.sellTime = sellTime;
        this.orderStatus = orderStatus;
        this.sellUnitPrice = sellUnitPrice;
        this.sellNumber = sellNumber;
        this.remark = remark;
        this.goodsId = goodsId;
    }

    public Integer getOutId() {
        return outId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
    }

    public Timestamp getSellTime() {
        return sellTime;
    }

    public void setSellTime(Timestamp sellTime) {
        this.sellTime = sellTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getSellUnitPrice() {
        return sellUnitPrice;
    }

    public void setSellUnitPrice(double sellUnitPrice) {
        this.sellUnitPrice = sellUnitPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getSellNumber() {
        return sellNumber;
    }

    public void setSellNumber(Integer sellNumber) {
        this.sellNumber = sellNumber;
    }

    @Override
    public String toString() {
        return "SellOrder{" +
                "outId=" + outId +
                ", sellTime=" + sellTime +
                ", orderStatus=" + orderStatus +
                ", sellUnitPrice=" + sellUnitPrice +
                ", sellNumber=" + sellNumber +
                ", remark='" + remark + '\'' +
                ", goodsId=" + goodsId +
                '}';
    }
}

