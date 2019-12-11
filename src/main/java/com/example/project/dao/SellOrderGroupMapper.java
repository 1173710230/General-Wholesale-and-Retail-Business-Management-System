package com.example.project.dao;

import com.example.project.domain.SellOrderGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellOrderGroupMapper {

    // todo 参数不知道呢
    void insertSellOrderGroup();

    /**
     * 根据传入条件查询销售单。
     * 这是通用查询，但是注意，不支持按照获利查询。
     *
     * @param group
     * @return
     */
    List<SellOrderGroup> querySellOrderGroup(SellOrderGroup group);

}
