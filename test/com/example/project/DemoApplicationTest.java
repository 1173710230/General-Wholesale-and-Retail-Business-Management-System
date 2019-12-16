package com.example.project.service;


import com.example.project.dao.SellOrderGroupMapper;
import com.example.project.dao.SellOrderMapper;
import com.example.project.domain.*;
import com.example.project.service.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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


    @Test
    public void context(){
        System.out.println("测试开始！");
    }
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
       // inputOrderService.addNewInputOrder(100, 1.2, 1, date, "just Test");
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
    public void testGoods() {


    }

    @Test
    public void testCollection() {
        SellOrderGroup group = sellOrderGroupMapper.getSellOrderGroupById(1);
        System.out.println(group);
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
    }

    @Test
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
