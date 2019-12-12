package com.example.project.dao;


import com.example.project.domain.Goods;
import com.example.project.domain.Warehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WareHouseMapper {
    List<Warehouse> getAllWareHouse();

    String searchNameById(int id);

    void insert(Warehouse wareHouse);

    void addGoodsToWarehouse(Goods goods);

    /**
     * 根据传入的对象，查询warehouse列表。
     *
     * @param warehouse 查询条件
     * @return 满足条件的仓库列表
     */
    List<Warehouse> queryWarehouse(Warehouse warehouse);

    /**
     * 根据id更新仓库名字。
     *
     * @param id      待修改的仓库ID
     * @param newName 新的名字
     */
    void updateWarehouseNameById(int id, String newName);

}
