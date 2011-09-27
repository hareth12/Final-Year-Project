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
import uob.data.AddPayee2FAData;
import uob.service.RBKClientService;
import uob.service.SSOClientService;

/**
 * Servlet implementation class AccountEnquiry
 */
public class AddPayee2FA1Action2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPayee2FA1Action2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Boolean validCookieBool = false;
		Cookie[] cookies = request.getCookies();
		String userHash = getClientHash(cookies);
		SSOClientService ssocs = new SSOClientService();
		RBKClientService rbkcs = new RBKClientService();
		
		if(userHash!=null){
			if(ssocs.checkTrust2FA(userHash)){
				validCookieBool=true;
				System.out.println("<fyp2><userHash>userHash = "+userHash);	
			}	
		}
		else{
			System.out.println("<fyp2><AddPayee2FA1Action2>userHash from Client is null!");
		}
		
		
		if(validCookieBool){
			String userName=ssocs.getLoginName(userHash);
			String fromAccountString = request.getParameter("fromAccount");
			long fromAccount = Long.parseLong(fromAccountString);
			String toAccountString = request.getParameter("toAccount");
			long toAccount = Long.parseLong(toAccountString);
			
			String telephone = ssocs.getTelephone(userName);
			
			AddPayee2FAData x = rbkcs.addPayee2FA1(userName, fromAccount, toAccount, telephone, "Uniplus", "Uniplus");
			
			
			request.setAttribute("indexHash", x.getIndexHash());
			request.setAttribute("preHash", x.getPreHash());
			request.setAttribute("toAccount", toAccountString);	
			request.setAttribute("fromAccount", fromAccountString);	
			
			
			System.out.println("<fyp2><AddPayee2FA1Action2> preHash    = "+ x.getPreHash());
			System.out.println("<fyp2><AddPayee2FA1Action2> indexHash    = "+ x.getIndexHash());
			System.out.println("<fyp2><AddPayee2FA1Action2> fromAccount = "+fromAccountString);
			System.out.println("<fyp2><AddPayee2FA1Action2> toAccount = "+toAccountString);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/fundTransfer/addPayee3.jsp");
			if (dispatcher != null) dispatcher.forward(request, response);
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login/timedOut.jsp");
			if (dispatcher != null) dispatcher.forward(request, response);
		}
		
		
		
		
		
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
	
	private String[][] getStringArrayForPayee(List<AccountLinkDataStructure> x){
		int row = x.size() + 1;	
		String [][] t = new String[row][2];
		
		int i = 0;
		while(i!=(row-1)){
			t[i][0] = Long.toString(x.get(i).getPayeeAccount());
			t[i][1] = x.get(i).getAccountLinkHash();
			i++;
		}
		return t;
		
	}
	
	private String[][] getStringArray(List<AccountClass> accountList){
		int row = accountList.size() + 1;	
		String [][] object = new String[row][4];
		object[0][0] = "Account Name";
		object[0][1] = "Account Number";
		object[0][2] = "Current Balance";
		object[0][3] = "Available Balance";
		
		int i = 0;
		while(i!=(row-1)){
			object[i][0] = accountList.get(i).getAccountType();
			object[i][1] = Long.toString(accountList.get(i).getAccountNumber());
			object[i][2] = Double.toString(accountList.get(i).getCurrentBalance());
			object[i][3] = Double.toString(accountList.get(i).getAvailableBalance());
			i++;
		}
		return object;
	}
}
