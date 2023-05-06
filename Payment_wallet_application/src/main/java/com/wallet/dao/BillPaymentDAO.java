package com.wallet.dao;

import java.util.List;

import com.wallet.entity.BillPayment;
import com.wallet.entity.BillType;
import com.wallet.entity.Wallet;

public interface BillPaymentDAO {
    public void addBillPayment(BillPayment billPayment);
    public void updateBillPayment(BillPayment billPayment);
    public void deleteBillPayment(int billid);
    public BillPayment getBillPaymentById(int billid);
    public List<BillPayment> getAllBillPayments();
    public List<BillPayment> getBillPaymentsByWallet(Wallet wallet);
    public List<BillPayment> getBillPaymentsByType(BillType billType);
}

