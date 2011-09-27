package com.account;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface AccountRemote {
	public int createNewAccount(double initialBalance) throws Exception;
		
	public List<AccountClass> getAccount(String idPib) throws Exception;

	public boolean fundTransfer(long from, long to, double amount) throws Exception;
}

