package com.example.project.dao;

import com.hit.sell.domain.ImportOrder;
import com.sun.xml.internal.ws.wsdl.writer.document.Import;

import java.util.List;

public interface ImportOrderMapper {
    public void insert(ImportOrder importOrder);

    public List<Integer> searchNumbersByGoodsId(Integer goodsId);

}
