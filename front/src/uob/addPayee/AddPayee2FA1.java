package uob.addPayee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import uob.data.AccountClass;
import uob.data.AccountLinkDataStructure;
import uob.service.RBKClientService;
import uob.service.SSOClientService;

public class AddPayee2FA1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPayee2FA1() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddPayee-get");
		Boolean validCookieBool = false;
		Cookie[] cookies = request.getCookies();
		String userHash = getClientHash(cookies);
		SSOClientService ssocs = new SSOClientService();
		RBKClientService rbkcs = new RBKClientService();
		
		//need to change to 2FA later
		if(userHash!=null){
			if(ssocs.checkTrust2FA(userHash)){
				validCookieBool=true;
				System.out.println("<fypWebService><AddPayee2FA1>userHash = "+userHash);
				
			}	
		}
		else{
			System.out.println("<fypWebService><AddPayee2FA1>userHash from Client is null!");
		}
		
		
		if(validCookieBool){
			String userName=ssocs.getLoginName(userHash);
			System.out.println("<fypWebService><AddPayee2FA1>userName= "+userName);

			
			List<AccountLinkDataStructure> payeeList = rbkcs.getPayeeList(userName);
			String [][] payee = getStringArray(payeeList);
			request.setAttribute("payee", payee);
			
			List<AccountClass> accountList = rbkcs.getAccount(userName);
			String[][] accounts = getStringArrayAccount(accountList);
			request.setAttribute("accounts", accounts);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/fundTransfer/addPayee1.jsp");
			if (dispatcher != null) dispatcher.forward(request, response);
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login/timedOut.jsp");
			if (dispatcher != null) dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Addpayee2fa1-post");
		
	}
	
	private String getClientHash(Cookie[] cookies){
		 for(int i=0; i<cookies.length; i++) {
		      Cookie cookie = cookies[i];
		      System.out.println("cookieName = "+ cookie.getName());
		     
		      if (cookie.getName().equals("fypUserHash")){
		    	  System.out.println("returning = "+cookie.getValue());
		    	  return(cookie.getValue());
		      }
		       
		    }
		return null;
		
	}
	
	private String[][] getStringArray(List<AccountLinkDataStructure> payeeList){
		String [][] object = null;
		if(payeeList!=null){	
			int row = payeeList.size() + 1;	
			object = new String[row][2];
			object[0][0] = "Account Number";
			object[0][1] = "IndexHash";
	
			
			int i = 0;
			while(i!=(row-1)){
				object[i][0] = Long.toString(payeeList.get(i).getPayeeAccount());
				object[i][1] = payeeList.get(i).getAccountLinkHash();
				i++;
			}
			return object;
		}
		return object;
	}
	
	private String[][] getStringArrayAccount(List<AccountClass> accountList){
		int row = accountList.size() + 1;	
		String [][] object = new String[row][4];
		
		int i = 0;
		while(i!=(row-1)){
			object[i][0] = accountList.get(i).getAccountType();
			object[i][1] = Long.toString(accountList.get(i).getAccountNumber());
			i++;
		}
		return object;
	}

}
