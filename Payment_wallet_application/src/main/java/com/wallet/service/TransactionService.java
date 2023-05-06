package com.wallet.service;

import java.util.List;

import com.wallet.entity.Transaction;

public interface TransactionService {
    void addTransaction(Transaction transaction);
    List<Transaction> viewAllTransactions(String type);
}
