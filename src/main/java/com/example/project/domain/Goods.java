package com.example.project.domain;

import java.util.List;
import java.util.Objects;


public class Goods {

    private Integer goodsId;
    private String goodsName;
    private String goodsSpecification;
    private Integer warehouseId;
    private Double goodsNumber;

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

        if (!goodsId.equals(goods.goodsId)) return false;
        if (!goodsName.equals(goods.goodsName)) return false;
        if (goodsSpecification != null ? !goodsSpecification.equals(goods.goodsSpecification) : goods.goodsSpecification != null)
            return false;
        if (warehouseId != null ? !warehouseId.equals(goods.warehouseId) : goods.warehouseId != null) return false;
        return goodsNumber != null ? goodsNumber.equals(goods.goodsNumber) : goods.goodsNumber == null;
    }

    @Override
    public int hashCode() {
        int result = goodsId.hashCode();
        result = 31 * result + goodsName.hashCode();
        result = 31 * result + (goodsSpecification != null ? goodsSpecification.hashCode() : 0);
        result = 31 * result + (warehouseId != null ? warehouseId.hashCode() : 0);
        result = 31 * result + (goodsNumber != null ? goodsNumber.hashCode() : 0);
        return result;
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
}