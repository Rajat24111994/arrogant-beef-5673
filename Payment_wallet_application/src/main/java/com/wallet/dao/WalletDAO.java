package com.wallet.dao;

import java.util.List;

import com.wallet.entity.Wallet;

public interface WalletDAO {
    public void addWallet(Wallet wallet);
    public void updateWallet(Wallet wallet);
    public void deleteWallet(int walletid);
    public Wallet getWalletById(int walletid);
    public List<Wallet> getAllWallets();
}

