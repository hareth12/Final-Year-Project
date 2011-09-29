package com.CustomerEJB;

import javax.ejb.Remote;

@Remote
public interface CustomerRemote {

	boolean createNewCustomer(String idPib, String name, String address,
			String mobile, String hometelephone, String telephone2fa,
			String icnumber);
	
}

