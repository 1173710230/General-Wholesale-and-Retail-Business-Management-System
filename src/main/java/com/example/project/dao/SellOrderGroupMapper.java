package com.example.project.dao;

import com.example.project.domain.SellOrderGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellOrderGroupMapper {

    /**
     * 增加一个销售单（组）。
     *
     * @param group 销售单对象
     */
    void insertSellOrderGroup(SellOrderGroup group);

    /**
     * 添加顾客和销售单的关系。
     *
     * @param group 将其中的顾客ID和销售单ID作为关系添加
     */
    void addSellOrderCustomerRelation(SellOrderGroup group);

    /**
     * 根据传入条件查询销售单。
     * 这是通用查询，但是注意，不支持按照获利查询。
     *
     * @param group
     * @return
     */
    List<SellOrderGroup> querySellOrderGroup(SellOrderGroup group);

    /**
     * 根据传入的对象修改销售单。
     *
     * @param group 没有实际意义的对象，
     *                  将其属性的ID设置为修改目标的ID，其他内容为希望修改的内容，
     *                  留为null表示不修改
     */
    void updateSellOrderGroup(SellOrderGroup group);

}
