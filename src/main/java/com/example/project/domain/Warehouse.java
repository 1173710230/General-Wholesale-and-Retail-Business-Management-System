package com.example.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 */
public class Warehouse {


    private int id;
    private String name;
    private List<Goods> goods;
    private static int times = 1;

    //ToDo constructor
    public Warehouse(String name, List<Goods> goods) {
        this.id = 0;
        this.name = name;
        this.goods = goods;
        times++;
    }

    // public data 1;

    /**
     * @param goods 要添加的商品
     * @return 重复为false
     */
    public boolean addGoods(Goods goods) {
        if(this.goods.contains(goods)){
            return false;
        }
        this.goods.add(goods);
        return true;
    }

    /**
     * @param goodsId 要查询的货物id
     * @return 查到返回查到的货物信息，没查到返回空
     */
    public Goods queryGoodsById(int goodsId) {
        for(int i =0; i<goods.size();i++){
            if(goods.get(i).getId() == goodsId)
                return goods.get(i);
        }
        return null;
    }

    /**
     * @param goodsName 要查询货物的名字
     * @return
     */
    public List<Goods> queryGoodsByName(String goodsName) {
        List<Goods> tempgoods = new ArrayList<>();
        for(int i =0; i<goods.size();i++){
            if(goods.get(i).getName().equals(goodsName))
                tempgoods.add(goods.get(i));
        }
        return tempgoods;
    }

    /**
     * @param lowerPrice 查询最低价格
     * @param highPrice 查询最高价格
     * @return 找到在此区间的goods
     */
    public List<Goods> queryGoodsByPrice(double lowerPrice, double highPrice) {
        // TODO deleted
        return null;
    }

    /**
     * @param goodsid 要删除货品的id
     * @return 陈宫删除返回对，否则为错
     */
    public boolean deleteGoods(int goodsid) {
        for(int i =0 ; i<goods.size(); i++){
              if(goods.get(i).getId() == goodsid){
                  goods.remove(i);
                  return true;
              }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public static int getTimes() {
        return times;
    }

    public static void setTimes(int times) {
        Warehouse.times = times;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return id == warehouse.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goods=" + goods +
                '}';
    }
}