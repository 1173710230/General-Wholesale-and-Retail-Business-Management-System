package com.example.demo.domain;

import java.util.List;
import java.util.Objects;

/**
 * 
 */
public class Customer {

    private int id;
    private String name;
    private String tel;
    private List<SellOrder> historyOrder;
    private static int times = 1;

    //ToDo constructor
    public Customer(String name, String tel, List<SellOrder> historyOrder) {
        this.id = times;
        this.name = name;
        this.tel = tel;
        this.historyOrder = historyOrder;
        times++;
    }

    /**
     * @param OrderId 
     * @return
     */
    public boolean addOrder(int OrderId) {
        // TODO deleted
        return false;
    }

    /**
     * @param newTel 
     * @return
     */
    public boolean modifyTel(String newTel) {
        this.tel = newTel;
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<SellOrder> getHistoryOrder() {
        return historyOrder;
    }

    public void setHistoryOrder(List<SellOrder> historyOrder) {
        this.historyOrder = historyOrder;
    }

    public static int getTimes() {
        return times;
    }

    public static void setTimes(int times) {
        Customer.times = times;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}