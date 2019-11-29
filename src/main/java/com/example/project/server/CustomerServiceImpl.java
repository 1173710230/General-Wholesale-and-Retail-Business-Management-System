package com.example.project.server;

import com.example.project.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public List<Customer> getallCustomers() {
        return null;
    }

    @Override
    public boolean addCustomer(String name, String tel) {
        return false;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        return false;
    }

    @Override
    public boolean modifyCustomer(String name, String tel) {
        return false;
    }

    @Override
    public List<Customer> queryCustomerByName(String name) {
        return null;
    }
}
