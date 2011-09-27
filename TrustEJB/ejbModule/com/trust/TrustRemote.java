package com.trust;

import javax.ejb.Remote;

@Remote
public interface TrustRemote {

//	boolean check(String hash) throws Exception; //  replacing this method with check1FA(String hash)
	boolean check1FA(String hash)throws Exception;
	boolean check2FA(String hash)throws Exception;
//	String newLogin(String loginName) throws Exception; //  replacing this method with newLogin1FA(String loginName)
	String newLogin1FA(String loginName) throws Exception;
	void newLogin2FA(String cookieHash, String loginName) throws Exception;
	String getIdPib(String hash) throws Exception;
	void removeTrust(String userHash)throws Exception;
}
