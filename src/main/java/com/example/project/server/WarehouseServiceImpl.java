package com.example.project.server;

import com.example.project.domain.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService{
    @Override
    public List<Goods> getGoodsfromallWarehouse() {
        return null;
    }

    @Override
    public List<Goods> queryGoodsByName(String name) {
        return null;
    }

    @Override
    public boolean addNewGoods(int checkgoodsId, int goodsnumber, String goodsName, String spec, int warehouseId) {
        return false;
    }
}
