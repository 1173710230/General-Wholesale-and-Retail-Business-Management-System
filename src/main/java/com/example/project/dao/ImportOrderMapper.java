package com.example.project.dao;

import com.example.project.domain.InputOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImportOrderMapper {

    void insert(InputOrder inputOrder);

    List<Integer> searchNumbersByGoodsId(Integer goodsId);

    /**
     * Query import orders by passed in conditions.
     *
     * @param order conditions that uses as filter
     * @return a list that satisfy your conditions
     */
    List<InputOrder> queryImportOrder(InputOrder order);

    /**
     * Get an import object by its ID, or null if this ID does not exist.
     *
     * @param id ID of an import order
     * @return the import order object with the ID
     */
    InputOrder getImportOrderById(int id);


}
