package com.wallet.dao;

import java.util.List;

import com.wallet.entity.BeneficiaryDetails;

public interface BenificeryDAO {

    void addBenificery(BeneficiaryDetails benificery);
    
    void removeBenificery(BeneficiaryDetails benificery);

    BeneficiaryDetails viewBenificery(String name);

    List<BeneficiaryDetails> viewAllBenificeries();

    void updateBenificery(BeneficiaryDetails benificery);
}

