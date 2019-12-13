package com.example.project.dao;

import com.example.project.domain.SellOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellOrderMapper {

    /**
     * 增加一个销售单。
     *
     * @param sellOrder 新增加的销售单对象，这个sellOrder对象不需要有ID
     */
    void addSellOrder(SellOrder sellOrder);

    /**
     * 根据传入的对象修改销售单。
     *
     * @param sellOrder 没有实际意义的对象，
     *                  将其属性的ID设置为修改目标的ID，其他内容为希望修改的内容，
     *                  留为null表示不修改
     */
    void updateSellOrder(SellOrder sellOrder);

    /**
     * 根据orderId删除销售单。
     *
     * @param orderId 待删除的销售单ID
     */
    void deleteSellOrder(int orderId);

    /**
     * 根据ID获得销售单的其他信息。
     *
     * @param id 销售单ID
     * @return 一个销售单对象，如果没有查到，返回null
     */
    SellOrder getSellOrderById(int id);

    /**
     * 根据传入的销售单对象进行查询，返回满足条件的销售单列表。
     *
     * @param sellOrder 用于查询的销售单对象，留为null表示不根据该属性查询
     * @return 满足sellOrder所有非空属性的销售单列表
     */
    List<SellOrder> querySellOrder(SellOrder sellOrder);

}
