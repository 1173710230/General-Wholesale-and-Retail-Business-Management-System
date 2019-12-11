package com.example.project.domain;

import java.util.ArrayList;
import java.util.List;

public class SellOrderGroup {

    private Integer sellOrderGroupId;

    private String sellTime;

    private String sellOrderRemark;

    private Integer sellOrderType;

    private Integer sellStatus = 0;

    private List<SellOrder> sellOrders = new ArrayList<>();

    private Integer customerId;

    private Double salary = 0.0;


    //ToDo constructor
    public SellOrderGroup() {
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Integer sellStatus) {
        this.sellStatus = sellStatus;
    }

    public Integer getSellOrderGroupId() {
        return sellOrderGroupId;
    }

    public void setSellOrderGroupId(Integer sellOrderGroupId) {
        this.sellOrderGroupId = sellOrderGroupId;
    }

    public String getSellTime() {
        return sellTime;
    }

    public void setSellTime(String sellTime) {
        this.sellTime = sellTime;
    }

    public String getSellOrderRemark() {
        return sellOrderRemark;
    }

    public void setSellOrderRemark(String sellOrderRemark) {
        this.sellOrderRemark = sellOrderRemark;
    }

    public Integer getSellOrderType() {
        return sellOrderType;
    }

    public void setSellOrderType(Integer sellOrderType) {
        this.sellOrderType = sellOrderType;
    }

    public List<SellOrder> getSellOrders() {
        return sellOrders;
    }

    public void setSellOrders(List<SellOrder> sellOrders) {
        this.sellOrders = sellOrders;
    }


    /*---------------添加删除销售记录的方法----------------*/
    public void addRecord(SellOrder order) {
        this.sellOrders.add(order);
    }

    public void addRecord(List<SellOrder> orders) {
        this.sellOrders.addAll(orders);
    }

    public List<SellOrder> deleteAllOrderRecords() {
        List<SellOrder> temp = this.sellOrders;
        this.sellOrders = new ArrayList<>();
        return temp;
    }

}
