package com.wallet.serviceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.wallet.entity.Customer;
import com.wallet.entity.Wallet;
import com.wallet.exception.CustomerException;
import com.wallet.service.CustomerService;
import com.wallet.utils.DbUtils.GetConnection;

import jakarta.persistence.EntityManager;

public class CustomerServiceImpl implements CustomerService {

    private EntityManager entityManager;

    public CustomerServiceImpl() {
        this.entityManager =  GetConnection.getEmf().createEntityManager();
    }

    @Override
    public void addCustomer(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new CustomerException("Failed to add customer.", e);
        }
    }

    @Override
    public void removeCustomer(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            Customer entity = entityManager.find(Customer.class, customer.getMobileNumber());
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new CustomerException("Failed to remove customer.", e);
        }
    }

    @Override
    public Customer viewCustomer(String mobileNumber) {
        try {
            entityManager.getTransaction().begin();
            Customer customer = entityManager.find(Customer.class, mobileNumber);
            entityManager.getTransaction().commit();
            return customer;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new CustomerException("Failed to view customer.", e);
        }
    }

    @Override
    public List<Customer> viewAllCustomers() {
        try {
            entityManager.getTransaction().begin();
            List<Customer> customers = entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
            entityManager.getTransaction().commit();
            return customers;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new CustomerException("Failed to view all customers.", e);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(customer);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new CustomerException("Failed to update customer.", e);
        }
    }
    
    @Override
    public Customer registerCustomer(Scanner sc){
    	System.out.println("Enter name");
    	String name= sc.next();
    	System.out.println("Enter mob no");
    	String mobileNo=sc.next();
    	System.out.println("Enter password");
    	String password= sc.next();
    	Wallet newWallet= new Wallet( new BigDecimal("00.00"));
    	return new Customer(name,mobileNo,password,newWallet);
    }
}
