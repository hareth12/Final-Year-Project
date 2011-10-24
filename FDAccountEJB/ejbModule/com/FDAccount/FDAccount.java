package com.FDAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateful;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class Account
 */
@Stateful(mappedName="FDAccount")
public class FDAccount implements FDAccountRemote {

	
	@PersistenceContext(unitName="FDAccount-unit")
	private EntityManager em;

	
	private long randomAccountNumberGenerator(){
		
		String AB = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(10);
		for( int i = 0; i < 10; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );		
		String resultString=sb.toString();	
		long resultInt=Long.parseLong(resultString);	
		
		return resultInt;
	}

	@Override
	public List<FDAccountClass> getAccountList(String idPib) {
		System.out.println("<FDAccount><getAccount>idPib = "+idPib);
				
		Query q = em.createQuery("SELECT m from FDAccountClass m where m.idPib = ?1 ");
		q.setParameter(1, idPib);
		List<FDAccountClass> resultList=q.getResultList();
		
		
		//checking purpose
		System.out.println("<FDAccount><getAccount>size = "+ resultList.size());
		int index = resultList.size();
		int i =0;
		while(i!=index){
			
			/*
			AccountClassClean x = new AccountClassClean();
			x.setAccountNumber(resultList.get(i).getAccountNumber());
			x.setAccountType(resultList.get(i).getAccountType());
			x.setAvailableBalance(resultList.get(i).getAvailableBalance());
			x.setCurrentBalance(resultList.get(i).getCurrentBalance());
			x.setIdPib(idPib);
			accountList.add(x);
			*/
			
			System.out.println("<Account><getAccount>AccountNumber   = "+ resultList.get(i).getAccountNumber());
			System.out.println("<Account><getAccount>Account Type    = "+ resultList.get(i).getAccountType());
			System.out.println("<Account><getAccount>Current Balance = "+ resultList.get(i).getCurrentBalance());
			System.out.println("<Account><getAccount>Avail Balance   = "+ resultList.get(i).getAvailableBalance());
			i++;
		}
	
		return resultList;
	}

	@Override
	public double deposit(long accountNumber, Double amount) {
		FDAccountClass x = em.find(FDAccountClass.class, accountNumber);
		if(x!=null){
			double newAvailable = x.getAvailableBalance()+amount;
			double newCurrent = x.getCurrentBalance()+amount;
			x.setAvailableBalance(newAvailable);
			x.setCurrentBalance(newCurrent);
			return amount;
		}
		return -1;
	}

	@Override
	public double withdraw(long accountNumber, Double amount) {
		FDAccountClass x = em.find(FDAccountClass.class, accountNumber);
		if(x!=null){
			if(x.getAvailableBalance()>=amount)
				if(x.getCurrentBalance()>=amount){
					double newAvailable = x.getAvailableBalance()-amount;
					double newCurrent = x.getCurrentBalance()-amount;
					x.setAvailableBalance(newAvailable);
					x.setCurrentBalance(newCurrent);
					return amount;
					
				}
		}
		return -1;
	}

	@Override
	public boolean makeFDPlacement(long accountNumber, Double amount, int days) {
		FDAccountClass x = em.find(FDAccountClass.class, accountNumber);
		if(x!=null){
			if(x.getAvailableBalance()>=amount)
				if(x.getCurrentBalance()>=amount){
					double newAvailable = x.getAvailableBalance()-amount;
					
					x.setAvailableBalance(newAvailable);
				
					return true;
					
				}
		}
		return false;
	}

}
