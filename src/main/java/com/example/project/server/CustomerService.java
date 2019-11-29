package com.example.project.server;

import com.example.project.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {


    /**
     * 获取所有用户
     *
     */
    List<Customer> getallCustomers();


    /**
     * 添加一个新客户
     *
     */
    boolean addCustomer(String name, String tel);


    /**
     * 按id删除一个客户
     *
     */
    boolean deleteCustomer(int customerId);


    /**
     * 更新id为customerid客户的信息
     *
     */
    boolean modifyCustomer(int customerId, String name, String tel);


    /**
     * 按名字查找客户
     *
     */
    List<Customer> queryCustomerByName(String name);
}
