package com.FD.bean;

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

import com.FDAccount.FDAccountClass;
import com.FDAccount.FDAccountRemote;
import com.history.HistoryData;

@MessageDriven(mappedName = "FDQueue", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class FD implements MessageListener {
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
            Queue queue = (Queue) ctx.lookup("FDReplyQueue");
            QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("FDReplyConnectionFactory");
            cnn = factory.createQueueConnection();
            session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            TextMessage msg = session.createTextMessage();

            msg.setText(message);
            sender = session.createSender(queue);
            sender.send(msg);
            
           
            System.out.println("<fd><replyToServlet>");
            session.close(); // this is important.
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	//==========
	
	
	@EJB (mappedName="FDAccount")
	FDAccountRemote fdAcct;
	
	
	/**
	 * Default constructor.
	 */
	public FD() {
		
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

			e1.printStackTrace();
		}

		
			switch(opCode){
				case 11:
				try {
						if(parameter1!=null){
							String idPib = parameter1;
							getAccountList(idPib);	
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
						System.out.println("<fd><11>failed");
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
					System.out.println("<fd><preparse>failed");
					break;
			}		
	}

	private void getAccountList(String idPib) {
		List<FDAccountClass> accountListList = fdAcct.getAccountList(idPib);
		if(!accountListList.isEmpty()){
			int i = 0;
			String replyString = "19|";
			int size = accountListList.size();
			String holdingString = null;
			
			while(i!=size){
				holdingString = Long.toString(accountListList.get(i).getTime());
				replyString = replyString + holdingString+"|";
				replyString = replyString + accountListList.get(i).getTxnName()+"|";
				holdingString = Double.toString(accountListList.get(i).getAmount());
				replyString = replyString + holdingString+"|";
				holdingString = accountListList.get(i).getStatus();
				replyString = replyString + holdingString+"|";
				holdingString = Long.toString(accountListList.get(i).getTxnNumber());
				replyString = replyString + holdingString+"|";
				i++;
			}
			
			replyToServlet(replyString);
		}else
		{
			replyToServlet("10||");
		}
		
	}
	

}


