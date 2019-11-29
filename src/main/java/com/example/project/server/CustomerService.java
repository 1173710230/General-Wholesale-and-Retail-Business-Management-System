package com.example.project.server;

import com.example.project.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    List<Customer> getallCustomers();

    boolean addCustomer(String name, String tel);

    boolean deleteCustomer(int customerId);

    boolean modifyCustomer(int customerId, String name, String tel);

    List<Customer> queryCustomerByName(String name);
}
