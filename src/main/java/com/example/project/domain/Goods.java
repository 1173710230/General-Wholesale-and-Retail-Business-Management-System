package com.example.project.domain;

import java.util.List;
import java.util.Objects;


public class Goods {

    private Integer goodsId;
    private String goodsName;
    private String goodsSpecification;
    private Integer warehouseId;
    private Double goodsNumber = 0.0;

    public Goods(Integer goodsId, String goodsName, String goodsSpecification, Integer warehouseId, Double goodsNumber) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsSpecification = goodsSpecification;
        this.warehouseId = warehouseId;
        this.goodsNumber = goodsNumber;
    }

    public Goods() {
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSpecification() {
        return goodsSpecification;
    }

    public void setGoodsSpecification(String goodsSpecification) {
        this.goodsSpecification = goodsSpecification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(goodsId.intValue(), goods.goodsId.intValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, goodsName, goodsSpecification, warehouseId, goodsNumber);
    }


    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Double getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Double goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsSpecification='" + goodsSpecification + '\'' +
                ", warehouseId=" + warehouseId +
                ", goodsNumber=" + goodsNumber +
                '}';
    }
}