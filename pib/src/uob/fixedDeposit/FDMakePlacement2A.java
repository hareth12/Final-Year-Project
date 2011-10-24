package uob.fixedDeposit;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uob.data.AccountClass;
import uob.data.FDAccountClass;
import uob.data.FDPlacementClass;
import uob.service.FDClientService;
import uob.service.RBKClientService;
import uob.service.SSOClientService;

public class FDMakePlacement2A extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FDMakePlacement2A() {
        super();
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
		FDClientService fdcs = new FDClientService();

		
	
		if(userHash!=null){
			if(ssocs.checkTrust2FA(userHash)){
				validCookieBool=true;	
			}	
		}
		else{
			System.out.println("<fyp2><AccountEnquiry2FA>userHash from Client is null!");
		}
		
		
		if(validCookieBool){
			String userName=ssocs.getLoginName(userHash);
			
			
			//end of testing sector
			List<FDAccountClass> accountList = fdcs.getListOfFDAccount(userName);
			String[][] records1 = getStringArray(accountList);
			request.setAttribute("records1", records1);
			List<FDPlacementClass> placementList= null;
			String FDAccountString = request.getParameter("FDAccount");
			String amountString = request.getParameter("amount");
			String daysString = request.getParameter("days");
			long FDAccount = Long.parseLong(FDAccountString);
			double amount = Double.parseDouble(amountString);
			int days = Integer.parseInt(daysString);
			String displayString=null;
			boolean placementSuccess = fdcs.makeFDPlacement(FDAccount, amount, days, userName);
			if(placementSuccess){
				displayString="Fixed Depostit Placement has been made. ";
			}
			else{
				displayString="Fixed Depostit Placement has not been made. ";
			}
			request.setAttribute("displayString", displayString);
			if(accountList!=null){
				placementList= fdcs.getListFDPlacement(accountList.get(0).getAccountNumber()); 
				int i=1;
				int j=accountList.size();
				while(i<j){
					List<FDPlacementClass> x = fdcs.getListFDPlacement(accountList.get(i).getAccountNumber());
					int k=0;
					int p=0;
					if(x!=null)	
						p=x.size();
					while(k<p){
						//System.out.println("k = "+k+" p = "+p);
						placementList.add(x.get(k));
						k++;
					}					
					i++;
				}
			}
			String[][] records2 = getStringArrayPlacement(placementList);
			request.setAttribute("records2", records2);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FixedDeposit/Placement2.jsp");
	
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
	
	private String[][] getStringArray(List<FDAccountClass> accountList){
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
	private double roundFiveDecimals(double d) {
    	DecimalFormat twoDForm = new DecimalFormat("#.#####");
    	return Double.valueOf(twoDForm.format(d));
	}

	private String[][] getStringArrayPlacement(List<FDPlacementClass> placementList){
		if(placementList!=null){	
			int row = placementList.size() + 1;	
			String [][] object = new String[row][6];
			object[0][0] = "Account Number";
			object[0][1] = "Amount";
			object[0][2] = "Interest";
			object[0][3] = "Time Started";
			object[0][4] = "Mature Date";
			object[0][5] = "Transaction Number";
			
			int i = 0;
			while(i!=(row-1)){
				object[i][0] = Long.toString(placementList.get(i).getAccountNumber());
				object[i][1] = Double.toString(placementList.get(i).getAmount());
				object[i][2] = Double.toString(roundFiveDecimals(placementList.get(i).getInterestRate()));
				object[i][3] = changeDate(placementList.get(i).getTimeStarted());
				object[i][4] = changeDate(placementList.get(i).getTimeToEnd());
				object[i][5] = placementList.get(i).getTxnNumber();
				i++;
			}
			return object;
		}
		return null;
	}
	
	private String changeDate(long now){
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(now);
		//System.out.println(formatter.format(calendar.getTime()));
		String x = formatter.format(calendar.getTime());
		String[] y = x.split(" ");
		x=y[0]+"+"+y[1];
		return x;
	}
}
