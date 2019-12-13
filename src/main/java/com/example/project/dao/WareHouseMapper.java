package com.example.project.dao;


import com.example.project.domain.Goods;
import com.example.project.domain.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WareHouseMapper {

    /**
     * Get all warehouses.
     * @return  a list of warehouse
     */
    List<Warehouse> getAllWareHouse();

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

    /**
     * 调仓。
     * 转出仓库ID，转入仓库ID，货物ID有任意一个不存在，都会报错。
     *
     * @param goodsId        货物ID
     * @param oldWarehouseId 转出仓库ID
     * @param newWarehouseId 转入仓库ID
     * @param number         数量
     */
    void move(@Param("goodsId") int goodsId,
              @Param("oldWarehouseId") int oldWarehouseId,
              @Param("newWarehouseId") int newWarehouseId,
              @Param("number") double number);

}
