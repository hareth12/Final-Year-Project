package com.rbkBankAdmin;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
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

import com.account.AccountRemote;

 
/**
 * Message-Driven Bean implementation class for: RBK
 * 
 */
@MessageDriven(mappedName = "RBKBankAdminQueue", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class RBKBankAdmin implements MessageListener {
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
            Queue queue = (Queue) ctx.lookup("RBKBankAdminReplyQueue");
            QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("RBKBankAdminReplyConnectionFactory");
            cnn = factory.createQueueConnection();
            session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            TextMessage msg = session.createTextMessage();

            msg.setText(message);
            sender = session.createSender(queue);
            sender.send(msg);
            
           
            System.out.println("<rbk><replyToServlet>");
            session.close(); // this is important.
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	//==========
	
	
	@EJB (mappedName="Account")
	AccountRemote acct;
	
	
	/**
	 * Default constructor.
	 */
	public RBKBankAdmin() {
		
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
		String parameter4 = null;
		String parameter5 = null;
		String parameter6 = null;
		
		//parsing message into opcode, and parameters
		String preParse;
		try {
			preParse = tmsg.getText();
			String[] postParse=preParse.split("[|]+");
			opCode=Integer.parseInt(postParse[0]);

			parameter1=postParse[1];
			parameter2=postParse[2];
			parameter3=postParse[3];
			parameter4=postParse[4];
			parameter5=postParse[5];
			parameter6=postParse[6];
			
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// TODO Auto-generated method stub
		System.out.println("<rbk>");
		
			switch(opCode){
				case 11:
				try {
						if(parameter1!=null && parameter2!=null &&parameter3!=null ){
							//merely renaming
							String idPib = parameter1;
							String accountType =parameter2;
							String depositString = parameter3;
							double deposit = Double.parseDouble(depositString);
							
							createAccount(idPib, accountType, deposit);				
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
						System.out.println("<rbk bank admin><create account>failed");
					}
					break;
					
				case 21:
				
					break;
				case 31:
	
					break;	
				case 41:
			
					break;	
					
				case 51:
	
					break;	
					
				case 61:
	
					break;	
					
				case 71:

					break;	
				
				case 81:
	
					break;	
					
				case 99:
					System.out.println("<rbk><preparse>failed");
					break;
			}
		
			
	}
	
	private void createAccount(String idPib, String accountType, double deposit) {
		long accountNumber = acct.createNewAccount(idPib,accountType ,deposit);
		String accountNumberString = Long.toString(accountNumber);
		replyToServlet("19|"+accountNumberString+"|");
		
	}

}

