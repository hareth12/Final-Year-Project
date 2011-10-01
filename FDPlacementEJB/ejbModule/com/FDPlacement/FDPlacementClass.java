package com.FDPlacement;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FDPlacementClass implements Serializable{
	private long accountNumber;
	private double amount;
	private double interestRate;
	private long timeStarted;
	private long timeToEnd;
	private String idPib;
	@Id
	private String txnNumber;
	

	public FDPlacementClass() {
	}


	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public long getAccountNumber() {
		return accountNumber;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public double getAmount() {
		return amount;
	}


	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


	public double getInterestRate() {
		return interestRate;
	}


	public void setTimeStarted(long timeStarted) {
		this.timeStarted = timeStarted;
	}


	public long getTimeStarted() {
		return timeStarted;
	}


	public void setTimeToEnd(long timeToEnd) {
		this.timeToEnd = timeToEnd;
	}


	public long getTimeToEnd() {
		return timeToEnd;
	}


	public void setIdPib(String idPib) {
		this.idPib = idPib;
	}


	public String getIdPib() {
		return idPib;
	}


	public void setTxnNumber(String txnNumber) {
		this.txnNumber = txnNumber;
	}


	public String getTxnNumber() {
		return txnNumber;
	}


	
	
	}
