package com.wallet.serviceImpl;

import java.util.List;

import com.wallet.entity.Wallet;
import com.wallet.service.WalletService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class WalletServiceImpl implements WalletService {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("wallet");

    @Override
    public void addWallet(Wallet wallet) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(wallet);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void removeWallet(Wallet wallet) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(wallet);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Wallet> viewAllWallets() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Wallet> query = entityManager.createQuery("SELECT w FROM Wallet w", Wallet.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void updateWallet(Wallet wallet) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(wallet);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

}
