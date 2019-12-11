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
     * 按名字查询所有仓库中此货物
     *
     */
    List<Goods> queryGoodsByName(String name);


    /**
     * 商品入库
     *
     */
    boolean addGoodsToWareHouse(int checkGoodsId, double goodsNumber, int warehouseId);

    /**
     * 添加新货物（Goods表中没有的货物）
     *
     */
    boolean addNewGoods(double goodsNumber, String goodsName, String spec, int warehouseId);

    /**
     * 仓库调拨
     * 返回false，仓库不存在，原仓库货物数量不够，不存在这一货物
     */
    boolean warehouseTransfer(int goodsId, int oldWarehouseId, int newWarehouseId, double goodsNumber);

}
