package com.example.project.dao;

import com.example.project.domain.InputOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImportOrderMapper {
    public void insert(InputOrder inputOrder);

    public List<Integer> searchNumbersByGoodsId(Integer goodsId);

}
