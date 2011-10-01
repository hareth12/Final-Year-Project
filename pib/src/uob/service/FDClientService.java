package uob.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

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

import uob.data.FDAccountClass;


public class FDClientService {
	private QueueConnection requestorQueueConnection = null;
	private QueueSender requestorQueueSender = null;
	private QueueSession requestorSession = null;
	private InitialContext ctx;
	private Hashtable requestorHashTable = new Hashtable();
    
	private QueueConnection replyQueueConnection = null;
	private Destination replyQueue;
	private QueueReceiver replyReceiver=null;
	private QueueSession replySession = null;
    //===========
		
	public FDClientService(){}
	
	
     public String sendRequestFD(String message){
    	 requestorHashTable.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
    	 requestorHashTable.put(Context.PROVIDER_URL,"t3://localhost:7001");
    	 String returnString=null;
    	 
         try {
        	 ctx = new InitialContext(requestorHashTable);
	         Queue queue = (Queue) ctx.lookup("FDQueue");
	         QueueConnectionFactory requestorFactory = (QueueConnectionFactory) ctx.lookup("FDConnectionFactory");
	         requestorQueueConnection = requestorFactory.createQueueConnection();
	         requestorSession = requestorQueueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
	         
	         QueueConnectionFactory replyFactory = (QueueConnectionFactory) ctx.lookup("FDReplyConnectionFactory");
	         replyQueueConnection = replyFactory.createQueueConnection();	 
	         replySession = replyQueueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
	         replyQueue = (Destination) ctx.lookup("FDReplyQueue");
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
    	 System.out.println("<pib><FD><receiveSync>"); 
    	 replyQueueConnection.start();
    	 Message msg = replyReceiver.receive();
    	 TextMessage tmsg = (TextMessage) msg;
    	 replyQueueConnection.close();
    	 String returnString = null;
    	
    	 if(msg==null)
    		 System.out.println("msg is null");
    	 else{
//    		 System.out.println("msg is not null");
    	 	 System.out.println("content of reply:  "+tmsg.getText());
    		 returnString = tmsg.getText();
    		 return returnString;
    		 }
    	 return returnString;
     }

     public List<FDAccountClass> getListOfFDAccount(String userName) { //opCode = 11
		 System.out.println("<FDClientService><11> method is called with idPib = "+userName);
    	 
	    	List<FDAccountClass> accountList = new ArrayList<FDAccountClass>();
			String returnFromFD = null;
			String opCodeString=null;
			
			String amountNumberString = null;
			String currentAmountString = null;
			String availableAmountString = null;
			String idPib = null;
			String accountType = null;
			
			
			if((userName!=null)&&(!userName.isEmpty())){
				returnFromFD=sendRequestFD("11|"+userName+"|filler|filler|filler|filler|filler");
	    		System.out.println("returnFromHist= "+returnFromFD);
	    	}
			
			if(returnFromFD!=null){
				String[] postParse = returnFromFD.split("[|]+");
				opCodeString = postParse[0];
				int j= postParse.length;
				
				//active
				if(opCodeString.equals("19")){
					int i=1;
					while(i!=j){
					//	System.out.println("<pib><HistClientService>timeString = "+postParse[i]);
						amountNumberString = postParse[i];
						i++;
					//	System.out.println("<pib><HistClientService>txnName = "+postParse[i]);
						currentAmountString = postParse[i];
						i++;
					//	System.out.println("<pib><HistClientService>amountString = "+postParse[i]);
						availableAmountString = postParse[i];
						i++;
					//	System.out.println("<pib><HistClientService>status = "+postParse[i]);
						idPib = postParse[i];
						i++;
					//	System.out.println("<pib><HistClientService>txnNumberString = "+postParse[i]);
						accountType = postParse[i];
						i++;
					
						long accountNumber = Long.parseLong(amountNumberString);
						double currentAmount = Double.parseDouble(currentAmountString);
						double availableAmount = Double.parseDouble(availableAmountString);
						
						FDAccountClass f = new FDAccountClass();
						f.setAccountNumber(accountNumber);
						f.setAccountType(accountType);
						f.setAvailableBalance(availableAmount);
						f.setCurrentBalance(currentAmount);
						f.setIdPib(idPib);
						
						accountList.add(f);
						
					}	
				}
					return accountList;
			}
			else{
				System.out.println("<FDClientService><11>returnFromFD is null");
			}
			
	    	return null;  	 
	}
}

