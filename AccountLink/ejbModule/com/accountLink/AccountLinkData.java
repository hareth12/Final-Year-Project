package com.accountLink;



//change to elsewhere later.

public class AccountLinkData {
	private boolean payeeSearchSuccess;
	private boolean payeeAddSuccess;
	private String indexHash;
	
	public AccountLinkData(){
		this.setPayeeAddSuccess(false);
		this.setPayeeSearchSuccess(false);
		this.setIndexHash(null);
	}

	public void setPayeeSearchSuccess(boolean payeeSearchSuccess) {
		this.payeeSearchSuccess = payeeSearchSuccess;
	}

	public boolean isPayeeSearchSuccess() {
		return payeeSearchSuccess;
	}

	public void setPayeeAddSuccess(boolean payeeAddSuccess) {
		this.payeeAddSuccess = payeeAddSuccess;
	}

	public boolean isPayeeAddSuccess() {
		return payeeAddSuccess;
	}

	public void setIndexHash(String indexHash) {
		this.indexHash = indexHash;
	}

	public String getIndexHash() {
		return indexHash;
	}
}
