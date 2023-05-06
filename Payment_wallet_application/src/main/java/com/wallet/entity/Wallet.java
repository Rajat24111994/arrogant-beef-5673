package com.wallet.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;
    // getters and setters, constructors, toString
	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wallet(BigDecimal balance) {
		super();
		this.balance = balance;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Wallet [id=" + id + ", balance=" + balance + "]";
	}
	
	
    
}

