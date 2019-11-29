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
    List<Goods> getallWirehouseGoods();


    /**
     * 根据id将删除一个Goods
     *
     */
    boolean deleteGoodsById(int Goods_id);

    /**
     * 根据id将x修改一个Goods
     *
     */
    boolean modifyGoodsById(int Goods_id);

    /**
     * 按名字查询货物
     *
     */
    List<Goods> queryGoodsByName(String name);


}
