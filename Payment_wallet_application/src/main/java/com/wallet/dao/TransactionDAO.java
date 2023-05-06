package com.wallet.dao;

import java.time.LocalDate;
import java.util.List;

import com.wallet.entity.Transaction;
import com.wallet.entity.Wallet;

public interface TransactionDAO {
    public void addTransaction(Transaction transaction);
    public void updateTransaction(Transaction transaction);
    public void deleteTransaction(int transactionId);
    public Transaction getTransactionById(int transactionId);
    public List<Transaction> getAllTransactions();
    public List<Transaction> getTransactionsByWallet(Wallet wallet);
    public List<Transaction> getTransactionsByType(String type);
    public List<Transaction> getTransactionsByDate(LocalDate from, LocalDate to);
}

