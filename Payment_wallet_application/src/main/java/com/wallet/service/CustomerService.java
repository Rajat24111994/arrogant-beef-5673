package com.wallet.service;

import java.util.List;
import java.util.Scanner;

import com.wallet.entity.Customer;

public interface CustomerService {
    void addCustomer(Customer customer);
    void removeCustomer(Customer customer);
    Customer viewCustomer(String mobileNumber);
    List<Customer> viewAllCustomers();
    void updateCustomer(Customer customer);
    Customer registerCustomer(Scanner sc);
}