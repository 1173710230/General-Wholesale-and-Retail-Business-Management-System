package com.example.project;


import com.example.project.domain.Customer;
import com.example.project.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
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
    public void testGoods(){

    }
}
