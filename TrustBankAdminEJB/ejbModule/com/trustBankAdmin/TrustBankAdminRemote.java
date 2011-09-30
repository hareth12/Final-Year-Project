package com.trustBankAdmin;
import javax.ejb.Remote;

@Remote
public interface TrustBankAdminRemote {

	int check(String hash);
	String newLogin(String loginName, int b);
	String getIdBankAdmin(String hash);
	void removeTrust(String userHash);
}
