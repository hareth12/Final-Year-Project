package com.login;

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

public class SMSClientService {
	
	private QueueConnection requestorQueueConnection = null;
	private QueueSender requestorQueueSender = null;
	private QueueSession requestorSession = null;
	private InitialContext ctx;
	private Hashtable requestorHashTable = new Hashtable();
    
	
	//======================
	private void sendRequestSMS(String message){
   	 requestorHashTable.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
   	 requestorHashTable.put(Context.PROVIDER_URL,"t3://localhost:7001");
   	 String returnString=null;
   	 
        try {
       	 ctx = new InitialContext(requestorHashTable);
	         Queue queue = (Queue) ctx.lookup("SMSQueue");
	         QueueConnectionFactory requestorFactory = (QueueConnectionFactory) ctx.lookup("SMSConnectionFactory");
	         requestorQueueConnection = requestorFactory.createQueueConnection();
	         requestorSession = requestorQueueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);  
	         
	         TextMessage msg = requestorSession.createTextMessage();	      
	         msg.setText(message);
	         requestorQueueSender = requestorSession.createSender(queue);
	         requestorQueueSender.send(msg);
	         System.out.println("reply to: "+msg.getJMSMessageID());
          
	         System.out.println("Message sent successfully to remote queue.");
	         
	         requestorSession.close(); // this is important.   
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
	}

	public void sendSMS(String telephone, String message){
		
		sendRequestSMS("90497848"+"|"+message);
	}
}
