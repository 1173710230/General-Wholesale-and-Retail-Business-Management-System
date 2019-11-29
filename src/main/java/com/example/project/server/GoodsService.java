package com.example.project.server;

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
     * 根据id将x修改为一个Goods
     *
     */
    boolean modifyGoodsById(int goodsId, String goodsName, String spec);

    /**
     * 按名字查询货物
     *
     */
    List<Goods> queryGoodsByName(String name);


}
