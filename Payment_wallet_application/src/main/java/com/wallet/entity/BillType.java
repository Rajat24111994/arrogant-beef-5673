package com.wallet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BillType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int BillTypeId;
	
	private String BillType;

	public BillType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillType( String billType) {
		super();
		
		BillType = billType;
	}

	public String getBillType() {
		return BillType;
	}

	public int getBillTypeId() {
		return BillTypeId;
	}

	public void setBillTypeId(int billTypeId) {
		BillTypeId = billTypeId;
	}

	public void setBillType(String billType) {
		BillType = billType;
	}

	@Override
	public String toString() {
		return "BillType [BillTypeId=" + BillTypeId + ", BillType=" + BillType + "]";
	}
	
	
	
}
