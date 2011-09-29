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


public class ICHClientService {
	
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
	public String sendRequestICH(String message){
   	 requestorHashTable.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
   	 requestorHashTable.put(Context.PROVIDER_URL,"t3://localhost:7001");
   	 String returnString=null;
   	 
        try {
       	 ctx = new InitialContext(requestorHashTable);
	         Queue queue = (Queue) ctx.lookup("ICHBankAdminQueue");
	         QueueConnectionFactory requestorFactory = (QueueConnectionFactory) ctx.lookup("ICHBankAdminConnectionFactory");
	         requestorQueueConnection = requestorFactory.createQueueConnection();
	         requestorSession = requestorQueueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
	         
	         QueueConnectionFactory replyFactory = (QueueConnectionFactory) ctx.lookup("ICHBankAdminReplyConnectionFactory");
	         replyQueueConnection = replyFactory.createQueueConnection();	 
	         replySession = replyQueueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
	         replyQueue = (Destination) ctx.lookup("ICHBankAdminReplyQueue");
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
   	 System.out.println("<bankAdmin><receiveSync>"); 
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
    
	public boolean createNewCustomer(String idPib, String name, String address, String mobile, String hometelephone, String telephone2fa, String icnumber) {

    	String opCodeString=null;
		String returnFromICH=null;
		
		if(	idPib!=null&&!idPib.isEmpty()&&
				name!=null&&!name.isEmpty()&&	
				address!=null&&!address.isEmpty()&&
				mobile!=null&&!mobile.isEmpty()&&
				hometelephone!=null&&!hometelephone.isEmpty()&&
				telephone2fa!=null&&!telephone2fa.isEmpty() &&
				icnumber!=null&&!icnumber.isEmpty()
			){
			returnFromICH=sendRequestICH("11|"+idPib+"|"+name+"|"+address+"|"+mobile+"|"+"|"+hometelephone+"|"+telephone2fa+"|"+icnumber+"|filler|filler|filler");
			System.out.println("returnFromICH= "+returnFromICH);
		}
		else{
			return false;
		}
		
		if(returnFromICH!=null){
			String[] postParse=returnFromICH.split("[|]+");
			opCodeString=postParse[0];
			
			if(opCodeString.equals("19")){
				return true;	
			}
			else
				return false;	
		}
		else{
			System.out.println("<BankAdmin><ichClientService><login>returnFromICH is null");
		}
		return false;

	}
    
	
}