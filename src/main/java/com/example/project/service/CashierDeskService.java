package com.example.project.service;

import com.example.project.domain.SellOrderGroup;

public interface CashierDeskService {

    /**
     * 收款。为已审核且未付款的销售单收费，计算出总售价及利润并改变销售单状态
     * @param sellOrderGroup  待收费的订单
     * @return  如果销售单状态为审核通过，返回浮点数组，第一个数是总售价，第二个数是利润；
     *          否则返回null
     */
    public Double[] gathering(SellOrderGroup sellOrderGroup);
}
