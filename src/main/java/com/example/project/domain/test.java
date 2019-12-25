package com.example.project.domain;


import net.minidev.json.JSONObject;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

public class test {
    //排序
    public static void main(String[] args) {
        List<Good> price = new ArrayList<>();
        Good Good1 = new Good();
        Good Good2 = new Good();
        Good Good3 = new Good();
        Good Good4 = new Good();
        Good1.setPrice(BigDecimal.valueOf(12.3));
        Good2.setPrice(BigDecimal.valueOf(18.9));
        Good3.setPrice(BigDecimal.valueOf(3.33));
        Good4.setPrice(BigDecimal.valueOf(111.1));
        price.add(Good1);
        price.add(Good2);
        price.add(Good3);
        price.add(Good4);
        System.out.println(price);
        if(CollectionUtils.isEmpty(price)){
            return ;
        }
        //对list排序
        Collections.sort(price,new Comparator<Good>(){
            @Override
            public int compare(Good Good1,Good Good2){
                //升序排列
                if(Good1.getPrice()!=null||Good2.getPrice()!=null){
                    return Good1.getPrice().compareTo(Good2.getPrice());
                }else {
                    return -1;
                }
            }

        });
        System.out.println(price);
        //取最小值
        BigDecimal onePrice = price.get(0).getPrice();
        System.out.println(onePrice);
    }


}
