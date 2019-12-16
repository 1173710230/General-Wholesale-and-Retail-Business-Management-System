package com.example.project.service;


import com.example.project.dao.SellOrderGroupMapper;
import com.example.project.dao.SellOrderMapper;
<<<<<<< HEAD
import com.example.project.domain.*;
=======
import com.example.project.domain.Customer;
import com.example.project.domain.SellOrder;
import com.example.project.domain.SellOrderGroup;
import com.example.project.domain.User;
>>>>>>> 56f959838769e1226907818ec6d725f23431c65d
import com.example.project.service.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
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
    public void context(){
        System.out.println("测试开始！");
    }
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
<<<<<<< HEAD
       // inputOrderService.addNewInputOrder(100, 1.2, 1, date, "just Test");
=======
        System.out.println(inputOrderService.addNewInputOrder(100.0, 1.2, 1, date, "just Test",1));
>>>>>>> 56f959838769e1226907818ec6d725f23431c65d
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


<<<<<<< HEAD
//        sellOrderService.addSellOrder(parse, 1, 1.5, 80.0, 2, "Cheap");
=======
        //sellOrderService.addSellOrder(parse, 1, 1.5, 80.0, 2, "Cheap");
>>>>>>> 56f959838769e1226907818ec6d725f23431c65d

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

//    @Test
//    public void testUser(){
//        userService.register("滑稽1","43961",0);
//        userService.register("滑稽2","43962",1);
//        System.out.println(userService.register("滑稽2","43963",2));
//    }
//    @Test
//    public void testWarehouseQuery() {
//        log.info(warehouseService.queryGoodsByName("苹果"));
//    }

    @Test
    public void testGetGoodsFromAllWarehouse(){
        for (Goods g : this.warehouseService.getGoodsFromAllWarehouse()){
            System.out.println(g.toString());
        }
    }

    @Test
    public void testGetGoodsFromCurrentWarehouse(){
        List<Goods> goods = this.warehouseService.getGoodsFromCurrentWarehouse(1);
        System.out.println("仓库1货物：" );
        for (Goods g: goods){
            System.out.println(g.toString());
        }
    }

    @Test
    public void testQueryGoodsByName(){
        String name = "梨子";
        List<Goods> goods = this.warehouseService.queryGoodsByName(name);
        System.out.println("货物" + name + "信息：");
        for (Goods g : goods){
            System.out.println(g.toString());
        }
    }

    @Test
