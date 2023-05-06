package com.wallet.serviceImpl;

import java.util.List;

import com.wallet.dao.BankAccountDAO;
import com.wallet.entity.BankAccount;
import com.wallet.entity.Wallet;
import com.wallet.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountDAO bankAccountDAO;

    public void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
        this.bankAccountDAO = bankAccountDAO;
    }

    @Override
    public void addBankAccount(BankAccount bankAccount) {
        bankAccountDAO.addBankAccount(bankAccount);
    }

    @Override
    public void removeBankAccount(BankAccount bankAccount) {
        bankAccountDAO.removeBankAccount(bankAccount);
    }

    @Override
    public BankAccount viewBankAccount(Wallet wallet) {
        return bankAccountDAO.viewBankAccount(wallet);
    }

    @Override
    public List<BankAccount> viewAllBankAccounts(Wallet wallet) {
        return bankAccountDAO.viewAllBankAccounts(wallet);
    }

}

