package com.hit.sell.dao;

import com.hit.sell.domain.SellCustomerRelation;

import java.util.List;

public interface SellCustomerRelationMapper {
    public List<Integer> getOrderIdByCustomerId(Integer customerId);

    public void insertRelation(SellCustomerRelation scr);
}
