package com.example.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SellOrderGroup {

    private Integer sellOrderGroupId;

    private String sellTime;

    private String sellOrderRemark;

    private Integer sellOrderType;
    //0批发，1零售

    private Integer sellStatus = null;
    //批发： 未提交0；待审核1；审核通过2；审核不通过3；订单完成（已付款）4；已退款5；
    //零售： 待定

    private List<SellOrder> sellOrders = new ArrayList<>();

    private Integer customerId;

    private Double salary = 0.0;

    private Integer warehouseId;

    private Double profit = 0.0;

    private Double discount = 1.0;

    private Integer payType = 0;  //0说明使用账户付款，1说明使用现金付款

    private void checkRep(){
        assert discount <= 1.0 && discount >= 0.0;
    }

    //ToDo constructor
    public SellOrderGroup() {
    }
    //new constructor because controller needs a constructor with all parameters
    public SellOrderGroup(Integer sellOrderGroupId, String sellTime, String sellOrderRemark, Integer sellOrderType, Integer sellStatus, List<SellOrder> sellOrders, Integer customerId, Double salary, Integer warehouseId, Double profit) {
        this.sellOrderGroupId = sellOrderGroupId;
        this.sellTime = sellTime;
        this.sellOrderRemark = sellOrderRemark;
        this.sellOrderType = sellOrderType;
        this.sellStatus = sellStatus;
        this.sellOrders = sellOrders;
        this.customerId = customerId;
        this.salary = salary;
        this.warehouseId = warehouseId;
        this.profit = profit;
    }

    public SellOrderGroup(Integer sellOrderGroupId, String sellTime, String sellOrderRemark, Integer sellOrderType, Integer sellStatus, List<SellOrder> sellOrders, Integer customerId, Double salary, Integer warehouseId, Double discount, Double profit) {
        this.sellOrderGroupId = sellOrderGroupId;
        this.sellTime = sellTime;
        this.sellOrderRemark = sellOrderRemark;
        this.sellOrderType = sellOrderType;
        this.sellStatus = sellStatus;
        this.sellOrders = sellOrders;
        this.customerId = customerId;
        this.salary = salary;
        this.warehouseId = warehouseId;
        this.discount = discount;
        this.profit = profit;
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

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPayType() {
        return payType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellOrderGroup that = (SellOrderGroup) o;
        return Objects.equals(sellOrderGroupId, that.sellOrderGroupId) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellOrderGroupId, sellTime, sellOrderRemark, sellOrderType, sellStatus, sellOrders, customerId, salary, warehouseId, profit, discount);
    }

    @Override
    public String toString() {
        return "SellOrderGroup{" +
                "sellOrderGroupId=" + sellOrderGroupId +
                ", sellTime='" + sellTime + '\'' +
                ", sellOrderRemark='" + sellOrderRemark + '\'' +
                ", sellOrderType=" + sellOrderType +
                ", sellStatus=" + sellStatus +
                ", sellOrders=" + sellOrders +
                ", customerId=" + customerId +
                ", salary=" + salary +
                ", warehouseId=" + warehouseId +
                ", profit=" + profit +
                ", discount=" + discount +
                '}';
    }
}
