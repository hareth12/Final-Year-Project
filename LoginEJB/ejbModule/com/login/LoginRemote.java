package com.login;

import javax.ejb.Remote;

@Remote
public interface LoginRemote {

	boolean login(String idPib, String password) throws Exception;
	SSOData login2FA1(String idPib, String password) throws Exception;
	boolean login2FA2(String idPib, String hash2FA)throws Exception;
	String getTelephone(String idPib)throws Exception;
	SSOData send2FACode(String idPib)throws Exception;
}