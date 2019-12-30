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

    /**
     * 给一个客户增加积分。
     *
     * @param credit     增加的积分
     * @param customerId 客户ID
     */
    void addCredit(@Param("credit") double credit, @Param("customerId") int customerId);

    /**
     * 减少一个客户的积分。
     *
     * @param credit     减少的积分
     * @param customerId 客户ID
     */
    void reduceCredit(@Param("credit") double credit, @Param("customerId") int customerId);

    /**
     * 获得一个客户的积分。
     *
     * @param id 客户ID
     */
    void getCreditByCustomerId(int id);

    /**
     * 增加一个客户的预存款。
     *
     * @param deposit    预存款
     * @param customerId 客户ID
     */
    void addDeposit(@Param("deposit") double deposit, @Param("customerId") int customerId);

    /**
     * 减少一个客户的预存款。
     *
     * @param deposit    减少的预存款
     * @param customerId 客户ID
     */
    void reduceDeposit(@Param("deposit") double deposit, @Param("customerId") int customerId);

    /**
     * 根据一个客户的ID获取他的剩余预存款。
     *
     * @param id 客户ID
     * @return 客户的预存款余额
     */
    double getDepositByCustomerId(int id);

    /**
     * 获得客户欠款。
     *
     * @param id 客户ID
     * @return 客户欠款，如果客户没有欠款，则该值是null
     */
    Double getDebtById(int id);

    /**
     * 将积分兑换成钱钱。
     */
    void exchangeCreditToDeposit(@Param("credit") double useCredit, @Param("id") int customerId);

}
