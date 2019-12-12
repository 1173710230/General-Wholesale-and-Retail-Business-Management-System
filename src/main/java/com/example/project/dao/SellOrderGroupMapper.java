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
     * 根据传入条件查询销售单。
     * 这是通用查询，但是注意，不支持按照获利查询。
     *
     * @param group
     * @return
     */
    List<SellOrderGroup> querySellOrderGroup(SellOrderGroup group);

}
