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

import uob.data.AccountClass;
import uob.data.AccountLinkDataStructure;
import uob.data.AddPayee2FAData;
import uob.data.PayPayee2FAData;


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
    //===========
		
	public RBKClientService(){}
	
	
     public String sendRequestRBK(String message){
    	 requestorHashTable.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
    	 requestorHashTable.put(Context.PROVIDER_URL,"t3://localhost:7001");
    	 String returnString=null;
    	 
         try {
        	 ctx = new InitialContext(requestorHashTable);
	         Queue queue = (Queue) ctx.lookup("RBKQueue");
	         QueueConnectionFactory requestorFactory = (QueueConnectionFactory) ctx.lookup("RBKConnectionFactory");
	         requestorQueueConnection = requestorFactory.createQueueConnection();
	         requestorSession = requestorQueueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
	         
	         QueueConnectionFactory replyFactory = (QueueConnectionFactory) ctx.lookup("RBKReplyConnectionFactory");
	         replyQueueConnection = replyFactory.createQueueConnection();	 
	         replySession = replyQueueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
	         replyQueue = (Destination) ctx.lookup("RBKReplyQueue");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return returnString;
		
     }
	//=======
    
     public String receiveSync() throws JMSException{
    	 System.out.println("<fypWebService><FundTransfer><receiveSync>"); 
    	 replyQueueConnection.start();
    	 Message msg = replyReceiver.receive();
    	 TextMessage tmsg = (TextMessage) msg;
    	 replyQueueConnection.close();
    	 String returnString = null;
    	
    	 if(msg==null)
    		 System.out.println("msg is null");
    	 else{
    		 System.out.println("msg is not null");
    	 	 System.out.println("content of reply:  "+tmsg.getText());
    		 returnString = tmsg.getText();
    		 return returnString;
    		 }
    	 return returnString;
     }
     
     public List<AccountClass> getAccount(String idPib){ //opCode = 11
    	 System.out.println("<RBKClientService><getAccount> method is called with idPib = "+idPib);
    	 
    	List<AccountClass> accountList = new ArrayList<AccountClass>();
		String returnFromRBK = null;
		String opCodeString=null;
		String accountNumberString = null;
		String currentBalanceString = null;
		String availableBalanceString = null;
		String accountType = null;
    	
		if((idPib!=null)&&(!idPib.isEmpty())){
    		returnFromRBK=sendRequestRBK("11|"+idPib+"|filler|filler|filler|filler|filler");
    		System.out.println("returnFromRBK= "+returnFromRBK);
    	}
		
		if(returnFromRBK!=null){
			String[] postParse = returnFromRBK.split("[|]+");
			opCodeString = postParse[0];
			int j= postParse.length;
			
			//active
			if(opCodeString.equals("19")){
				int i=1;
				while(i!=j){
					System.out.println("<fypWebService><RBKClientService>accountNumber = "+postParse[i]);
					accountNumberString = postParse[i];
					i++;
					System.out.println("<fypWebService><RBKClientService>accountType = "+postParse[i]);
					accountType = postParse[i];
					i++;
					System.out.println("<fypWebService><RBKClientService>currentBalance = "+postParse[i]);
					currentBalanceString = postParse[i];
					i++;
					System.out.println("<fypWebService><RBKClientService>availableBalance = "+postParse[i]);
					availableBalanceString = postParse[i];
					i++;
				
					long accountNumber = Long.parseLong(accountNumberString);
					double currentBalance=Double.parseDouble(currentBalanceString);
					double avaibleBalance=Double.parseDouble(availableBalanceString);
					AccountClass x = new AccountClass();
					
					x.setAccountNumber(accountNumber);
					x.setAccountType(accountType);
					x.setAvailableBalance(avaibleBalance);
					x.setCurrentBalance(currentBalance);
					
					accountList.add(x);
	
				}	
			}
				return accountList;
		}
		else{
			System.out.println("<rbkClientService><getAccount>returnFromRBK is null");
		}
		
    	return null;
    	 
     }


	public List<AccountLinkDataStructure> getPayeeList(String idPib) { //opCode = 21
		 System.out.println("<RBKClientService><getPayeeList> method is called with idPib = "+idPib);
	    
		 List<AccountLinkDataStructure> payeeList = new ArrayList<AccountLinkDataStructure>();
		 
			String returnFromRBK = null;
			String opCodeString=null;
			String accountNumberString = null;
			String accountLinkHash = null;
			
			if((idPib!=null)&&(!idPib.isEmpty())){
	    		returnFromRBK=sendRequestRBK("21|"+idPib+"|filler|filler|filler|filler|filler");
	    		System.out.println("returnFromRBK= "+returnFromRBK);
	    	}else{
	    		System.out.println("<fypWebService><RBKClientSerivce><getPayeeList> idPib is null/empty");
	    	}
		
		if(returnFromRBK!=null){
			String[] postParse = returnFromRBK.split("[|]+");
			opCodeString = postParse[0];
			int j= postParse.length;
			
			System.out.println("<rbkClientService><getPayeeList>opCodeString = "+opCodeString);
			//active
			if(opCodeString.equals("29")){
				int i=1;
				while(i!=j){
					System.out.println("<fypWebService><RBKClientService><getPayeeList>accountNumber = "+postParse[i]);
					accountNumberString = postParse[i];
					i++;
					System.out.println("<fypWebService><RBKClientService><getPayeeList>accountType = "+postParse[i]);
					accountLinkHash = postParse[i];
					i++;
					
					long accountNumber = Long.parseLong(accountNumberString);
					AccountLinkDataStructure x = new AccountLinkDataStructure();
					
					x.setPayeeAccount(accountNumber);
					x.setAccountLinkHash(accountLinkHash);
					
					payeeList.add(x);
	
				}	
			}else
			{
				System.out.println("<rbkClientService><getPayeeList>At the first return null");
				return null;
			}
			
			return payeeList;
			
		}else{
			System.out.println("<rbkClientService><getPayeeList>returnFromRBK is null");
		}
		 
		 return null;
	}

	public List<AccountLinkDataStructure> getAccountLink(long fromAccount){//opcode = 31 
		System.out.println("<RBKClientService><getAccountLink> method is called with fromAccount = "+fromAccount);
	    
		 List<AccountLinkDataStructure> payeeList = new ArrayList<AccountLinkDataStructure>();
		 
			String returnFromRBK = null;
			String opCodeString=null;
			String payerAccountType = null;
			String payerAccountNumberString = null;
			String payeeAccountType = null;
			String payeeAccountNumberString = null;
			String indexHash = null;
			
			String fromAccountString = Long.toString(fromAccount);
						
	    	returnFromRBK=sendRequestRBK("31|"+fromAccountString+"|filler|filler|filler|filler|filler");
	    	System.out.println("returnFromRBK= "+returnFromRBK);

		
		if(returnFromRBK!=null){
			String[] postParse = returnFromRBK.split("[|]+");
			opCodeString = postParse[0];
			int j= postParse.length;
			
			System.out.println("<rbkClientService><getPayeeList>opCodeString = "+opCodeString);
			//active
			if(opCodeString.equals("39")){
				int i=1;
				while(i!=j){
					System.out.println("<fypWebService><RBKClientService><getAccountLink>payerAccountType = "+postParse[i]);
					payerAccountType = postParse[i];
					i++;
					System.out.println("<fypWebService><RBKClientService><getAccountLink>payerAccountNumber = "+postParse[i]);
					payerAccountNumberString = postParse[i];
					i++;
					System.out.println("<fypWebService><RBKClientService><getAccountLink>payeeAccountType = "+postParse[i]);
					payeeAccountType = postParse[i];
					i++;
					System.out.println("<fypWebService><RBKClientService><getAccountLink>payeeAccountNumber= "+postParse[i]);
					payeeAccountNumberString = postParse[i];
					i++;
					System.out.println("<fypWebService><RBKClientService><getAccountLink>indexHash = "+postParse[i]);
					indexHash = postParse[i];
					i++;
					
					long payerAccountNumber = Long.parseLong(payerAccountNumberString);
					long payeeAccountNumber = Long.parseLong(payeeAccountNumberString);
					AccountLinkDataStructure x = new AccountLinkDataStructure();
					
					x.setPayerAccountType(payerAccountType);
					x.setPayerAccount(payerAccountNumber);
					x.setPayeeAccountType(payeeAccountType);
					x.setPayeeAccount(payeeAccountNumber);
					x.setAccountLinkHash(indexHash);
		
					payeeList.add(x);
	
				}	
			}else
			{
				System.out.println("<rbkClientService><getPayeeList>At the first return null");
				return null;
			}
			
			return payeeList;
			
		}else{
			System.out.println("<rbkClientService><getPayeeList>returnFromRBK is null");
		}
		 
		 return null;
	}

	public PayPayee2FAData payPayee2FA1(String payeeIndexHash, double amount) { //opCode= 41
		System.out.println("<fypWebService><RBKClientService><payPayee2FA1> method is called with payeeIndexHash = "+payeeIndexHash);
		
		
		PayPayee2FAData x = new PayPayee2FAData();
		String returnFromRBK = null;
		String opCodeString=null;
		
		long payeeAccount;
		String preHash;
		
		x.setAmount(amount);
		x.setIndexHash(payeeIndexHash);
		
		if((payeeIndexHash!=null)&&(!payeeIndexHash.isEmpty())){
			String amountString = Double.toString(amount);
	    	returnFromRBK=sendRequestRBK("41|"+payeeIndexHash+"|"+amountString+"|filler|filler|filler|filler");
	    	
	    	System.out.println("<fypWebService><RBKClientService><payPayee2FA1>returnFromRBK= "+returnFromRBK);
	    }else{
	    	System.out.println("<fypWebService><RBKClientSerivce><payPayee2FA1>payeeIndexHash is null/empty");
	    }
		
		if(returnFromRBK!=null){
			String[] postParse = returnFromRBK.split("[|]+");
			opCodeString = postParse[0];
			
			System.out.println("<fypWebService><RBKClientSerivce><payPayee2FA1>opCodeString = "+opCodeString);
			
			//active
			if(opCodeString.equals("49")){
					System.out.println("<fypWebService><RBKClientService><payPayee2FA1>accountNumber = "+postParse[1]);
					String accountNumberString = postParse[1];
					payeeAccount = Long.parseLong(accountNumberString); 
					x.setPayeeAccount(payeeAccount);
					
					System.out.println("<fypWebService><RBKClientService><payPayee2FA1>preHash= "+postParse[2]);
					preHash = postParse[2];
					x.setPreHash(preHash);
			}			
			else
			{
				System.out.println("<fypWebService><RBKClientSerivce><payPayee2FA1>Failed");
			}
				
		}
		
		return x;
	}


	public PayPayee2FAData payPayee2FA2(String indexHash, String hash2FA) { //opCode 51
		System.out.println("<fypWebService><RBKClientService><payPayee2FA2> method is called with indexHash = "+indexHash);
		System.out.println("<fypWebService><RBKClientService><payPayee2FA2> method is called with hash2FA   = "+hash2FA);
		
		PayPayee2FAData x = new PayPayee2FAData();
		String returnFromRBK = null;
		String opCodeString=null;
		x.setIndexHash(indexHash);
		
		if((indexHash!=null)&&(!indexHash.isEmpty())&&(hash2FA!=null)&&(!hash2FA.isEmpty())){
	    	returnFromRBK=sendRequestRBK("51|"+indexHash+"|"+hash2FA+"|filler|filler|filler|filler");	    	
	    	System.out.println("<fypWebService><RBKClientService><payPayee2FA2>returnFromRBK= "+returnFromRBK);
	    }else{
	    	System.out.println("<fypWebService><RBKClientSerivce><payPayee2FA2>indexHash/hash2FA is null/empty");
	    }
		
		if(returnFromRBK!=null){
			String[] postParse = returnFromRBK.split("[|]+");
			opCodeString = postParse[0];
			
			System.out.println("<fypWebService><RBKClientSerivce><payPayee2FA2>opCodeString = "+opCodeString);
			
			//active
			if(opCodeString.equals("59")){
					System.out.println("<fypWebService><RBKClientService><payPayee2FA2>toNumber = "+postParse[1]);
					String accountNumberString = postParse[1];
					Long payeeAccount = Long.parseLong(accountNumberString); 
					x.setPayeeAccount(payeeAccount);
					
					System.out.println("<fypWebService><RBKClientService><payPayee2FA2>Amount= "+postParse[2]);
					String amountString = postParse[2];
					double amount = Double.parseDouble(amountString);
					x.setAmount(amount);
					
					System.out.println("<fypWebService><RBKClientService><payPayee2FA2>fromNumber= "+postParse[3]);
					String fromAccountNumberString = postParse[3];
					long fromAccount=Long.parseLong(fromAccountNumberString);
					x.setPayerAccount(fromAccount);
					
					x.setPayPayee2FA2Success(true);
					x.setPayPayee2FA1Success(true);
					
			}			
			else
			{
				x.setPayPayee2FA1Success(true);
				x.setPayPayee2FA2Success(false);
				System.out.println("<fypWebService><RBKClientSerivce><payPayee2FA2>Failed");
			}
				
		}
		
		return x;
	}

	public AddPayee2FAData addPayee2FA1(String userName,long from, long to, String telephone, String fromType, String toType) { //opCode = 61
		System.out.println("<fypWebService><RBKClientService><addPayee2FA1> method is called with fromType = "+fromType);
		System.out.println("<fypWebService><RBKClientService><addPayee2FA1> method is called with  toType   = "+ toType);
		System.out.println("<fypWebService><RBKClientService><addPayee2FA1> method is called with userName   = "+userName);
		
		AddPayee2FAData x = new AddPayee2FAData();
		String returnFromRBK = null;
		String opCodeString=null;
		String fromString = Long.toString(from);
		String toString = Long.toString(to);
		
	    returnFromRBK=sendRequestRBK("61|"+userName+"|"+fromString+"|"+toString+"|"+telephone+"|"+fromType+"|"+toType);
	    
	    System.out.println("<fypWebService><RBKClientService><addPayee2FA1>returnFromRBK= "+returnFromRBK);
	 
		if(returnFromRBK!=null){
			String[] postParse = returnFromRBK.split("[|]+");
			opCodeString = postParse[0];
			
			System.out.println("<fypWebService><RBKClientSerivce><addPayee2FA1>opCodeString = "+opCodeString);
			
			//active
			if(opCodeString.equals("69")){
					System.out.println("<fypWebService><RBKClientService><addPayee2FA1>preHash = "+postParse[1]);
					System.out.println("<fypWebService><RBKClientService><addPayee2FA1>indexHash = "+postParse[2]);
					x.setPreHash(postParse[1]);
					x.setIndexHash(postParse[2]);
					x.setPayerAccount(from);
					x.setPayeeAccount(to);
					x.setAddPayee2FA1Success(true);
					
			}			
			else
			{
				x.setAddPayee2FA1Success(false);
				System.out.println("<fypWebService><RBKClientSerivce><addPayee2FA1>Failed");
			}
				
		}
		return x;
	}


	public AddPayee2FAData addPayee2FA2(String indexHash, String hash2FA) { //opCode = 71
		System.out.println("<fypWebService><RBKClientService><addPayee2FA2> method is called with indexHash = "+indexHash);
		System.out.println("<fypWebService><RBKClientService><addPayee2FA2> method is called with hash2FA = "+hash2FA);
		
		AddPayee2FAData x = new AddPayee2FAData();
		String returnFromRBK = null;
		String opCodeString=null;
		
		returnFromRBK=sendRequestRBK("71|"+indexHash+"|"+hash2FA+"|filler|filler|filler|filler");	    	
		System.out.println("<fypWebService><RBKClientService><addPayee2FA2>returnFromRBK= "+returnFromRBK);
		
		if(returnFromRBK!=null){
			String[] postParse = returnFromRBK.split("[|]+");
			opCodeString = postParse[0];
			
			System.out.println("<fypWebService><RBKClientSerivce><addPayee2FA2>opCodeString = "+opCodeString);
			
			//active
			if(opCodeString.equals("79")){
					System.out.println("<fypWebService><RBKClientService><addPayee2FA2>from account = "+postParse[1]);
					System.out.println("<fypWebService><RBKClientService><addPayee2FA2>to account   = "+postParse[2]);
					
					long from = Long.parseLong(postParse[1]);
					long to = Long.parseLong(postParse[2]);
					
					x.setAddPayee2FA2Success(true);
					x.setAddPayee2FA1Success(true);
					x.setIndexHash(indexHash);
					x.setPayerAccount(from);
					x.setPayeeAccount(to);				
					
			}			
			else
			{
				x.setAddPayee2FA1Success(false);
				System.out.println("<fypWebService><RBKClientSerivce><addPayee2FA2>Failed");
			}
				
		}
		
		return x;
	}


	public long getToAccountNumber(String payeeIndexHash) { //opCode =81
		String returnFromRBK = null;
		String opCodeString=null;
		
		returnFromRBK=sendRequestRBK("81|"+payeeIndexHash+"|filler|filler|filler|filler|filler");	    	
		System.out.println("<fypWebService><RBKClientService><getToAccountNumber>returnFromRBK= "+returnFromRBK);
		
		if(returnFromRBK!=null){
			String[] postParse = returnFromRBK.split("[|]+");
			opCodeString = postParse[0];
			
			System.out.println("<fypWebService><RBKClientSerivce><getToAccountNumber>opCodeString = "+opCodeString);
			
			//active
			if(opCodeString.equals("89")){
					System.out.println("<fypWebService><RBKClientService><getToAccountNumber>to account   = "+postParse[1]);
					long to = Long.parseLong(postParse[1]);
					return to;
			}			
			else
			{
				System.out.println("<fypWebService><RBKClientSerivce><getToAccountNumber>Failed");
			}
		
	}
	return -1;
	
	}
}

