package com.example.project.domain;

import java.util.Date;
import java.util.Objects;

/**
 * 
 */
public class InputOrder {

    private int id;
    private Goods goods;
    private int goodsNumber;
    private double inputUnitPrice;
    private double totalPrice;
    private Date time;
    private String remark;
    private static int times = 1;

    //ToDo constructor
    public InputOrder(Goods goods, int goodsNumber, double inputUnitPrice, double totalPrice, Date time, String remark) {
        this.id = times;
        this.goods = goods;
        this.goodsNumber = goodsNumber;
        this.inputUnitPrice = inputUnitPrice;
        this.totalPrice = totalPrice;
        this.time = time;
        this.remark = remark;
        times++;
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

    public Goods getGoods() {
        return goods;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public double getInputUnitPrice() {
        return inputUnitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
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

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public void setInputUnitPrice(double inputUnitPrice) {
        this.inputUnitPrice = inputUnitPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static int getTimes() {
        return times;
    }

    public static void setTimes(int times) {
        InputOrder.times = times;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "inputOrder{" +
                "id=" + id +
                ", goods=" + goods +
                ", goodsNumber=" + goodsNumber +
                ", inputUnitPrice=" + inputUnitPrice +
                ", totalPrice=" + totalPrice +
                ", time=" + time +
                ", remark='" + remark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputOrder that = (InputOrder) o;
        return id == that.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goods, goodsNumber, inputUnitPrice, totalPrice, time, remark);
    }
}