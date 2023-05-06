package com.wallet.service;

import java.util.List;

import com.wallet.entity.BankAccount;
import com.wallet.entity.Wallet;

public interface BankAccountService {
    void addBankAccount(BankAccount bankAccount);
    void removeBankAccount(BankAccount bankAccount);
    BankAccount viewBankAccount(Wallet wallet);
    List<BankAccount> viewAllBankAccounts(Wallet wallet);
}