package com.example.project.service;

import com.example.project.domain.Goods;
import com.example.project.domain.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WarehouseService {


    /**
     * 获取所有仓库中货物
     *
     */
    List<Goods> getGoodsFromAllWarehouse();


    /**
     * 获取当前仓库中货物
     *
     */
    List<Goods> getGoodsFromCurrentWarehouse(int warehouseId);


    /**
     * 按名字查询所有仓库中此货物
     *
     */
    List<Goods> queryGoodsByName(String name);

    /**
     * 按名字查询当前仓库中此货物
     *
     */
    List<Goods> queryGoodsFromCurrentWarehouseByName(String name, int warehouseId);


    /**
     * 商品入库
     *
     */
    boolean addGoodsToWareHouse(int checkGoodsId, double goodsNumber, int warehouseId);

    /**
     * 添加新货物（Goods表中没有的货物）
     *
     */
    boolean addNewGoods(double goodsNumber, String goodsName, String spec, int warehouseId);

    /**
     * 仓库调拨
     * 返回false，仓库不存在，原仓库货物数量不够，不存在这一货物
     */
    boolean warehouseTransfer(int goodsId, int oldWarehouseId, int newWarehouseId, double goodsNumber);

    /**
     * 新建一个仓库
     * @param warehouseName
     * @return  添加成功返回true，否则返回false
     */
    boolean addWarehouse(String warehouseName);

    /**
     * 修改仓库名
     * @param warehouseId  仓库id
     * @param newName   新名字
     * @return  修改成功返回true，否则返回false
     */
    boolean updateWarehouse(Integer warehouseId, String newName);

    /**
     * 删除一个仓库
     * @param warehouseId  待删除的仓库的id
     * @return  删除成功返回true，否则返回false
     */
    boolean deleteWarehouse(Integer warehouseId);

    /**
     * 获取全部仓库
     */
    List<Warehouse> getAllWarehouses();

}
