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
        for(Customer customer:customerList){
            Double debt = customerMapper.getDebtById(customer.getCustomerId());
            if(debt == null)
                customer.setDebt(0.0);
            else
                customer.setDebt(debt);
        }
        return customerList;
    }

    @Override
    public boolean addCustomer(String name, String tel, int status) {
        Customer customer = new Customer();
        customer.setCustomerName(name);
        customer.setCustomerTel(tel);
        customer.setStatus(status);
        //传入包含名字和电话号码字符串的Customer对象
        customerMapper.insertCustomer(customer);
        return true;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        try {
            // 调用按id删除方法
            customerMapper.deleteById(customerId);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifyCustomer(int customerId, String name, String tel) {
        try {
            //调用按id修改名字，电话方法
            customerMapper.setNameById(customerId, name);
            customerMapper.setTelById(customerId, tel);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Customer> queryCustomerByName(String name) {
        // 调用按名字查询方法
        return customerMapper.searchByCustomerName(name);
    }

    @Override
    public boolean exchangeIntegral(int customerId) {
        Customer customer = customerMapper.searchById(customerId);
        if(customer == null)
            return false;
        int integral = (int) (customer.getCustomerIntegral() / 100);
        System.out.println(integral);
        customerMapper.exchangeCreditToDeposit(integral * 100.0, customerId);
        return true;
    }

    @Override
    public boolean addPreDeposit(double deposit, int customerId) {
        Customer customer = customerMapper.searchById(customerId);
        if(customer == null)
            return false;
        customerMapper.addDeposit(deposit,customerId);
        return true;
    }
}
