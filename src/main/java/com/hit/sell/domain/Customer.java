package com.hit.sell.domain;

public class Customer {
    private Integer customerId;
    private String customerName;
    private String customerTel;

    public Integer getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public Customer() {
        super();
    }

    public Customer(Integer customerId, String customerName, String customerTel) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerTel = customerTel;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerTel='" + customerTel + '\'' +
                '}';
    }
}
