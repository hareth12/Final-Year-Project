package com.LoginBankAdmin;
import javax.ejb.Remote;

@Remote
public interface LoginBankAdminRemote {

	boolean login(String idBankAdmin, String password);

}
