package com.example.project;


import com.example.project.dao.SellOrderGroupMapper;
import com.example.project.dao.SellOrderMapper;
import com.example.project.domain.Customer;
import com.example.project.domain.SellOrder;
import com.example.project.domain.SellOrderGroup;
import com.example.project.domain.User;
import com.example.project.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private UserService userService;


    @Test
    public void testCustomers() {
        System.out.println(customerService.getallCustomers());
        System.out.println(customerService.addCustomer("卢本伟","CCTV"));
        System.out.println(customerService.queryCustomerByName("卢本伟"));
        System.out.println(customerService.deleteCustomer(7));
        System.out.println(customerService.modifyCustomer(11,"FBI","911"));
    }

    @Test
    public void testInputOrder() {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        System.out.println(inputOrderService.addNewInputOrder(100.0, 1.2, 1, date, "just Test",1));
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


        //sellOrderService.addSellOrder(parse, 1, 1.5, 80.0, 2, "Cheap");

    }

    @Test
    public void testGoods() {
        // System.out.println(goodsService.getAllWarehouseGoods());
        //System.out.println(goodsService.deleteGoodsById(2));
        //System.out.println(goodsService.modifyGoodsById(7,"朱业琪","pa"));
        System.out.println(goodsService.queryGoodsByName("朱业琪"));

    }

    @Test
    public void testSellOrder() {
        SellOrderGroup sellOrderGroup = new SellOrderGroup();
        sellOrderGroup.setSellOrderType(0);
        sellOrderGroup.setSellOrderRemark("test");
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sellOrderGroup.setSellTime(format.format(date));
        sellOrderGroup.setCustomerId(11);
        sellOrderGroup.setWarehouseId(1);
        List<SellOrder>  sellOrderList = new ArrayList<>();
        sellOrderList.add(new SellOrder(null,50.0,201.0,11));
        sellOrderList.add(new SellOrder(null,50.0,201.0,12));
        sellOrderList.add(new SellOrder(null,50.0,201.0,13));
        sellOrderGroup.setSellOrders(sellOrderList);
        sellOrderService.addSellOrder(sellOrderGroup);
    }

    @Test
    public void testSellOder(){
        SellOrderGroup sellOrderGroup = new SellOrderGroup();
        sellOrderGroup.setSellOrderType(0);
        sellOrderGroup.setSellOrderRemark("test for double");
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sellOrderGroup.setSellTime(format.format(date));
        sellOrderGroup.setCustomerId(12);
        sellOrderGroup.setWarehouseId(2);
        sellOrderGroup.setSellStatus(1);
        List<SellOrder>  sellOrderList = new ArrayList<>();
        sellOrderList.add(new SellOrder(null,50.0,101.0,12));
        sellOrderList.add(new SellOrder(null,50.0,101.0,12));
        sellOrderList.add(new SellOrder(null,100.0,201.0,13));
        sellOrderList.add(new SellOrder(null,50.0,201.0,9));
        sellOrderGroup.setSellOrders(sellOrderList);
        sellOrderGroup.setSellOrderGroupId(7);
        System.out.println("1");
        sellOrderService.modifySellOrder(sellOrderGroup);

    }

    @Test
    public void testUser(){
        //System.out.println(userService.getUserById(1));
//        System.out.println(userService.login(1,"43962"));
//        System.out.println(userService.login(1,"123456"));
        //User user = new User(1,"滑天下之大稽","123456",2);
        //userService.updateUserMessage(user);
    }
    @Test
    public void testWarehouseQuery() {
        //log.info(warehouseService.queryGoodsByName("苹果"));
    }

}
