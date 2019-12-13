package com.example.project.service;

import com.example.project.domain.SellOrder;
import com.example.project.domain.SellOrderGroup;

public class CashierDeskServiceImpl implements CashierDeskService{
    @Override
    public Double[] gathering(SellOrderGroup sellOrderGroup) {
        Integer status = sellOrderGroup.getSellStatus();
        if (status == 2) { //销售单状态必须是已审核且未付款
            Double[] result = {0.0, 0.0};
            Double totalPrice = 0.0, salary = 0.0;

            for (SellOrder s : sellOrderGroup.getSellOrders()){
                totalPrice += s.getSellUnitPrice() * s.getSellNumber();
                // TODO: 进货价？
            }
            result[0] = totalPrice;
            result[1] = salary;

            sellOrderGroup.setSalary(salary);
            sellOrderGroup.setSellStatus(4);

            return result;
        }
        else
            //其他状态的销售单无法付款
            return null;
    }
}
