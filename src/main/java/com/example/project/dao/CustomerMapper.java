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

    Customer searchById(Integer id);

    void setNameById(@Param("id") Integer id, @Param("name") String name);

    void setTelById(@Param("id") Integer id, @Param("tel") String tel);

    void deleteById(Integer id);
}
