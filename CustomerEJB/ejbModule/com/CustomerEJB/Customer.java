package com.CustomerEJB;

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
@Stateful(mappedName="Customer")
public class Customer implements CustomerRemote {

	
	@PersistenceContext(unitName="customer-unit")
	private EntityManager em;

	@Override
	public boolean createNewCustomer(String idPib, String name, String address,
			String mobile, String hometelephone, String telephone2fa,
			String icnumber) {
		CustomerClass x = new CustomerClass();
		x.setAddress(address);
		x.setHomeTelephone(hometelephone);
		x.setICNumber(icnumber);
		x.setIdPib(idPib);
		x.setMobile(mobile);
		x.setName(name);
		x.setTelephone2FA(telephone2fa);
		
		em.persist(x);
		return true;
	}	


}
