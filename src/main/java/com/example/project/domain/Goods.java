package com.example.project.domain;

import java.util.List;
import java.util.Objects;


public class Goods {

    private Integer goodsId;
    private String goodsName;
    private String goodsSpecification;
    private List<Warehouse> warehouses;
    private List<Integer> goodsNumber;

    //ToDo constructor
    public Goods(Integer goodsId, String goodsName, String goodsSpecification, List<Warehouse> warehouses, List<Integer> goodsNumber) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsSpecification = goodsSpecification;
        this.warehouses = warehouses;
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

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public List<Integer> getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(List<Integer> goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(goodsId, goods.goodsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, goodsName, goodsSpecification, warehouses, goodsNumber);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsSpecification='" + goodsSpecification + '\'' +
                ", warehouses=" + warehouses +
                ", goodsNumber=" + goodsNumber +
                '}';
    }
}