package com.hit.sell.dao;

import com.hit.sell.domain.SellOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellOrderMapper {
    public void insert(SellOrder sellorder);

    public void setStatusById(@Param("id") Integer id, @Param("status") Integer status);

    public void setPriceById(@Param("id")Integer id, @Param("price") double price);

    public void setNumberById(@Param("id")Integer id, @Param("number") Integer number);

    public void setRemarkById(@Param("id")Integer id, @Param("remark") String remark);

    public void setGoodsIdById(@Param("id")Integer id, @Param("goodsId") Integer goodsId);

    public SellOrder searchById(Integer id);

    public List<SellOrder> searchByStatus(Integer status);

    public void deleteById(Integer id);
}
