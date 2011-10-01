package com.FDAccount;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface FDAccountRemote {
	public List<FDAccountClass> getAccountList(String idPib);

	public double deposit(long accountNumber, Double amount);

	public double withdraw(long accountNumber, Double amount);
}

