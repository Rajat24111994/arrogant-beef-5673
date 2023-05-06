package com.wallet.dao;

import java.util.List;

import com.wallet.entity.Customer;

public interface CustomerDAO {
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(String mobileNumber);
    public Customer getCustomerByMobileNumber(String mobileNumber);
    public List<Customer> getAllCustomers();
}

