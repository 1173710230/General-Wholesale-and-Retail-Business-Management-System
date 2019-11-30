package com.example.project.service;

import com.example.project.dao.CustomerMapper;
import com.example.project.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerMapper customerMapper){
        this.customerMapper = customerMapper;
    }

    @Override
    public List<Customer> getallCustomers() {
        List<Customer> customerList = customerMapper.getAllCustomers();
        return customerList;
    }

    @Override
    public boolean addCustomer(String name, String tel) {
        Customer customer = new Customer();
        customer.setCustomerName(name);
        customer.setCustomerTel(tel);
        customerMapper.insertCustomer(customer);
        return true;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        try {
            customerMapper.deleteById(customerId);
            return true;
        } catch (DataAccessException ex) {
            return false;
        }
    }

    @Override
    public boolean modifyCustomer(int customerId, String name, String tel) {
        try {
            customerMapper.setNameById(customerId, name);
            customerMapper.setTelById(customerId, tel);
            return true;
        } catch (DataAccessException ex) {
            return false;
        }
    }

    @Override
    public List<Customer> queryCustomerByName(String name) {
        return customerMapper.searchByCustomerName(name);
    }
}
