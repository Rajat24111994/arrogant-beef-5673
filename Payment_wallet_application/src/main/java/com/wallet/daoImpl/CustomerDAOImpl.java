package com.wallet.daoImpl;

import java.util.List;

import com.wallet.dao.CustomerDAO;
import com.wallet.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CustomerDAOImpl implements CustomerDAO {

    private EntityManager entityManager;

    public CustomerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addCustomer(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateCustomer(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.merge(customer);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCustomer(String mobileNumber) {
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, mobileNumber);
        if (customer != null) {
            entityManager.remove(customer);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Customer getCustomerByMobileNumber(String mobileNumber) {
        return entityManager.find(Customer.class, mobileNumber);
    }

    @Override
    public List<Customer> getAllCustomers() {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }
}
