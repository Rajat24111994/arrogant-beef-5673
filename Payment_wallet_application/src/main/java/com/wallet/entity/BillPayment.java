package com.wallet.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BillPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
    private int billid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkBilltype_id")
    private BillType billtype;
    private double amount;
    private LocalDate paymentDate;
    // getters and setters, constructors, toString
	public BillPayment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillPayment(Wallet wallet, int billid, BillType billtype, double amount, LocalDate paymentDate) {
		super();
		this.wallet = wallet;
		this.billid = billid;
		this.billtype = billtype;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public int getBillid() {
		return billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}
	public BillType getBilltype() {
		return billtype;
	}
	public void setBilltype(BillType billtype) {
		this.billtype = billtype;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "BillPayment [id=" + id + ", wallet=" + wallet + ", billid=" + billid + ", amount=" + amount
				+ ", paymentDate=" + paymentDate + "]";
	}
    
    
}

