package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private static List<InputOrder> inputOrders = new ArrayList<>();
    private static List<SellOrder> sellOrders = new ArrayList<>();
    private static List<Customer> customers= new ArrayList<>();
    private static List<Warehouse> warehouses= new ArrayList<>();
    private static List<User> users= new ArrayList<>();
    private static List<Goods> goods= new ArrayList<>();

    //public warehouse 1;
    //public inputOrder n;

    public Data() {
    }


    /**
     * 
     */
    //public user 1;

    /**
     * @param inputOrder
     * @return
     */
    public static boolean addInputOrder(InputOrder inputOrder) {
        if(inputOrders.contains(inputOrder)){
            return false;
        }
        inputOrders.add(inputOrder);
        return true;
    }

    /**
     * @param sellOrder
     * @return
     */
    public static boolean addSellOrder(SellOrder sellOrder) {
        if(sellOrders.contains(sellOrder)){
            return false;
        }
        sellOrders.add(sellOrder);
        return true;
    }

    /**
     * @param customer
     * @return
     */
    public static boolean addCustomers(Customer customer) {
        if(customers.contains(customer)){
            return false;
        }
        customers.add(customer);
        return true;
    }

    /**
     * @param warehouse
     * @return
     */
    public static boolean addWarehouse(Warehouse warehouse) {
        if(warehouses.contains(warehouse)){
            return false;
        }
        warehouses.add(warehouse);
        return true;
    }

    /**
     * @param user
     * @return
     */
    public static boolean addUser(User user) {
        if(users.contains(user)){
            return false;
        }
        users.add(user);
        return true;
    }

    public static List<InputOrder> getInputOrders() {
        return inputOrders;
    }

    public static void setInputOrders(List<InputOrder> inputOrders) {
        Data.inputOrders = inputOrders;
    }

    public static List<SellOrder> getSellOrders() {
        return sellOrders;
    }

    public static void setSellOrders(List<SellOrder> sellOrders) {
        Data.sellOrders = sellOrders;
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(List<Customer> customers) {
        Data.customers = customers;
    }

    public static List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public static void setWarehouses(List<Warehouse> warehouses) {
        Data.warehouses = warehouses;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        Data.users = users;
    }

    public static List<Goods> getGoods() {
        return goods;
    }

    public static void setGoods(List<Goods> goods) {
        Data.goods = goods;
    }
}