package com.wallet.daoImpl;

import java.util.List;

import com.wallet.dao.BillPaymentDAO;
import com.wallet.entity.BillPayment;
import com.wallet.entity.BillType;
import com.wallet.entity.Wallet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class BillPaymentDAOImpl implements BillPaymentDAO {

    private EntityManager entityManager;

    public BillPaymentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addBillPayment(BillPayment billPayment) {
        entityManager.persist(billPayment);
    }

    @Override
    public void updateBillPayment(BillPayment billPayment) {
        entityManager.merge(billPayment);
    }

    @Override
    public void deleteBillPayment(int billid) {
        BillPayment billPayment = entityManager.find(BillPayment.class, billid);
        if (billPayment != null) {
            entityManager.remove(billPayment);
        }
    }

    @Override
    public BillPayment getBillPaymentById(int billid) {
        return entityManager.find(BillPayment.class, billid);
    }

    @Override
    public List<BillPayment> getAllBillPayments() {
        TypedQuery<BillPayment> query = entityManager.createQuery("SELECT bp FROM BillPayment bp", BillPayment.class);
        return query.getResultList();
    }

    @Override
    public List<BillPayment> getBillPaymentsByWallet(Wallet wallet) {
        TypedQuery<BillPayment> query = entityManager.createQuery("SELECT bp FROM BillPayment bp WHERE bp.wallet = :wallet", BillPayment.class);
        query.setParameter("wallet", wallet);
        return query.getResultList();
    }

    @Override
    public List<BillPayment> getBillPaymentsByType(BillType billType) {
        TypedQuery<BillPayment> query = entityManager.createQuery("SELECT bp FROM BillPayment bp WHERE bp.billType = :billType", BillPayment.class);
        query.setParameter("billType", billType);
        return query.getResultList();
    }
}
