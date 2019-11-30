package com.example.project.dao;


import com.example.project.domain.Goods;
import com.example.project.domain.Warehouse;

import java.util.List;

public interface WareHouseMapper {
    List<Warehouse> getAllWareHouse();

    String searchNameById(int id);

    void insert(Warehouse wareHouse);

    void addGoodsToWarehouse(Goods goods);

}
