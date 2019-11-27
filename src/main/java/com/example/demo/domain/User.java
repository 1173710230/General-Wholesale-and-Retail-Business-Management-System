package com.example.demo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User {

    private int id;
    private String name;
    private String passward;
    private static int times = 1;


    //public data 1;


    public User(String name, String passward) {
        this.id = times;
        this.name = name;
        this.passward = passward;
        times++;
    }

    /**
     * 仓库里添加货物
     * @param warehouseId 
     * @param goods 
     * @return
     */
    public boolean addGoods(int warehouseId, Goods goods) {
        List<Warehouse> wares = Data.getWarehouses();
        for(int i =0; i<wares.size(); i++){
            if(wares.get(i).getId() == warehouseId) {
                if (!wares.get(i).getGoods().contains(goods)) {
                    wares.get(i).getGoods().add(goods);
                    Data.setWarehouses(wares);
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * 仓库里取出货物
     * @param warehouseId 
     * @param goodId
     * @return
     */
    public boolean deleteGoods(int warehouseId, int goodId) {
        List<Warehouse> wares = Data.getWarehouses();
        boolean flag = false;
        for(int i =0; i<wares.size(); i++) {
            List<Goods> gooods = wares.get(i).getGoods();
            if (wares.get(i).getId() == warehouseId) {
                int j = 0;
                for (j = 0; j < gooods.size(); j++) {
                    if (gooods.get(j).getId() == goodId) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    gooods.remove(j);
                    wares.get(i).setGoods(gooods);
                    break;
                }
            }
        }
        Data.setWarehouses(wares);
        return flag;

    }

    /**
     * 修改货物名称
     * @param goodsId 
     * @param goodsName 
     * @return
     */
    public boolean modifyGoodsName(int goodsId, String goodsName) {
        List<Goods> gooods = Data.getWarehouses().get(0).getGoods();
        for(int j = 0; j<gooods.size();j++){
            if(gooods.get(j).getId() == goodsId){
                gooods.get(j).modifyName(goodsName);
                return true;
            }
        }
        return false;
    }

    /**
     * 修改售货货物数量
     * @param goodsId 
     * @param goodsNumber 
     * @return
     */
    public boolean modifyGoodsNumber(int goodsId, int goodsNumber) {
        List<Goods> gooods = Data.getWarehouses().get(0).getGoods();
        for(int j = 0; j<gooods.size();j++){
            if(gooods.get(j).getId() == goodsId){
                gooods.get(j).modifyNumber(goodsNumber);
                return true;
            }
        }
        return false;
    }

    /**
     * 修改售货订单中货品种类
     * @param sellOrderId 
     * @param goodsId 
     * @return
     */
    public boolean modifyOrderGoods(int sellOrderId, int goodsId) {
        List<Goods> gooods = Data.getWarehouses().get(0).getGoods();
        Goods addedGoods = null;
        for(int i = 0; i<gooods.size(); i++){
            if(gooods.get(i).getId() == goodsId) {
                addedGoods = gooods.get(i);
            }
        }
        if(addedGoods == null)
            return false;
        List<SellOrder> sellOrders = Data.getSellOrders();
        for(int i = 0; i<sellOrders.size(); i++)
        {
            if(sellOrders.get(i).getId() == sellOrderId){
                sellOrders.get(i).modifyGoods(addedGoods);
                Data.setSellOrders(sellOrders);
                return true;
            }
        }
        return false;
    }

    /**
     * 修改售货订单中货品数量
     * @param sellOrderId 
     * @param goodsNumber 
     * @return
     */
    public boolean modifyOrderGoodsNumber(int sellOrderId, int goodsNumber) {
        List<SellOrder> sellOrders = Data.getSellOrders();
        for(int i = 0; i<sellOrders.size(); i++)
        {
            if(sellOrders.get(i).getId() == sellOrderId){
                sellOrders.get(i).modifyGoodsNumber(goodsNumber);
                Data.setSellOrders(sellOrders);
                return true;
            }
        }
        return false;
    }

    /**
     * 修改售货订单中单价
     * @param sellOrderId 
     * @param sellPrice 
     * @return
     */
    public boolean modifyOrderSellPrice(int sellOrderId, double sellPrice) {
        List<SellOrder> sellOrders = Data.getSellOrders();
        for(int i = 0; i<sellOrders.size(); i++)
        {
            if(sellOrders.get(i).getId() == sellOrderId){
                sellOrders.get(i).modifySellPrice(sellPrice);
                Data.setSellOrders(sellOrders);
                return true;
            }
        }
        return false;
    }

    /**
     * 废弃的方法
     * @param sellOrderId 
     * @param totalPrice 
     * @return
     */
    public boolean modifyOrderTotalPrice(int sellOrderId, double totalPrice) {
        // TODO deleted
        return false;
    }

    /**
     * 修改售货订单备注信息
     * @param sellOrderId 
     * @param remake 
     * @return
     */
    public boolean modifySellOrderRemake(int sellOrderId, String remake) {
        List<SellOrder> sellOrders = Data.getSellOrders();
        for(int i = 0; i<sellOrders.size(); i++)
        {
            if(sellOrders.get(i).getId() == sellOrderId){
                sellOrders.get(i).modifyRemake(remake);
                Data.setSellOrders(sellOrders);
                return true;
            }
        }
        return false;
    }

    /**
     * 修改进货单备注信息
     * @param inputOrderId 
     * @param remake 
     * @return
     */
    public boolean modifyInputOrderRemake(int inputOrderId, String remake) {
       List<InputOrder> inputOrders = Data.getInputOrders();
        for(int i = 0; i<inputOrders.size(); i++)
        {
            if(inputOrders.get(i).getId() == inputOrderId){
                inputOrders.get(i).modifyRemake(remake);
                Data.setInputOrders(inputOrders);
                return true;
            }
        }
        return false;
    }

    /**
     * 修改客户电话号码
     * @param customerId 
     * @param tel 
     * @return
     */
    public boolean modifyCustomerTel(int customerId, String tel) {
        List<Customer> customers = Data.getCustomers();
        for(int i=0; i<customers.size(); i++){
            if(customers.get(i).getId() == customerId){
                customers.get(i).modifyTel(tel);
                Data.setCustomers(customers);
                return true;
            }
        }
        return false;
    }

    /**
     * anID查询货物
     * @param warehouseId 
     * @param goodsId 
     * @return
     */
    public Goods queryGoodsById(int warehouseId, int goodsId) {
        List<Warehouse> wares = Data.getWarehouses();
        boolean flag = false;
        for(int i =0; i<wares.size(); i++) {
            List<Goods> gooods = wares.get(i).getGoods();
            if (wares.get(i).getId() == warehouseId) {
                int j = 0;
                for (j = 0; j < gooods.size(); j++) {
                    if (gooods.get(j).getId() == goodsId) {
                       return gooods.get(j);
                    }
                }

            }
        }
        return null;
    }

    /**
     * @param warehouseId 
     * @param goodsName 
     * @return
     */
    public List<Goods> queryGoodsByName(int warehouseId, String goodsName) {
        List<Warehouse> wares = Data.getWarehouses();
        List<Goods> queryGoods = new ArrayList<>();
        boolean flag = false;
        for(int i =0; i<wares.size(); i++) {
            List<Goods> gooods = wares.get(i).getGoods();
            if (wares.get(i).getId() == warehouseId) {
                int j = 0;
                for (j = 0; j < gooods.size(); j++) {
                    if (gooods.get(j).getName().equals(goodsName)) {
                        queryGoods.add(gooods.get(j));
                    }
                }

            }
        }
        return queryGoods;
    }

    /**
     * @param warehouseId 
     * @param lowerPrice 
     * @param highPrice 
     * @return
     */
    public List<Goods> queryGoodsByPrice(int warehouseId, double lowerPrice, double highPrice) {
        // TODO deleted
        return null;
    }

    /**
     *
     * @param goodsId 
     * @param goodsNumber 
     * @param sellUnitPrice 
     * @param totalPrice 
     * @param remake 
     * @return
     */
    public boolean makeSellOrder(int goodsId, int goodsNumber, double sellUnitPrice, double totalPrice, String remake, String customername) {
        List<Goods> gooods = Data.getWarehouses().get(0).getGoods();
        Goods addedGoods = null;
        for(int i = 0; i<gooods.size(); i++){
            if(gooods.get(i).getId() == goodsId) {
                addedGoods = gooods.get(i);
            }
        }
        if(addedGoods == null)
            return false;
        Date date=new Date();
        SellOrder sellOrder = new SellOrder(addedGoods, goodsNumber, sellUnitPrice, totalPrice,0, date , remake, customername);
        List<SellOrder> sellOrders = Data.getSellOrders();
        sellOrders.add(sellOrder);
        Data.setSellOrders(sellOrders);
        return true;
    }

    /**
     * 保存订单
     * @param sellOrderId 
     * @return
     */
    public boolean saveSellOrder(int sellOrderId) {
        List<SellOrder> sellOrders = Data.getSellOrders();
        for(int i = 0; i<sellOrders.size(); i++)
        {
            if(sellOrders.get(i).getId() == sellOrderId){
                sellOrders.get(i).saveOrder();
                Data.setSellOrders(sellOrders);
                return true;
            }
        }
        return false;
    }

    /**
     * 删除订单（未确定订单之前）
     * @param sellOrderId 
     * @return
     */
    public boolean deleteSellOrder(int sellOrderId) {
        List<SellOrder> sellOrders = Data.getSellOrders();
        for(int i = 0; i<sellOrders.size(); i++)
        {
            if(sellOrders.get(i).getId() == sellOrderId && sellOrders.get(i).getStatus()<=1){
                sellOrders.remove(i);
                Data.setSellOrders(sellOrders);
                return true;
            }
        }
        return false;
    }

    /**
     * 审核判断，pass代表是否通过。
     * @param sellOrderId 
     * @return
     */
    public boolean checkSellOrder(int sellOrderId, boolean pass) {
        List<SellOrder> sellOrders = Data.getSellOrders();
        for(int i = 0; i<sellOrders.size(); i++)
        {
            if(sellOrders.get(i).getId() == sellOrderId){
                if(pass) {
                    sellOrders.get(i).setStatus(2);
                    //修改库存
                    int sum = sellOrders.get(i).getGoodsNumber();
                    //库存不足，自动审核不过
                    int sumofwire = sellOrders.get(i).getGoods().getNumber();
                    if(sumofwire < sum)
                        sellOrders.get(i).setStatus(3);
                    else{
                        sellOrders.get(i).getGoods().setNumber(sumofwire - sum);
                    }
                }

                else
                    sellOrders.get(i).setStatus(3);
                Data.setSellOrders(sellOrders);
                return true;
            }
        }
        return false;
    }

    /**
     * 付款
     * @param sellOrderId 
     * @return
     */
    public boolean receipt(int sellOrderId) {
        List<SellOrder> sellOrders = Data.getSellOrders();
        for(int i = 0; i<sellOrders.size(); i++)
        {
            if(sellOrders.get(i).getId() == sellOrderId && sellOrders.get(i).getStatus() == 2 ){
                    sellOrders.get(i).setStatus(4);
                Data.setSellOrders(sellOrders);
                return true;
            }
        }
        return false;
    }

    /**
     * 退款
     * @param sellOrderId 
     * @return
     */
    public boolean refund(int sellOrderId) {
        List<SellOrder> sellOrders = Data.getSellOrders();
        for(int i = 0; i<sellOrders.size(); i++)
        {
            if(sellOrders.get(i).getId() == sellOrderId && sellOrders.get(i).getStatus() == 4){
                sellOrders.get(i).setStatus(5);
                //修改库存
                int sum = sellOrders.get(i).getGoodsNumber();
                //库存不足，自动审核不过
                int sumofwire = sellOrders.get(i).getGoods().getNumber();
                sellOrders.get(i).getGoods().setNumber(sumofwire + sum);
                Data.setSellOrders(sellOrders);
                return true;
            }
        }
        return false;
    }

    /**
     * 创建进货单
     * @param goodsNumber 
     * @param inputUnitPrice 
     * @param totalPrice 
     * @param remake 
     * @return
     */
    public boolean makeInputOrder(Goods goods, int goodsNumber, double inputUnitPrice, double totalPrice, String remake) {
        //ToDo
        List<Goods> gooods = Data.getWarehouses().get(0).getGoods();
        Warehouse warehouses = Data.getWarehouses().get(0);
        Goods addedGoods = null;

        if(gooods.contains(goods)) {
            List<Warehouse> warehouseList = new ArrayList<>();
            int sum = goods.getNumber() + goodsNumber;
            goods.setNumber(sum);
            addedGoods = goods;
        }
        else{
            goods.setNumber(goodsNumber);
            gooods.add(goods);
            warehouses.setGoods(gooods);
            List<Warehouse> warehouseList = new ArrayList<>();
            warehouseList.add(warehouses);
            Data.setWarehouses(warehouseList);
            addedGoods = goods;
        }

        if(addedGoods == null)
            return false;
        Date date=new Date();
        InputOrder inputOrder = new InputOrder(addedGoods, goodsNumber, inputUnitPrice, totalPrice,date , remake);
        Data.getInputOrders().add(inputOrder);

        return true;
    }

    /**
     *
     * @param warehouseId 
     * @return
     */
    public String statisticsInventory(int warehouseId) {
        List<Warehouse> wares = Data.getWarehouses();
        boolean flag = false;
        for(int i =0; i<wares.size(); i++) {
            List<Goods> gooods = wares.get(i).getGoods();
            if (wares.get(i).getId() == warehouseId) {
               return wares.get(i).toString();
            }
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}