package com.example.project.server;

import com.example.project.domain.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Override
    public List<Goods> getallWirehouseGoods() {
        return null;
    }

    @Override
    public boolean deleteGoodsById(int Goods_id) {
        return false;
    }

    @Override
    public boolean modifyGoodsById(int Goods_id) {
        return false;
    }

    @Override
    public List<Goods> queryGoodsByName(String name) {
        return null;
    }
}
