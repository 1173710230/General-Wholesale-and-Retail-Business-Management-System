package com.example.project.server;

import com.example.project.domain.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WarehouseService {

    List<Goods> getGoodsfromallWarehouse();

    List<Goods> queryGoodsByName(String name);

    boolean addNewGoods(int checkgoodsId, int goodsnumber, String goodsName, String spec, int warehouseId);

}
