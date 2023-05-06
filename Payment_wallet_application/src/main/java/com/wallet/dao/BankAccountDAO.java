package com.wallet.dao;
import java.util.List;

import com.wallet.entity.BankAccount;
import com.wallet.entity.Wallet;

public interface BankAccountDAO {
    public void addBankAccount(BankAccount bankAccount);
    public void removeBankAccount(BankAccount bankAccount);
    public BankAccount viewBankAccount(Wallet wallet);
    public List<BankAccount> viewAllBankAccounts(Wallet wallet);
}

