package com.example.project.dao;

import com.example.project.domain.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {
    /**
     * 插入一个新的客户。
     *
     * @param customer 新的客户对象
     */
    void insertCustomer(Customer customer);

    /**
     * 获得所有的客户。
     *
     * @return 返回数据库中所有的客户
     */
    List<Customer> getAllCustomers();

    /**
     * 用名字搜索客户，这是一个模糊搜索，包含关系即成立。
     *
     * @param name 搜索的名字
     * @return 客户对象的列表
     */
    List<Customer> searchByCustomerName(String name);

    /**
     * 使用客户的ID获得客户的其他信息。
     *
     * @param id 客户ID
     * @return 返回客户的对象
     */
    Customer searchById(int id);

    /**
     * 使用客户的ID修改客户的名字。
     *
     * @param customerId   客户ID
     * @param customerName 新的客户名
     */
    void setNameById(@Param("customerId") int customerId, @Param("customerName") String customerName);

    /**
     * 根据客户ID设置电话号码。
     *
     * @param customerId  客户ID
     * @param customerTel 新的电话号码
     */
    void setTelById(@Param("customerId") int customerId, @Param("customerTel") String customerTel);

    /**
     * 使用ID删除一个客户。
     *
     * @param id 客户ID
     */
    void deleteById(int id);
}
