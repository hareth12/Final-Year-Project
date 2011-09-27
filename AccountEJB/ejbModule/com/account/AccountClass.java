package com.account;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class AccountClass implements Serializable{
	@Id
	private long accountNumber;
	private double currentBalance;
	private double availableBalance;
	private String accountType;
	private String idPib;
	
	public AccountClass(int accountNumber){
		this.accountNumber=accountNumber;
		this.setCurrentBalance(0);
		this.setAvailableBalance(0);
		this.setAccountType("UniPlus");
	}


	public AccountClass() {
		// TODO Auto-generated constructor stub
	}


	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public long getAccountNumber() {
		return accountNumber;
	}


	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}


	public double getCurrentBalance() {
		return currentBalance;
	}


	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}


	public double getAvailableBalance() {
		return availableBalance;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setIdPib(String idPib) {
		this.idPib = idPib;
	}


	public String getIdPib() {
		return idPib;
	}
	
	
	
	}
