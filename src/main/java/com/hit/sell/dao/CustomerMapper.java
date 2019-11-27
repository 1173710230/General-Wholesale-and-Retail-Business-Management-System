package com.hit.sell.dao;

import com.hit.sell.domain.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {
    public void insertCustomer(Customer customer);

    public List<Customer> getAllCustomers();

    public List<Customer> searchByCustomerName(String name);

    public Customer searchById(Integer id);

    public void setNameById(@Param("id") Integer id, @Param("name") String name);

    public void setTelById(@Param("id") Integer id, @Param("tel") String tel);

    public void deleteById(Integer id);
}
