package uob.data;

import java.io.Serializable;

public class FDAccountClass implements Serializable{

	private long accountNumber;
	private double currentBalance;
	private double availableBalance;
	private String accountType;
	private String idPib;
	

	public FDAccountClass() {
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

