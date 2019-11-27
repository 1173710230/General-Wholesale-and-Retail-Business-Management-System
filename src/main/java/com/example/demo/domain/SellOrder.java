package com.example.demo.domain;

import java.util.Date;
import java.util.Objects;


public class SellOrder {

    private int id;
    private Goods goods;
    private int goodsNumber;
    private double isellUnitPrice;
    private double totalPrice;
    private int status = 0;
    // 未提交0；待审核1；审核通过2；审核不通过3；订单完成（已付款）4；已退款5；
    private Date time;
    private String remark;
    private String customername;
    private static int times = 1;

    //public goods 1;

    //ToDo checkRep
    private void CheckRep(Goods goods, double isellUnitPrice, double totalPrice, int goodsNumber){
        assert isellUnitPrice * goodsNumber == isellUnitPrice;
        assert goods != null;
    }

    //ToDo constructor
    public SellOrder(Goods goods, int goodsNumber, double isellUnitPrice, double totalPrice, int status, Date time, String remark, String customername) {
        this.id = times;
        this.goods = goods;
        this.goodsNumber = goodsNumber;
        this.isellUnitPrice = isellUnitPrice;
        this.totalPrice = totalPrice;
        this.status = status;
        this.time = time;
        this.remark = remark;
        this.customername = customername;
        times++;
    }

    /**
     * 只有未提交的订单才可以修改
     * @param newGoods 
     * @return
     */
    public boolean modifyGoods(Goods newGoods) {
        if(this.status == 0) {
            this.goods = newGoods;
            return true;
        }
        return false;
    }

    /**
     * 只有未提交的订单才可以修改
     *
     * @param newGoodsNumber 
     * @return
     */
    public boolean modifyGoodsNumber(int newGoodsNumber) {
        if(this.status == 0) {
            this.goodsNumber = newGoodsNumber;
            return true;
        }
        return false;
    }

    /**
     * 只有未提交的订单才可以修改
     * @param sellPrice 
     * @return
     */
    public boolean modifySellPrice(double sellPrice) {
        if(this.status == 0) {
            this.isellUnitPrice = sellPrice;
            this.totalPrice = isellUnitPrice * goodsNumber;
            return true;
        }
        return false;
    }

    /**
     * 只有未提交的订单才可以修改
     * @param totalPrice 
     * @return
     */
    public boolean modifyTotalPrice(double totalPrice) {
        //ToDo deleted
        if(this.status == 0) {
            this.totalPrice = totalPrice;
            return true;
        }
        return false;
    }

    /**
     * 只有未提交的订单才可以修改
     * @param remake 
     * @return
     */
    public boolean modifyRemake(String remake) {
        if(this.status == 0) {
            this.remark = remake;
            return true;
        }
        return false;
    }

    /**
     * 将订单状态有未提交改为待审核
     * @return
     */
    public boolean saveOrder() {
        if(this.status == 0){
            this.status = 1;
            return true;
        }
        return false;
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

    public void setIsellUnitPrice(double isellUnitPrice) {
        this.isellUnitPrice = isellUnitPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static void setTimes(int times) {
        SellOrder.times = times;
    }

    public int getId() {
        return id;
    }

    public Goods getGoods() {
        return goods;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public double getIsellUnitPrice() {
        return isellUnitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public Date getTime() {
        return time;
    }

    public String getRemark() {
        return remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellOrder sellOrder = (SellOrder) o;
        return id == sellOrder.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "sellOrder{" +
                "id=" + id +
                ", goods=" + goods +
                ", goodsNumber=" + goodsNumber +
                ", isellUnitPrice=" + isellUnitPrice +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", time=" + time +
                ", remark='" + remark + '\'' +
                '}';
    }
}