package com.wallet.serviceImpl;
import java.util.List;

import org.hibernate.TransactionException;

import com.wallet.entity.Transaction;
import com.wallet.service.TransactionService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class TransactionServiceImpl implements TransactionService {

    private EntityManager entityManager;

    public TransactionServiceImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("wallet_jpa");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void addTransaction(Transaction transaction) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(transaction);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new TransactionException("Error while adding transaction: " + e.getMessage());
        }
    }

    @Override
    public List<Transaction> viewAllTransactions(String type) {
        try {
            Query query = entityManager.createQuery("SELECT t FROM Transaction t WHERE t.type = :type");
            query.setParameter("type", type);
            List<Transaction> transactions = query.getResultList();
            return transactions;
        } catch (Exception e) {
            throw new TransactionException("Error while fetching transactions: " + e.getMessage());
        }
    }

}
