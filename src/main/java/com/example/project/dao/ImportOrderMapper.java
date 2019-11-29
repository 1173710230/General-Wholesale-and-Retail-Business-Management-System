package com.example.project.dao;

import com.example.project.domain.InputOrder;

import java.util.List;

public interface ImportOrderMapper {
    public void insert(InputOrder inputOrder);

    public List<Integer> searchNumbersByGoodsId(Integer goodsId);

}
