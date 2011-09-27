package chinese.fundTransfer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chinese.data.AccountClass;
import chinese.data.AccountLinkDataStructure;
import chinese.service.RBKClientService;
import chinese.service.SSOClientService;

/**
 * Servlet implementation class AccountEnquiry
 */
public class FundTransfer2FA1Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundTransfer2FA1Action() {
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
				System.out.println("<fypWebService><userHash>userHash = "+userHash);	
			}	
		}
		else{
			System.out.println("<fypWebService><AccountEnquiry>userHash from Client is null!");
		}
		
		
		if(validCookieBool){
			String userName=ssocs.getLoginName(userHash);
			String fromAccountString = request.getParameter("fromAccount");
			long fromAccount = Long.parseLong(fromAccountString);
			List<AccountLinkDataStructure> alds = rbkcs.getAccountLink(fromAccount);
			
			String [][] payee = getStringArrayForPayee(alds);
			
			request.setAttribute("payee", payee);	
			request.setAttribute("fromAccount", fromAccountString);	
			
			System.out.println("<fypWebService><FundTransfer2FA1Action> userName    = "+userName);
			System.out.println("<fypWebService><FundTransfer2FA1Action> fromAccount = "+fromAccountString);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/fundTransfer/fundTransfer2FA1Action.jsp");
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
		String [][] t =null;
		if(x!=null&&!x.isEmpty()){
			int row = x.size() + 1;	
			t = new String[row][3];
			
			int i = 0;
			while(i!=(row-1)){
				t[i][0] = x.get(i).getPayeeAccountType();
				t[i][1] = Long.toString(x.get(i).getPayeeAccount());
				t[i][2] = x.get(i).getAccountLinkHash();
		
				i++;
			}
			return t;
		}
		t = new String[1][1];
		t[0][0]="null";
		return t;
		
	}
	
	private String[][] getStringArray(List<AccountClass> accountList){
		String [][] object=null;
		if(accountList!=null&&!accountList.isEmpty()){
			int row = accountList.size() + 1;	
			object = new String[row][4];
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
		}
		return object;
	}
}
