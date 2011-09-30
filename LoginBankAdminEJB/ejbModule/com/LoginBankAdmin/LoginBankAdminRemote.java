package com.LoginBankAdmin;
import javax.ejb.Remote;

@Remote
public interface LoginBankAdminRemote {

	int login(String idBankAdmin, String password);

}
