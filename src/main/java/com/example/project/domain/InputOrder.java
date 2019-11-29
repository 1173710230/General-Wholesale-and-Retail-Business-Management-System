package com.example.project.domain;

import java.util.Date;
import java.util.Objects;

/**
 * 
 */
public class InputOrder {

    private Integer inputOrderId;
    private Integer inputGoodsNumber;
    private Double inputUnitPrice;
    private Integer inputGoodsId;
    private Date inputTime;
    private String inputOrderRemark;

    //ToDo constructor
    public InputOrder() {
    }

    public InputOrder(Integer inputOrderId, Integer inputGoodsNumber, Double inputUnitPrice, Integer inputGoodsId, Date inputTime, String inputOrderRemark) {
        this.inputOrderId = inputOrderId;
        this.inputGoodsNumber = inputGoodsNumber;
        this.inputUnitPrice = inputUnitPrice;
        this.inputGoodsId = inputGoodsId;
        this.inputTime = inputTime;
        this.inputOrderRemark = inputOrderRemark;
    }

    public Integer getInputOrderId() {
        return inputOrderId;
    }

    public void setInputOrderId(Integer inputOrderId) {
        this.inputOrderId = inputOrderId;
    }

    public Integer getInputGoodsNumber() {
        return inputGoodsNumber;
    }

    public void setInputGoodsNumber(Integer inputGoodsNumber) {
        this.inputGoodsNumber = inputGoodsNumber;
    }

    public Double getInputUnitPrice() {
        return inputUnitPrice;
    }

    public void setInputUnitPrice(Double inputUnitPrice) {
        this.inputUnitPrice = inputUnitPrice;
    }

    public Integer getInputGoodsId() {
        return inputGoodsId;
    }

    public void setInputGoodsId(Integer inputGoodsId) {
        this.inputGoodsId = inputGoodsId;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public String getInputOrderRemark() {
        return inputOrderRemark;
    }

    public void setInputOrderRemark(String inputOrderRemark) {
        this.inputOrderRemark = inputOrderRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputOrder that = (InputOrder) o;
        return Objects.equals(inputOrderId, that.inputOrderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputOrderId, inputGoodsNumber, inputUnitPrice, inputGoodsId, inputTime, inputOrderRemark);
    }

    @Override
    public String toString() {
        return "InputOrder{" +
                "inputOrderId=" + inputOrderId +
                ", inputGoodsNumber=" + inputGoodsNumber +
                ", inputUnitPrice=" + inputUnitPrice +
                ", inputGoodsId=" + inputGoodsId +
                ", inputTime=" + inputTime +
                ", inputOrderRemark='" + inputOrderRemark + '\'' +
                '}';
    }
}
