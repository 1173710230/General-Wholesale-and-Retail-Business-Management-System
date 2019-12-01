package com.example.project;


import com.example.project.domain.Customer;
import com.example.project.service.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTest {

    @Autowired
    private  CustomerService customerService;
    @Autowired
    private  GoodsService goodsService;
    @Autowired
    private  InputOrderService inputOrderService;
    @Autowired
    private  SellOrderService sellOrderService;
    @Autowired
    private  WarehouseService warehouseService;




    @Test
    public void testCustomers() {
        Customer customer = new Customer();
        customer.setCustomerTel("10086");
        customer.setCustomerName("中国移动");
        Customer customer1 = new Customer();
        customer1.setCustomerTel("10010");
        customer1.setCustomerName("中国联通");
        customerService.addCustomer("lbw","17cards");
        System.out.println(customerService.queryCustomerByName("中国移动"));
    }

    @Test
    public void testInputOrder(){
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        inputOrderService.addNewInputOrder(100,1.2,1,date,"just Test");
    }

    @Test
    public void testAddOrder(){
        Date date = new Date(System.currentTimeMillis());
        sellOrderService.addSellOrder(date,1,1.5,80,2,"Cheap");

    }

    @Test
    public void  testGoods(){


    }
}
