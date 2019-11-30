package com.example.project.service;

import com.example.project.domain.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WarehouseService {


    /**
     * 获取所有仓库中货物
     *
     */
    List<Goods> getGoodsFromAllWarehouse();


    /**
     * 按名字查询仓库中货物
     *
     */
    List<Goods> queryGoodsByName(String name);


    /**
     * 商品入库
     *
     */
    boolean addGoodsToWareHouse(int checkGoodsId, double goodsNumber, int warehouseId);

    /**
     * 按名字查询货物
     *
     */
    boolean addNewGoods(int checkGoodsId, int goodsNumber, String goodsName, String spec, int warehouseId);

}
