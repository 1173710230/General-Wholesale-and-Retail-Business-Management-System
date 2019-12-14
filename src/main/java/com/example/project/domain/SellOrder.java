package com.example.project.domain;

import java.util.Objects;


public class SellOrder {

    private Integer sellOrderId;//save
    private Double sellNumber;//卖掉的数量save
    private Double sellUnitPrice;//save
    private Integer sellGoodsId;//save

    @Override
    public String toString() {
        return "SellOrder{" +
                "sellOrderId=" + sellOrderId +
                ", sellNumber=" + sellNumber +
                ", sellUnitPrice=" + sellUnitPrice +
                ", sellGoodsId=" + sellGoodsId +
                '}';
    }

    //ToDo constructor
    public SellOrder() {
    }

    public SellOrder(Integer sellOrderId, Double sellNumber, Double sellUnitPrice, Integer sellGoodsId) {
        this.sellOrderId = sellOrderId;
        this.sellNumber = sellNumber;
        this.sellUnitPrice = sellUnitPrice;
        this.sellGoodsId = sellGoodsId;
    }

    public Integer getSellOrderId() {
        return sellOrderId;
    }

    public void setSellOrderId(Integer sellOrderId) {
        this.sellOrderId = sellOrderId;
    }

    public Double getSellNumber() {
        return sellNumber;
    }

    public void setSellNumber(Double sellNumber) {
        this.sellNumber = sellNumber;
    }

    public Double getSellUnitPrice() {
        return sellUnitPrice;
    }

    public void setSellUnitPrice(Double sellUnitPrice) {
        this.sellUnitPrice = sellUnitPrice;
    }

    public Integer getSellGoodsId() {
        return sellGoodsId;
    }

    public void setSellGoodsId(Integer sellGoodsId) {
        this.sellGoodsId = sellGoodsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellOrder sellOrder = (SellOrder) o;
        return Objects.equals(sellOrderId, sellOrder.sellOrderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellOrderId, sellNumber, sellUnitPrice,  sellGoodsId);
    }

}