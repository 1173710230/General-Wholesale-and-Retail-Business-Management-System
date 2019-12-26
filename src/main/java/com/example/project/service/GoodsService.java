package com.example.project.service;

import com.example.project.domain.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {

    /**
     * 获取所有仓库中货物
     *
     */
    List<Goods> getAllWarehouseGoods();


    /**
     * 根据id将删除一个Goods与所有仓库的关系
     *
     */
    boolean deleteGoodsById(int GoodsId);

    /**
     * 根据id将x修改为一个Goods（不包含价格信息）
     *
     */
    boolean modifyGoodsById(int goodsId, String goodsName, String spec);

    /**
     * 按名字查询货物
     *
     */
    List<Goods> queryGoodsByName(String name);

    /**
     *  修改货物批发价与零售价
     */
    boolean modifyGoodsPriceById(int goodsId, double wholesalePrice, double retailPrice);

    /**
     * 获取批发价
     */
    double getWholeSalePrice(int goodsId);

    /**
     * 获取零售价
     */
    double getRetailPrice(int goodsId);

}
