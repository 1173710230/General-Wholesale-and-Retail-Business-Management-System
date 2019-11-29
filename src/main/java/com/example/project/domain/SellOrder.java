package com.example.project.domain;

import java.util.Date;
import java.util.Objects;


public class SellOrder {

    private int id;
    private int goodsNumber;//卖掉的数量
    private double sellUnitPrice;
    private int status = 0;
    // 未提交0；待审核1；审核通过2；审核不通过3；订单完成（已付款）4；已退款5；
    private Date time;
    private String remark;
    private int goodsId;


    //ToDo constructor
    public SellOrder(int id, int goodsNumber, double sellUnitPrice, int status, Date time, String remark, int goods_id) {
        this.id = id;
        this.goodsNumber = goodsNumber;
        this.sellUnitPrice = sellUnitPrice;
        this.status = status;
        this.time = time;
        this.remark = remark;
        this.goodsId = goods_id;
    }

    /**
     * 只有未提交的订单才可以修改
     * @param newGoods_id
     * @return
     */
    public boolean modifyGoods(int newGoods_id) {
        if(this.status == 0) {
            this.goodsId = newGoods_id;
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
            this.sellUnitPrice = sellPrice;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public double getSellUnitPrice() {
        return sellUnitPrice;
    }

    public void setSellUnitPrice(double sellUnitPrice) {
        this.sellUnitPrice = sellUnitPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
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
        return "SellOrder{" +
                "id=" + id +
                ", goodsNumber=" + goodsNumber +
                ", sellUnitPrice=" + sellUnitPrice +
                ", status=" + status +
                ", time=" + time +
                ", remark='" + remark + '\'' +
                ", goods_id=" + goodsId +
                '}';
    }
}