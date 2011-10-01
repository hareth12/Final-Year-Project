package com.account;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface AccountRemote {
	public long createNewAccount(String idPib, String accountType, double initialBalance);
		
	public List<AccountClass> getAccount(String idPib) throws Exception;

	public boolean fundTransfer(long from, long to, double amount) throws Exception;

	public double deposit(long accountNumber, Double amount);

	public double withdraw(long accountNumber, Double amount);
}

