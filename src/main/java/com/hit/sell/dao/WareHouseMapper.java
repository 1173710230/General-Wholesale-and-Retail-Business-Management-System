package com.hit.sell.dao;

import com.hit.sell.domain.WareHouse;

import java.util.List;

public interface WareHouseMapper {
    public List<WareHouse> getAllWareHouse();

    public String searchNameById(Integer id);

    public void insert(WareHouse wareHouse);

}
