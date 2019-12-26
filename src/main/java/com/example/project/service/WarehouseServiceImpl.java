package com.example.project.service;

import com.example.project.dao.*;
import com.example.project.domain.Good;
import com.example.project.domain.Goods;
import com.example.project.domain.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.Console;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService{

    private final GoodsMapper goodsMapper;

    private final CustomerMapper customerMapper;

    private final SellOrderMapper sellOrderMapper;

    private final UserMapper userMapper;

    private final WareHouseMapper wareHouseMapper;

    @Autowired
    public WarehouseServiceImpl(GoodsMapper goodsMapper,
                                CustomerMapper customerMapper,
                                SellOrderMapper sellOrderMapper,
                                UserMapper userMapper,
                                WareHouseMapper wareHouseMapper) {
        this.goodsMapper = goodsMapper;
        this.customerMapper = customerMapper;
        this.sellOrderMapper = sellOrderMapper;
        this.userMapper = userMapper;
        this.wareHouseMapper = wareHouseMapper;
    }

    @Override
    public List<Goods> getGoodsFromAllWarehouse() {
        Goods goods = new Goods();
        // 获取关系表中....
        return goodsMapper.queryGoods(goods);
    }

    @Override
    public List<Goods> getGoodsFromCurrentWarehouse(int warehouseId){
        Goods goods = new Goods();
        goods.setWarehouseId(warehouseId);
        return goodsMapper.queryGoods(goods);
    }

    @Override
    public List<Goods> queryGoodsByName(String name) {
        Goods goods = new Goods();
        goods.setGoodsName(name);
        // 获取关系表中。。。
        return goodsMapper.queryGoods(goods);
    }

    @Override
    public List<Goods> queryGoodsFromCurrentWarehouseByName(String name, int warehouseId){
        Goods goods = new Goods();
        goods.setGoodsName(name);
        goods.setWarehouseId(warehouseId);
        return goodsMapper.queryGoods(goods);
    }
    @Override
    public boolean addGoodsToWareHouse(int checkGoodsId, double goodsNumber, int warehouseId){
        Goods goods = new Goods();
        goods.setGoodsId(checkGoodsId);
        goods.setGoodsNumber(goodsNumber);
        goods.setWarehouseId(warehouseId);
        try {
            // 如果数据库货物表中没有这一查验id，返回false
            // 调用货物入库方法
            wareHouseMapper.addGoodsToWarehouse(goods);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addNewGoods(double goodsNumber, String goodsName, String spec, int warehouseId){
        try {
            Goods goods = new Goods();
            Goods goods1 = new Goods();
            // 查询一遍
            //goods1.setGoodsId(checkGoodsId);
            //if (goodsMapper.queryGoods(goods).contains(goods1)) {
            //    return false;
            //}
            // 添加到Goods数据库
            Goods goods2 = new Goods();
            goods2.setGoodsName(goodsName);
            goods2.setGoodsSpecification(spec);
            goodsMapper.addGoods(goods2);
            int gid = goods2.getGoodsId();
            // 添加到货物仓库关系
            Goods goods3 = new Goods();
            goods3.setGoodsId(gid);
            goods3.setWarehouseId(warehouseId);
            goods3.setGoodsNumber(goodsNumber);
            wareHouseMapper.addGoodsToWarehouse(goods3);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean warehouseTransfer(int goodsId, int oldWarehouseId, int newWarehouseId, double goodsNumber){
        if(goodsNumber <= 0){
            System.out.println("输入的货物数量小等于0");
            return false;
        }
        Goods goods = new Goods();
        goods.setGoodsId(goodsId);
        goods.setWarehouseId(oldWarehouseId);
        Goods goods2 = new Goods();
        goods2.setGoodsId(goodsId);
        goods2.setWarehouseId(newWarehouseId);
        try {

            List<Goods> goodsList = goodsMapper.queryGoods(goods);
            if(!(goodsList.size() == 1 && goodsList.get(0).getGoodsNumber() >= goodsNumber))
                // 原仓库关系不存在或者原仓库货物数量不够出货的数量
                return false;
            //出货
            goodsMapper.reduceNumber(goodsId, goodsNumber, oldWarehouseId);
            List<Goods> goodsList1 = goodsMapper.queryGoods(goods2);
            if(goodsList1.size() == 0){
                //不存在关系
                goods2.setGoodsNumber(goodsNumber);
                goodsMapper.addGoodsWarehouseRelation(goods2);
            }else{
                goodsMapper.addNumber(goodsId, goodsNumber, newWarehouseId);
            }
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addWarehouse(String warehouseName) {
        try{
            wareHouseMapper.insert(warehouseName);
            return true;
        } catch(DataAccessException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateWarehouse(Integer warehouseId, String newName) {
        try{
            this.wareHouseMapper.updateWarehouseNameById(warehouseId, newName);
            return true;
        } catch(DataAccessException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteWarehouse(Integer warehouseId) {
        try{
            if (this.wareHouseMapper.queryAllGoodsInWarehouse(warehouseId).size() == 0){
                this.wareHouseMapper.deleteById(warehouseId);
                return true;
            } else
                return false;
        } catch (DataAccessException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Warehouse> getAllWarehouses(){
        return wareHouseMapper.getAllWareHouse();
    }

    @Override
    public List<Goods> displayTheStockQuantityOfEachWarehouse() {
        List<Goods> goods = goodsMapper.queryGoods(new Goods());
        for(Goods goods1:goods){
            double warehousePrice = goodsMapper.queryImportUnitPrice(goods1.getGoodsId());
            goods1.setWarehousePrice(warehousePrice);
        }
        if(CollectionUtils.isEmpty(goods)){
            return null;
        }
        //对list排序
        Collections.sort(goods,new Comparator<Goods>(){
            @Override
            public int compare(Goods goods1,Goods goods2){
                //升序排列
                if(goods1.getWarehouseId()!=null||goods2.getWarehouseId()!=null){
                    if(goods1.getWarehouseId() == goods2.getWarehouseId())
                        return goods1.getGoodsId().compareTo(goods2.getGoodsId());
                    else
                        return goods1.getWarehouseId().compareTo(goods2.getWarehouseId());
                }else {
                    return -1;
                }
            }

        });
        return goods;
    }

    @Override
    public List<Goods> displayTheBacklogOfFundsForEachItem() {
        List<Goods> goods = goodsMapper.queryGoods(new Goods());
        for(Goods goods1:goods){
            double warehousePrice = goodsMapper.queryImportUnitPrice(goods1.getGoodsId());
            goods1.setWarehousePrice(warehousePrice);
        }
        if(CollectionUtils.isEmpty(goods)){
            return null;
        }
        //对list排序
        Collections.sort(goods,new Comparator<Goods>(){
            @Override
            public int compare(Goods goods1,Goods goods2){
                //升序排列
                if(goods1.getGoodsId()!=null||goods2.getGoodsId()!=null){
                    if(goods1.getGoodsId() == goods2.getGoodsId())
                        return goods1.getWarehouseId().compareTo(goods2.getWarehouseId());
                    else
                        return goods1.getGoodsId().compareTo(goods2.getGoodsId());
                }else {
                    return -1;
                }
            }

        });
        return goods;
    }

}
