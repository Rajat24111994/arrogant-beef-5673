package com.wallet.service;

import java.util.List;

import com.wallet.entity.Wallet;

public interface WalletService {
    void addWallet(Wallet wallet);
    void removeWallet(Wallet wallet);
    List<Wallet> viewAllWallets();
    void updateWallet(Wallet wallet);
}