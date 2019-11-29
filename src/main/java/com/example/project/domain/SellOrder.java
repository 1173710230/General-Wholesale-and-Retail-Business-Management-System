package com.example.project.domain;

import java.util.Date;
import java.util.Objects;


public class SellOrder {

    private Integer sellOrderId;
    private Integer SellNumber;//卖掉的数量
    private Double sellUnitPrice;
    private Integer sellStatus = 0;
    // 未提交0；待审核1；审核通过2；审核不通过3；订单完成（已付款）4；已退款5；
    private Date sellTime;
    private String sellOrderRemark;
    private Integer sellGoodsId;
    private Integer customerId;


    //ToDo constructor
    public SellOrder() {
    }

    public SellOrder(Integer sellOrderId, Integer sellNumber, Double sellUnitPrice, Integer sellStatus, Date sellTime, String sellOrderRemark, Integer sellGoodsId, Integer customerId) {
        this.sellOrderId = sellOrderId;
        SellNumber = sellNumber;
        this.sellUnitPrice = sellUnitPrice;
        this.sellStatus = sellStatus;
        this.sellTime = sellTime;
        this.sellOrderRemark = sellOrderRemark;
        this.sellGoodsId = sellGoodsId;
        this.customerId = customerId;
    }

    public Integer getSellOrderId() {
        return sellOrderId;
    }

    public void setSellOrderId(Integer sellOrderId) {
        this.sellOrderId = sellOrderId;
    }

    public Integer getSellNumber() {
        return SellNumber;
    }

    public void setSellNumber(Integer sellNumber) {
        SellNumber = sellNumber;
    }

    public Double getSellUnitPrice() {
        return sellUnitPrice;
    }

    public void setSellUnitPrice(Double sellUnitPrice) {
        this.sellUnitPrice = sellUnitPrice;
    }

    public Integer getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Integer sellStatus) {
        this.sellStatus = sellStatus;
    }

    public Date getSellTime() {
        return sellTime;
    }

    public void setSellTime(Date sellTime) {
        this.sellTime = sellTime;
    }

    public String getSellOrderRemark() {
        return sellOrderRemark;
    }

    public void setSellOrderRemark(String sellOrderRemark) {
        this.sellOrderRemark = sellOrderRemark;
    }

    public Integer getSellGoodsId() {
        return sellGoodsId;
    }

    public void setSellGoodsId(Integer sellGoodsId) {
        this.sellGoodsId = sellGoodsId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellOrder sellOrder = (SellOrder) o;
        return Objects.equals(sellOrderId, sellOrder.sellOrderId) &&
                Objects.equals(SellNumber, sellOrder.SellNumber) &&
                Objects.equals(sellUnitPrice, sellOrder.sellUnitPrice) &&
                Objects.equals(sellStatus, sellOrder.sellStatus) &&
                Objects.equals(sellTime, sellOrder.sellTime) &&
                Objects.equals(sellOrderRemark, sellOrder.sellOrderRemark) &&
                Objects.equals(sellGoodsId, sellOrder.sellGoodsId) &&
                Objects.equals(customerId, sellOrder.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellOrderId, SellNumber, sellUnitPrice, sellStatus, sellTime, sellOrderRemark, sellGoodsId, customerId);
    }

    @Override
    public String toString() {
        return "SellOrder{" +
                "sellOrderId=" + sellOrderId +
                ", SellNumber=" + SellNumber +
                ", sellUnitPrice=" + sellUnitPrice +
                ", sellStatus=" + sellStatus +
                ", sellTime=" + sellTime +
                ", sellOrderRemark='" + sellOrderRemark + '\'' +
                ", sellGoodsId=" + sellGoodsId +
                ", customerId=" + customerId +
                '}';
    }
}