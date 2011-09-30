package uobBankAdmin.service;


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

import uobBankAdmin.data.SSOData;


public class RBKClientService {
	
	private QueueConnection requestorQueueConnection = null;
	private QueueSender requestorQueueSender = null;
	private QueueSession requestorSession = null;
	private InitialContext ctx;
	private Hashtable requestorHashTable = new Hashtable();
    
	private QueueConnection replyQueueConnection = null;
	private Destination replyQueue;
	private QueueReceiver replyReceiver=null;
	private QueueSession replySession = null;
	
	//======================
	public String sendRequestRBK(String message){
   	 requestorHashTable.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
   	 requestorHashTable.put(Context.PROVIDER_URL,"t3://localhost:7001");
   	 String returnString=null;
   	 
        try {
       	 ctx = new InitialContext(requestorHashTable);
	         Queue queue = (Queue) ctx.lookup("RBKBankAdminQueue");
	         QueueConnectionFactory requestorFactory = (QueueConnectionFactory) ctx.lookup("RBKBankAdminConnectionFactory");
	         requestorQueueConnection = requestorFactory.createQueueConnection();
	         requestorSession = requestorQueueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
	         
	         QueueConnectionFactory replyFactory = (QueueConnectionFactory) ctx.lookup("RBKBankAdminReplyConnectionFactory");
	         replyQueueConnection = replyFactory.createQueueConnection();	 
	         replySession = replyQueueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
	         replyQueue = (Destination) ctx.lookup("RBKBankAdminReplyQueue");
	         replyReceiver = replySession.createReceiver((Queue) replyQueue);
	       
	         
	         
	         TextMessage msg = requestorSession.createTextMessage();	      
	         msg.setText(message);
	         msg.setJMSReplyTo(replyQueue);
	         requestorQueueSender = requestorSession.createSender(queue);
	         requestorQueueSender.send(msg);
	         System.out.println("reply to: "+msg.getJMSMessageID());
          
	         System.out.println("Message sent successfully to remote queue.");
	         
	         returnString = receiveSync();
	         requestorSession.close(); // this is important.
	         replySession.close();
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
		
		
		return returnString;
		
    }
	//=======
   
    private String receiveSync() throws JMSException{
   	 System.out.println("<bankAdmin><Login><receiveSync>"); 
   	 String returnString=null;
   	 replyQueueConnection.start();
   	 Message msg = replyReceiver.receive();
   	 TextMessage tmsg = (TextMessage) msg;
   	 replyQueueConnection.close();
   	
   	 if(msg==null)
   		 System.out.println("msg is null");
   	 else{
   		 System.out.println("msg is not null");
   	 	 System.out.println("content of reply:  "+tmsg.getText());
   	 	 
   	 	 returnString=tmsg.getText();
   	 	 }
   		 return returnString;
    }
	
	//======================
    
    public long createNewAccount(String accountType, String idPib, double deposit ){
    	long x = -1;
    	String depositString = Double.toString(deposit);
    	String opCodeString=null;
		String returnFromRBK=null;
		
		if((accountType!=null)&&(idPib!=null)&&!accountType.isEmpty()&&!idPib.isEmpty()){
			returnFromRBK = sendRequestRBK("11|"+idPib+"|"+accountType+"|"+depositString+"|filler|filler|filler|filler");
			System.out.println("returnFromRBK= "+returnFromRBK);
		}
		else{
			System.out.println("<BankAdmin><rbkClientService><createNewAccount>idPib/password is null/empty.0");
		}
		
		if(returnFromRBK!=null){
			String[] postParse=returnFromRBK.split("[|]+");
			opCodeString=postParse[0];
			
			if(opCodeString.equals("19")){
				String accountString = postParse[1]; //for renaming purpose
				x = Long.parseLong(accountString);		
			}
				
		}
		else{
			System.out.println("<BankAdmin><rbkClientService><createNewAccount>returnFromSSO is null");
		}

    	return x;
    }
}