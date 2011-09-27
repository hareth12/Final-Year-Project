package com.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateful;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Session Bean implementation class Account
 */
@Stateful(mappedName="Account")
public class Account implements AccountRemote {

	
	@PersistenceContext(unitName="account-unit")
	private EntityManager em;
	
	public int createNewAccount(double initialBalance){
		int accountNumber=randomAccountNumberGenerator();
		AccountClass x= em.find(AccountClass.class, accountNumber);
		
		while(x!=null){
			accountNumber=randomAccountNumberGenerator();
			x= em.find(AccountClass.class, accountNumber);
		}//a unique random 10 digit integer is found account number
		
		x = new AccountClass(accountNumber);
		x.setAvailableBalance(initialBalance);
		x.setCurrentBalance(initialBalance);
		
		em.merge(x);
		
		return accountNumber;
	}
	
	private int randomAccountNumberGenerator(){
		
		String AB = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(10);
		for( int i = 0; i < 10; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );		
		String resultString=sb.toString();	
		int resultInt=Integer.parseInt(resultString);	
		
		return resultInt;
	}
	
	public	AccountClass getAccount(int accountNumber){
		AccountClass x=em.find(AccountClass.class, accountNumber);
		return x;
	}

	@Override
	public List<AccountClass> getAccount(String idPib) {
		System.out.println("<Account><getAccount>idPib = "+idPib);
		//List<AccountClassClean> accountList = new ArrayList<AccountClassClean>(); 
		
		Query q = em.createQuery("SELECT m from AccountClass m where m.idPib = ?1 ");
		q.setParameter(1, idPib);
		List<AccountClass> resultList=q.getResultList();
		
		
		//checking purpose
		System.out.println("<Account><getAccount>size = "+ resultList.size());
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
	public boolean fundTransfer(long from, long to, double amount)
			throws Exception {
		System.out.println("<Account><fundTransfer>inside Method with from = "+from);
		System.out.println("<Account><fundTransfer>inside Method with to = "+to);
		System.out.println("<Account><fundTransfer>inside Method with amount = "+amount);
		
		boolean fundTransferSuccess = false;
		AccountClass fromAccount = em.find(AccountClass.class, from);
		AccountClass toAccount   = em.find(AccountClass.class, to);
		
		if(fromAccount!=null && toAccount!=null){
			if(fromAccount.getCurrentBalance()>amount){
				if(fromAccount.getAvailableBalance()>amount){
					//active zone
					double newFromAvailable = fromAccount.getAvailableBalance()-amount;
					double newFromCurrent   = fromAccount.getCurrentBalance()-amount;
					
					double newToAvailable = toAccount.getAvailableBalance()+amount;
					double newToCurrent   = toAccount.getCurrentBalance()+amount;
					
					fromAccount.setAvailableBalance(newFromAvailable);
					fromAccount.setCurrentBalance(newFromCurrent);
					toAccount.setAvailableBalance(newToAvailable);
					toAccount.setCurrentBalance(newToCurrent);
					
					em.persist(fromAccount);
					em.persist(toAccount);
					fundTransferSuccess=true;
				}
				else
					System.out.println("<Account><fundTransfer>fromAccount available Balance is insufficent");	
			}
			else
				System.out.println("<Account><fundTransfer>fromAccount current Balance is insufficent");	
		}
		else
			System.out.println("<Account><fundTransfer>fromAccount/toAccount is null");
		
		
		return fundTransferSuccess;
	}
	
	


}
