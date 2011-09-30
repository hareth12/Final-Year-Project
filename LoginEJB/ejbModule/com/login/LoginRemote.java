package com.login;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LoginRemote {

	boolean login(String idPib, String password) throws Exception;
	SSOData login2FA1(String idPib, String password) throws Exception;
	boolean login2FA2(String idPib, String hash2FA)throws Exception;
	String getTelephone(String idPib)throws Exception;
	SSOData send2FACode(String idPib)throws Exception;
	boolean createPIBaccount(String idPib, String telephone);
	boolean activateAccount(String idPib);
	List<String> getListOfUnactivatedPIBId();
	boolean changePassword(String idPib ,String oldPassword, String newPassword1,
			String newPassword2);
}
