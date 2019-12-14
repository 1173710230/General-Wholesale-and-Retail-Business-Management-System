package com.example.project;


import com.example.project.dao.SellOrderGroupMapper;
import com.example.project.domain.Customer;
import com.example.project.domain.SellOrderGroup;
import com.example.project.service.*;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private InputOrderService inputOrderService;

    @Autowired
    private SellOrderService sellOrderService;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private SellOrderGroupMapper sellOrderGroupMapper;

    private Logger log = Logger.getLogger(DemoApplicationTest.class);

    @Test
    public void testCustomers() {
        Customer customer = new Customer();
        customer.setCustomerTel("10086");
        customer.setCustomerName("中国移动");
        Customer customer1 = new Customer();
        customer1.setCustomerTel("10010");
        customer1.setCustomerName("中国联通");
        customerService.addCustomer("lbw", "17cards");
        System.out.println(customerService.queryCustomerByName("中国移动"));
    }

    @Test
    public void testInputOrder() {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
//        inputOrderService.addNewInputOrder(100, 1.2, 1, date, "just Test");
    }

    @Test
    public void testAddOrder() throws ParseException {

        // Date date = new Date(System.currentTimeMillis());

        // 将提交的数据添加到数据库中.
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = sf.format(new Date());
        Date parse = sf.parse(format);
        System.out.println("1:" + new Date());
        System.out.println("2:" + parse);


//        sellOrderService.addSellOrder(parse, 1, 1.5, 80.0, 2, "Cheap");

    }

    @Test
    public void testQuerySellOrderGrouo() {
        log.info(sellOrderGroupMapper.getSellOrderGroupById(1));

    }

    @Test
    public void testCollection() {
        SellOrderGroup group = sellOrderGroupMapper.getSellOrderGroupById(1);
        System.out.println(group);
    }

}
