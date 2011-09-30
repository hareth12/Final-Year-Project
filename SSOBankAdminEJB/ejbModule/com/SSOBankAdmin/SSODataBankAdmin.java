package com.SSOBankAdmin;

public class SSODataBankAdmin {
	private Boolean loginSuccess;
	private String cookieHash;
	private int level;
	
	public SSODataBankAdmin(){};
	
	public void setLoginSuccess(Boolean loginSuccess) {
		this.loginSuccess = loginSuccess;
	}
	public Boolean getLoginSuccess() {
		return loginSuccess;
	}
	public void setCookieHash(String cookieHash) {
		this.cookieHash = cookieHash;
	}
	public String getCookieHash() {
		return cookieHash;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
}
