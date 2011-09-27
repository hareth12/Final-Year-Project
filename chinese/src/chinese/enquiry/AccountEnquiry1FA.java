package chinese.enquiry;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chinese.data.AccountClass;
import chinese.service.RBKClientService;
import chinese.service.SSOClientService;

public class AccountEnquiry1FA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountEnquiry1FA() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean validCookieBool = false;
		Cookie[] cookies = request.getCookies();
		String userHash = getClientHash(cookies);
		SSOClientService ssocs = new SSOClientService();
		RBKClientService rbkcs = new RBKClientService();

		
	
		if(userHash!=null){
			if(ssocs.checkTrust1FA(userHash)||ssocs.checkTrust2FA(userHash)){
				validCookieBool=true;	
			}	
		}
		else{
			System.out.println("<fyp2><AccountEnquiry>userHash from Client is null!");
		}
		
		
		if(validCookieBool){
			String userName=ssocs.getLoginName(userHash);
			System.out.println("<fyp2><AccountEnquiry>userName= "+userName);
			
			
			//end of testing sector
			List<AccountClass> accountList = rbkcs.getAccount(userName);
			String[][] records = getStringArray(accountList);
			request.setAttribute("records", records);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/enquiry/enquiry1FA.jsp");
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
			object[i][2] = Double.toString(  roundTwoDecimals( accountList.get(i).getCurrentBalance()));
			object[i][3] = Double.toString( roundTwoDecimals( accountList.get(i).getAvailableBalance()));
			i++;
		}
		return object;
	}
	
	private double roundTwoDecimals(double d) {
    	DecimalFormat twoDForm = new DecimalFormat("#.##");
    	return Double.valueOf(twoDForm.format(d));
	}
	

}