<<<<<<< HEAD
    public void testQueryGoodsFromCurrentWarehouseByName(){
        String name = "梨子";
        Integer id = 1;
        List<Goods> goods = this.warehouseService.queryGoodsFromCurrentWarehouseByName(name, id);
        System.out.println("货物" + name + "在仓库" + id + "中的信息");

        for (Goods g : goods){
            System.out.println(g.toString());
        }
    }

    @Test
    public void testAddGoodsToWareHouse(){
        int checkGoodsId = 2, warehouseId = 1;
        Double goodNumber = 100.0;
        String name = "梨子";
        List<Goods> goods = this.warehouseService.queryGoodsFromCurrentWarehouseByName(name, warehouseId);
        System.out.println("添加前：");
        for (Goods g : goods){
            System.out.println(g.toString());
        }
        this.warehouseService.addGoodsToWareHouse(checkGoodsId, goodNumber, warehouseId);
        System.out.println("添加后");
        goods = this.warehouseService.queryGoodsFromCurrentWarehouseByName(name, warehouseId);
        for (Goods g : goods){
            System.out.println(g.toString());
        }
    }

    @Test
    public void testAddNewGoods(){
        int checkGoodsId = 8, warehouseId = 2;
        Double goodNumber = 80.0;
        String name = "苹果";
        List<Goods> goods = this.warehouseService.queryGoodsFromCurrentWarehouseByName(name, warehouseId);
        System.out.println("添加前：");
        for (Goods g : goods){
            System.out.println(g.toString());
        }
        this.warehouseService.addGoodsToWareHouse(checkGoodsId, goodNumber, warehouseId);
        System.out.println("添加后");
        goods = this.warehouseService.queryGoodsFromCurrentWarehouseByName(name, warehouseId);
        for (Goods g : goods) {
            System.out.println(g.toString());
        }
    }

    @Test
    public void testWarehouseTransfer(){
        boolean result;
        int goodsId = 2;
        int oldWarehouse = 1, newWarehouse = 2;
        double number = 10.0;
        String name = "梨子";
        System.out.println("调拨前:");
        List<Goods> goods = this.warehouseService.queryGoodsFromCurrentWarehouseByName(name, oldWarehouse);
        for (Goods g : goods){
            System.out.println(g.toString());
        }
        goods = this.warehouseService.queryGoodsFromCurrentWarehouseByName(name, newWarehouse);
        for (Goods g : goods){
            System.out.println(g.toString());
        }
        result = this.warehouseService.warehouseTransfer(goodsId, oldWarehouse, newWarehouse,number);
        System.out.println(result);
        System.out.println("调拨后");
        goods = this.warehouseService.queryGoodsFromCurrentWarehouseByName(name, oldWarehouse);
        for (Goods g : goods){
            System.out.println(g.toString());
        }
        goods = this.warehouseService.queryGoodsFromCurrentWarehouseByName(name, newWarehouse);
        for (Goods g : goods){
            System.out.println(g.toString());
        }
=======
    public void testUser(){
        //System.out.println(userService.getUserById(1));
        System.out.println(userService.login(1,"43962"));
        System.out.println(userService.login(1,"123456"));
        //User user = new User(1,"滑天下之大稽","123456",2);
        //userService.updateUserMessage(user);
>>>>>>> 56f959838769e1226907818ec6d725f23431c65d
    }

    @Test
<<<<<<< HEAD
    public void testAddWarehouse(){
        List<Warehouse> warehouses;
        warehouses = this.warehouseService.getAllWarehouses();
        System.out.println("添加前");
        for (Warehouse w : warehouses){
            System.out.println(w.toString());
        }
        this.warehouseService.addWarehouse("六号仓库");
        System.out.println("添加后");
        warehouses = this.warehouseService.getAllWarehouses();
        for (Warehouse w : warehouses){
            System.out.println(w.toString());
        }

=======
    public void testWarehouseQuery() {
        //log.info(warehouseService.queryGoodsByName("苹果"));
>>>>>>> 56f959838769e1226907818ec6d725f23431c65d
    }

    @Test
    public void testUpdateWarehouse(){
        List<Warehouse> warehouses;
        this.warehouseService.updateWarehouse(7, "六号cangku");
        warehouses = this.warehouseService.getAllWarehouses();
        for (Warehouse w : warehouses){
            System.out.println(w.toString());
        }
    }

    @Test
    public void testDeleteWarehouse(){
        List<Warehouse> warehouses;
        this.warehouseService.deleteWarehouse(7);
        warehouses = this.warehouseService.getAllWarehouses();
        for (Warehouse w : warehouses){
            System.out.println(w.toString());
        }
    }

    @Test
    public void testSellOrder(){
        System.out.println(this.sellOrderService.checkOrder(1, true));
        System.out.println(this.sellOrderService.checkOrder(2, true));
    }

    @Test
    public void testPayCheckOrder(){
        System.out.println(this.sellOrderService.paySellOrder(2));
    }

    @Test
    public void testRefundSellOrder(){
        System.out.println(this.sellOrderService.refundSellOrder(1));
    }

    @Test
    public void testGetUnpaidOrder(){
        for (SellOrderGroup sg : this.sellOrderService.getUnpaidOrder()){
            System.out.println(sg.toString());
        }
    }

    @Test
    public void testGetUnRefundOrder(){
        for (SellOrderGroup sg : this.sellOrderService.getUnRefundOrder()){
            System.out.println(sg.toString());
        }
    }

    @Test
    public void testGetSellOrderProfitAndTotalPrice(){
        System.out.println(this.sellOrderService.getSellOrderGroupProfit(1));
        System.out.println(this.sellOrderService.getSellOrderGroupTotalPrice(1));
    }
}
