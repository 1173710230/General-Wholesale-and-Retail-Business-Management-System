package com.example.project.domain;

import java.util.Date;
import java.util.Objects;

/**
 * 
 */
public class InputOrder {

    private int id;
    private int goodsNumber;
    private double inputUnitPrice;
    private int goods_id;
    private Date time;
    private String remark;

    //ToDo constructor
    public InputOrder(int id, int goodsNumber, double inputUnitPrice, int goods_id, Date time, String remark) {
        this.id = id;
        this.goodsNumber = goodsNumber;
        this.inputUnitPrice = inputUnitPrice;
        this.goods_id = goods_id;
        this.time = time;
        this.remark = remark;
    }


    //public goods 1;

    //public data 1;


    /**
     * @param remake Change remake
     * @return change successfully ,true
     */
    public boolean modifyRemake(String remake) {
        this.remark = remake;
        return true;
    }


    public int getGoodsNumber() {
        return goodsNumber;
    }

    public double getInputUnitPrice() {
        return inputUnitPrice;
    }

    public Date getTime() {
        return time;
    }

    public String getRemark() {
        return remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public void setInputUnitPrice(double inputUnitPrice) {
        this.inputUnitPrice = inputUnitPrice;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputOrder that = (InputOrder) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goodsNumber, inputUnitPrice, goods_id, time, remark);
    }
}
