package uob.login;

import java.io.IOException;
import java.util.Hashtable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uob.data.SSOData;
import uob.service.HistClientService;
import uob.service.SSOClientService;

/**
 * Servlet implementation class AccountEnquiry
 */
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/Login/select.jsp");
		//if (dispatcher != null) dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("passWord");
				
		SSOClientService ssocs = new SSOClientService();
		HistClientService hcs = new HistClientService();
		
		System.out.println("userName: "+userName);
		System.out.println("password:|"+password+"|");
		
		SSOData ssoData=ssocs.login1FA(userName, password);
		System.out.println("<fypWebService><LoginAction><doPost> getLoginSucess "+ssoData.getLoginSuccess());
		
		if(ssoData.getLoginSuccess()){
			hcs.login1FASuccess(userName);
			Cookie cookie1 = new Cookie("fypUserHash",ssoData.getCookieHash());
			cookie1.setMaxAge(60*5);
			System.out.println("<fypWebService><LoginAction>cookieHash= "+ssoData.getCookieHash());
			response.addCookie(cookie1);
			request.setAttribute("userName", userName);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Login/select.jsp");
			if (dispatcher != null) dispatcher.forward(request, response);
		}else{
			hcs.login1FANotSuccess(userName);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Login/loginFail.jsp");
			if (dispatcher != null) dispatcher.forward(request, response);
		}
			
	}

}
