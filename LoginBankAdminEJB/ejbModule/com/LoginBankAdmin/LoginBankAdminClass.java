package com.LoginBankAdmin;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginBankAdminClass {
	@Id
	private String idBankAdmin;
	private String password;

	public LoginBankAdminClass(){}

	public void setIdBankAdmin(String idBankAdmin) {
		this.idBankAdmin = idBankAdmin;
	}

	public String getIdBankAdmin() {
		return idBankAdmin;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	
}
