package com.wallet.daoImpl;
import java.time.LocalDate;
import java.util.List;

import com.wallet.dao.TransactionDAO;
import com.wallet.entity.Transaction;
import com.wallet.entity.Wallet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class TransactionDAOImpl implements TransactionDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addTransaction(Transaction transaction) {
        entityManager.persist(transaction);
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        entityManager.merge(transaction);
    }

    @Override
    public void deleteTransaction(int transactionId) {
        Transaction transaction = entityManager.find(Transaction.class, transactionId);
        if (transaction != null) {
            entityManager.remove(transaction);
        }
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        return entityManager.find(Transaction.class, transactionId);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        TypedQuery<Transaction> query = entityManager.createQuery("SELECT t FROM Transaction t", Transaction.class);
        return query.getResultList();
    }

    @Override
    public List<Transaction> getTransactionsByWallet(Wallet wallet) {
        TypedQuery<Transaction> query = entityManager.createQuery("SELECT t FROM Transaction t WHERE t.wallet = :wallet", Transaction.class);
        query.setParameter("wallet", wallet);
        return query.getResultList();
    }

    @Override
    public List<Transaction> getTransactionsByType(String type) {
        TypedQuery<Transaction> query = entityManager.createQuery("SELECT t FROM Transaction t WHERE t.type = :type", Transaction.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    @Override
    public List<Transaction> getTransactionsByDate(LocalDate from, LocalDate to) {
        TypedQuery<Transaction> query = entityManager.createQuery("SELECT t FROM Transaction t WHERE t.date BETWEEN :from AND :to", Transaction.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        return query.getResultList();
    }
}
