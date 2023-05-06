package com.wallet.daoImpl;

import java.util.List;

import com.wallet.dao.WalletDAO;
import com.wallet.entity.Wallet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class WalletDAOImpl implements WalletDAO {

    private EntityManager entityManager;
    
    public WalletDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addWallet(Wallet wallet) {
        entityManager.getTransaction().begin();
        entityManager.persist(wallet);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateWallet(Wallet wallet) {
        entityManager.getTransaction().begin();
        entityManager.merge(wallet);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteWallet(int walletid) {
        entityManager.getTransaction().begin();
        Wallet wallet = entityManager.find(Wallet.class, walletid);
        entityManager.remove(wallet);
        entityManager.getTransaction().commit();
    }

    @Override
    public Wallet getWalletById(int walletid) {
        return entityManager.find(Wallet.class, walletid);
    }

    @Override
    public List<Wallet> getAllWallets() {
        Query query = entityManager.createQuery("SELECT w FROM Wallet w");
        return query.getResultList();
    }

}
