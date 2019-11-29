package com.example.project.dao;


import com.example.project.domain.Warehouse;

import java.util.List;

public interface WareHouseMapper {
    public List<Warehouse> getAllWareHouse();

    public String searchNameById(int id);

    public void insert(Warehouse wareHouse);

}
