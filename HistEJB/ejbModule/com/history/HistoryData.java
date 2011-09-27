package com.history;

import java.io.Serializable;

public class HistoryData implements Serializable{
	private String idPib;
	private long time;
	private String TxnName;
	private double amount;
	private String status; 
	private long txnNumber;
	
	public HistoryData(){}

	public void setIdPib(String idPib) {
		this.idPib = idPib;
	}

	public String getIdPib() {
		return idPib;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getTime() {
		return time;
	}

	public void setTxnName(String txnName) {
		TxnName = txnName;
	}

	public String getTxnName() {
		return TxnName;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setTxnNumber(long txnNumber) {
		this.txnNumber = txnNumber;
	}

	public long getTxnNumber() {
		return txnNumber;
	};
}
