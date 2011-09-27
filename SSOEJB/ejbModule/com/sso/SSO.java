package com.sso;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;
import java.util.Properties;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.login.LoginRemote;
import com.trust.TrustRemote;




 
/**
 * Message-Driven Bean implementation class for: RBK
 * 
 */
@MessageDriven(mappedName = "SSOQueue", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class SSO implements MessageListener {
	QueueConnection cnn = null;
    QueueSender sender = null;
    QueueSession session = null;
    InitialContext ctx;
    Hashtable ht = new Hashtable();
	
    
    //==========
	private void replyToServlet(String message){	
        try {
        	ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        	ht.put(Context.PROVIDER_URL,"t3://localhost:7001");

            ctx = new InitialContext(ht);
            Queue queue = (Queue) ctx.lookup("SSOReplyQueue");
            QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("SSOReplyConnectionFactory");
            cnn = factory.createQueueConnection();
            session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            TextMessage msg = session.createTextMessage();

            msg.setText(message);
            sender = session.createSender(queue);
            sender.send(msg);
            
           
            System.out.println("<sso><replyToServlet>");
            session.close(); // this is important.
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	//==========
	
	
	@EJB (mappedName="Login")
	LoginRemote login;
	
	@EJB (mappedName="Trust")
	TrustRemote trust;
	
	
	/**
	 * Default constructor.
	 */
	public SSO() {
		
	}
	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		TextMessage tmsg = null;
		tmsg = (TextMessage) message;
		int opCode = 99;
		String parameter1 = null;
		String parameter2 = null;
		String parameter3 = null;
		
		//parsing message into opcode, and parameters
		String preParse;
		try {
			preParse = tmsg.getText();
			String[] postParse=preParse.split("[|]+");
			opCode=Integer.parseInt(postParse[0]);
			parameter1=postParse[1];
			parameter2=postParse[2];
			parameter3=postParse[3];
			
		} catch (JMSException e1) {
			e1.printStackTrace();
		}
		
		
		switch(opCode){
			case 11: //11 = login 1FA
				
				try {
					if(parameter1!=null &&parameter2!=null ){
						
						//merely changing name only
						String idPib = parameter1;
						String password = parameter2;
						
						System.out.println("parameter 1:"+idPib);
						System.out.println("parameter 2:"+password);
					
						com.login.SSOData ssoData = login(idPib,password);
						if(ssoData.getLoginSuccess()==false){
							replyToServlet("10||");	//login failed					
						}
						else
						{
							replyToServlet("19|"+idPib+"|"+ssoData.getCookieHash()); // login success with cookie
						}
					}	
			else
						replyToServlet(null);
				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println("<sso>failed");
				}
				break;
				
			case 21:	//2FA stage 1
				//TO DO: INCLUDE A PRE HASH
				try {
					if(parameter1!=null &&parameter2!=null ){	
						
						//merely changing name only
						String idPib = parameter1;
						String password = parameter2;
						
						System.out.println("parameter 1:"+idPib);
						System.out.println("parameter 2:"+password);
					
						com.login.SSOData ssoData = login2FA1(idPib,password);
						if(ssoData.getLogin2FA1Success()==false){
							replyToServlet("20||");	//login failed					
						}
						else
						{
							replyToServlet("29|"+idPib+"|"+ssoData.getPre2FAHash()); // first stage success
						}
					}	
			else
						replyToServlet(null);
				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println("<sso>failed");
				}
				
				break;
			
			case 31:	//2FA stage 2
				try {
					if(parameter1!=null &&parameter2!=null ){	
						
						//merely changing name only
						String idPib = parameter1;
						String hash2FA = parameter2;
						String cookieHash = parameter3;
						
						System.out.println("parameter 1:"+idPib);
						System.out.println("parameter 2:"+hash2FA);
						System.out.println("parameter 3:"+cookieHash);
						
						com.login.SSOData ssoData = login2FA2(idPib,hash2FA,cookieHash);
						if(ssoData.getLogin2FA2Success()==false){
							replyToServlet("30||");	//login failed					
						}
						else
						{
							replyToServlet("39|"+idPib+"|"+ssoData.getCookieHash()); // 2FA success
						}
					}	
			else
						replyToServlet(null);
				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println("<sso>failed");
				}
				
				break;
				
			case 41:
				try {
					boolean checkTrustBoolean = trust.check1FA(parameter1);
					
					if(checkTrustBoolean){
						replyToServlet("49||"); // cookie accepted
					}else{
						replyToServlet("40||"); //cookie expired
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 51:
				try {
					boolean checkTrustBoolean = trust.check2FA(parameter1);
					
					if(checkTrustBoolean){
						replyToServlet("59||"); // cookie accepted
					}else{
						replyToServlet("50||"); //cookie expired
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;		
			
			case 61:  //getLoginName
				try {
					String returnLoginName = trust.getIdPib(parameter1);
					
					if(returnLoginName!=null){
						replyToServlet("69|"+returnLoginName);
					}else{
						replyToServlet("60||"); //no login name
					}					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 71:
				try{
					if(parameter1!=null){
						//merely renaming
						String idPib = parameter1;
						getTelephone(idPib);
						
					}
				}catch(Exception e1){
					e1.printStackTrace();
					System.out.println("<sso><getTelephone>failed");
				}
				break;	
				
			case 81:
				try{
					if(parameter1!=null){
						//merely renaming
						String idPib = parameter1;
						send2FACode(idPib);
						
					}
				}catch(Exception e1){
					e1.printStackTrace();
					System.out.println("<sso><send2FACode>failed");
				}
				break;	
			
			case 91:
				try{
					if(parameter1!=null){
						//merely renaming
						String userHash = parameter1;
						logout(userHash);
						replyToServlet("99||");
						
					}
				}catch(Exception e1){
					e1.printStackTrace();
					System.out.println("<sso><send2FACode>failed");
				}
				break;	
			
			case 101:
				System.out.println("<sso><preparse>failed");
				break;
			}
		
	}
	
	private void logout(String userHash) throws Exception { //opCode = 91
		trust.removeTrust(userHash);
		
	}
	private void getTelephone(String idPib) throws Exception { //opCode= 71
		String telephone = login.getTelephone(idPib);
		
		if(telephone!=null){
			replyToServlet("79|"+telephone);
			System.out.println("<sso><getTelephone> telephone = "+telephone);
		}
		else
		{
			System.out.println("<sso><getTelephone> failed");
			replyToServlet("70");
		}
	}
	
	private void send2FACode(String idPib) throws Exception { // opCode =81
		com.login.SSOData x = login.send2FACode(idPib);
		
		if(x!=null){
			replyToServlet("89|"+x.getPre2FAHash());
			System.out.println("<sso><send2FACode> idPib = "+idPib);
		}else
		{
			System.out.println("<sso><send2FACode> failed");
			replyToServlet("80");
		}
		
	}
	
	private com.login.SSOData login(String idPib, String password) throws Exception{
		com.login.SSOData ssoData = new com.login.SSOData();
		
		
		Boolean loginBoolean = login.login(idPib, password);
		
		if(loginBoolean==true){
			String cookieHash = trust.newLogin1FA(idPib);
			System.out.println("<sso><login>cookieHash = "+cookieHash);
			ssoData.setCookieHash(cookieHash);			
		}
		
		return ssoData;
	}
	
	private com.login.SSOData login2FA1(String idPib,String password) throws Exception{
		return login.login2FA1(idPib, password);
	//	return null;
	}
	
	private com.login.SSOData login2FA2(String idPib, String hash2FA,String cookieHash) throws Exception{
		com.login.SSOData ssoData = new com.login.SSOData();
		Boolean loginBoolean = login.login2FA2(idPib, hash2FA);
		if(loginBoolean==true){
			trust.newLogin2FA(cookieHash,idPib);
			System.out.println("<sso><login2FA2>cookieHash = "+cookieHash);
			ssoData.setCookieHash(cookieHash);
			ssoData.setIs2FA(true);
			ssoData.setLogin2FA1Success(true);
			ssoData.setLogin2FA2Success(true);
		}
		
		return ssoData;
	}
	
	
	
}

