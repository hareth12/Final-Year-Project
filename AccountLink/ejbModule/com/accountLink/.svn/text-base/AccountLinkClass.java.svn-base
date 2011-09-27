package com.accountLink;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountLinkClass {
	private String hash2FA;
	private String pre2FAHash;
	private long timeStarted;
	private long timeToEnd;
	private double amountPending;
	private String telephone;
	private String fromType;
	private String toType;
	
	private boolean validLink;
	private String idPib;
	private long payeeAccount;
	private long payerAccount;
	@Id
	private String indexHash;
	
	public AccountLinkClass(){}
	
	
	public AccountLinkClass(String idPib, long payeeAccount, long payerAccount, String indexHash,String telephone){
		this.idPib=idPib;
		this.payeeAccount=payeeAccount;
		this.payerAccount=payerAccount;
		this.indexHash=indexHash;
		this.telephone=telephone;
		this.setHash2FA("21");
		this.setPre2FAHash("21");
		long timeToEnd = System.currentTimeMillis()+180000;
		long timeStarted = System.currentTimeMillis();	
		this.setTimeStarted(timeStarted);
		this.setTimeToEnd(timeToEnd);
		this.setAmountPending(0);
		this.setValidLink(false);
	}

	public void updateTime(){
		long timeToEnd = System.currentTimeMillis()+180000;
		long timeStarted = System.currentTimeMillis();
		this.setTimeStarted(timeStarted);
		this.setTimeToEnd(timeToEnd);
	}
	
	public boolean checkTime(){
		System.out.println("<login><checkTime>time to end: "+this.timeToEnd);
		System.out.println("<login><checkTime>System     : "+System.currentTimeMillis());
		if(this.timeToEnd>System.currentTimeMillis())
			return true;
		else
			return false;
	}
	
	
	public void setIdPib(String idPib) {
		this.idPib = idPib;
	}

	public String getIdPib() {
		return idPib;
	}

	public void setPayeeAccount(long payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	public long getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayerAccount(long payerAccount) {
		this.payerAccount = payerAccount;
	}

	public long getPayerAccount() {
		return payerAccount;
	}

	public void setIndexHash(String indexHash) {
		this.indexHash = indexHash;
	}

	public String getIndexHash() {
		return indexHash;
	}


	public void setHash2FA(String hash2FA) {
		this.hash2FA = hash2FA;
	}


	public String getHash2FA() {
		return hash2FA;
	}


	public void setPre2FAHash(String pre2FAHash) {
		this.pre2FAHash = pre2FAHash;
	}


	public String getPre2FAHash() {
		return pre2FAHash;
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


	public void setAmountPending(double amountPending) {
		this.amountPending = amountPending;
	}


	public double getAmountPending() {
		return amountPending;
	}


	public void setValidLink(boolean validLink) {
		this.validLink = validLink;
	}


	public boolean isValidLink() {
		return validLink;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setFromType(String fromType) {
		this.fromType = fromType;
	}


	public String getFromType() {
		return fromType;
	}


	public void setToType(String toType) {
		this.toType = toType;
	}


	public String getToType() {
		return toType;
	}
}
