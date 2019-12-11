package com.example.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {

    private Integer customerId;
    private String customerName;
    private String customerTel;
    private List<Integer> historySellOrderId;
    private Integer status;
    // 0为批发， 1 为零售


    public Customer(Integer customerId, String customerName, String customerTel, List<Integer> historySellOrderId, Integer status) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerTel = customerTel;
        this.historySellOrderId = historySellOrderId;
        this.status = status;
    }

    //ToDo constructor
    public Customer(){

    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public List<Integer> getHistorySellOrderId() {
        return historySellOrderId;
    }

    public void setHistorySellOrderId(List<Integer> historySellOrderId) {
        this.historySellOrderId = historySellOrderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerTel, historySellOrderId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerTel='" + customerTel + '\'' +
                ", historySellOrderId=" + historySellOrderId +
                '}';
    }
}