package com.wallet.daoImpl;
import java.util.List;

import com.wallet.dao.BenificeryDAO;
import com.wallet.entity.BeneficiaryDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class BenificeryDAOImpl implements BenificeryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBenificery(BeneficiaryDetails benificery) {
        entityManager.persist(benificery);
    }

    @Override
    public void removeBenificery(BeneficiaryDetails benificery) {
        entityManager.remove(entityManager.merge(benificery));
    }

    @Override
    public BeneficiaryDetails viewBenificery(String name) {
        TypedQuery<BeneficiaryDetails> query = entityManager.createQuery("FROM BeneficiaryDetails WHERE name = :name", BeneficiaryDetails.class);
        query.setParameter("name", name);
        List<BeneficiaryDetails> beneficiaries = query.getResultList();
        if (beneficiaries.isEmpty()) {
            return null;
        }
        return beneficiaries.get(0);
    }

    @Override
    public List<BeneficiaryDetails> viewAllBenificeries() {
        TypedQuery<BeneficiaryDetails> query = entityManager.createQuery("FROM BeneficiaryDetails", BeneficiaryDetails.class);
        return query.getResultList();
    }

    @Override
    public void updateBenificery(BeneficiaryDetails benificery) {
        entityManager.merge(benificery);
    }
}
