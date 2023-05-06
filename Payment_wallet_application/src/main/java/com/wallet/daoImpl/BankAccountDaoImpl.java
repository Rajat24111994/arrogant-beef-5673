package com.wallet.daoImpl;

import java.util.List;

import com.wallet.dao.BankAccountDAO;
import com.wallet.entity.BankAccount;
import com.wallet.entity.Wallet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class BankAccountDaoImpl implements BankAccountDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBankAccount(BankAccount bankAccount) {
        entityManager.persist(bankAccount);
    }

    @Override
    public void removeBankAccount(BankAccount bankAccount) {
        entityManager.remove(bankAccount);
    }

    @Override
    public BankAccount viewBankAccount(Wallet wallet) {
        Query query = entityManager.createQuery("SELECT b FROM BankAccount b WHERE b.wallet = :wallet");
        query.setParameter("wallet", wallet);
        List<BankAccount> bankAccounts = query.getResultList();
        if (bankAccounts.isEmpty()) {
            return null;
        }
        return bankAccounts.get(0);
    }

    @Override
    public List<BankAccount> viewAllBankAccounts(Wallet wallet) {
        Query query = entityManager.createQuery("SELECT b FROM BankAccount b WHERE b.wallet = :wallet");
        query.setParameter("wallet", wallet);
        return query.getResultList();
    }
}
