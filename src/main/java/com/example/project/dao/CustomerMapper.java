package com.example.project.dao;

import com.example.project.domain.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {
    void insertCustomer(Customer customer);

    List<Customer> getAllCustomers();

    List<Customer> searchByCustomerName(String name);

    Customer searchById(int id);

    void setNameById(@Param("customerId") int customerId, @Param("customerName") String customerName);

    void setTelById(@Param("customerId") int customerId, @Param("customerTel") String customerTel);

    void deleteById(int id);
}
