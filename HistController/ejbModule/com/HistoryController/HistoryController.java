package com.HistoryController;

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

import com.history.HistoryData;
import com.history.HistoryRemote;

 
/**
 * Message-Driven Bean implementation class for: HistoryController
 * 
 */
@MessageDriven(mappedName = "HistQueue", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class HistoryController implements MessageListener {
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
            Queue queue = (Queue) ctx.lookup("HistReplyQueue");
            QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("HistReplyConnectionFactory");
            cnn = factory.createQueueConnection();
            session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            TextMessage msg = session.createTextMessage();

            msg.setText(message);
            sender = session.createSender(queue);
            sender.send(msg);
            
           
            System.out.println("<historyController><replyToServlet>");
            session.close(); // this is important.
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	//==========
	
	
	@EJB (mappedName="History")
	HistoryRemote hist;
	
	
	/**
	 * Default constructor.
	 */
	public HistoryController() {
		
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

		System.out.println("<historyController>");
		
			switch(opCode){
				case 11:
					if(parameter1!=null){
						//merely renaming
						String idPib = parameter1;
						login1FASuccess(idPib);
						replyToServlet("19");				
					}
					break;					
				case 21:
					if(parameter1!=null){
						//merely renaming
						String idPib = parameter1;
						login1FANotSuccess(idPib);
						replyToServlet("29");
					}
					break;
				case 31:
					if(parameter1!=null){
						//merely renaming
						String idPib = parameter1;
						login2FASuccess(idPib);
						replyToServlet("39");
					}
					break;	
				case 41:
					if(parameter1!=null){
						//merely renaming
						String idPib = parameter1;
						login2FANotSuccess(idPib);
						replyToServlet("49");
					}
					break;						
				case 51:
					if(parameter1!=null){
						//merely renaming
						String idPib = parameter1;
						String fromS = parameter2;
						String toS = parameter3;
						addPayeeSuccess(idPib,fromS,toS);
						replyToServlet("59");
					}
					break;	
				case 61:
					if(parameter1!=null){
						//merely renaming
						String idPib = parameter1;
						String fromS = parameter2;
						String toS = parameter3;
						addPayeeNotSuccess(idPib,fromS,toS);
						replyToServlet("69");
					}
					break;						
				case 71:
					if(parameter1!=null){
						//merely renaming
						String idPib = parameter1;
						String fromS = parameter2;
						String toS = parameter3;
						String amount=parameter4;
						fundTransferSuccess(idPib,fromS,toS,amount);
						replyToServlet("79");
					}
					break;	
				case 81:
					if(parameter1!=null){
						//merely renaming
						String idPib = parameter1;
						try {
							getHistory(idPib);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					break;	
				case 91:
					if(parameter1!=null){
						//merely renaming
						String idPib = parameter1;
						String fromS = parameter2;
						String toS = parameter3;
						String amount=parameter4;
						
			
						fundTransferNotSuccess(idPib,fromS,toS,amount);
						replyToServlet("99");
					}
					break;
				case 111:
					if(parameter1!=null){
						//merely renaming
						String idPib = parameter1;		
			
						logout(idPib);
						replyToServlet("119");
					}
					break;	
					
				case 121:
					if(parameter1!=null){
						//merely renaming
						String idPib = parameter1;		
			
						changePasswordSuccess(idPib);
						replyToServlet("129");
					}
					break;
				
				case 131:
					if(parameter1!=null){
						//merely renaming
						String idPib = parameter1;		
			
						changePasswordFail(idPib);
						replyToServlet("139");
					}
					break;	
					
				case 99:
					System.out.println("<historyController><preparse>failed");
					break;
			}	
	}
	
	private void changePasswordFail(String idPib) {
		hist.changePasswordFail(idPib);
		
	}

	private void changePasswordSuccess(String idPib) {
		hist.changePasswordSuccess(idPib);
		
	}

	private void logout(String idPib) {
		hist.logout(idPib);
		
	}

	private void fundTransferNotSuccess(String idPib, String fromS, String toS, String amount) {
		hist.fundTransferNotSuccess(idPib,fromS,toS,amount);
		
	}

	private void fundTransferSuccess(String idPib, String fromS, String toS, String amount) {
		hist.fundTransferSuccess(idPib,fromS,toS,amount);
		
	}

	private void addPayeeNotSuccess(String idPib, String fromS, String toS) {
		hist.addPayeeNotSuccess(idPib,fromS,toS);
		
	}

	private void addPayeeSuccess(String idPib, String fromS, String toS) {
		hist.addPayeeSuccess(idPib,fromS,toS);
		
	}

	private void login2FANotSuccess(String idPib) {
		hist.addLogin2FANotSuccess(idPib);
	}

	private void login2FASuccess(String idPib) {
		hist.addLogin2FASuccess(idPib);
		
	}

	private void login1FASuccess(String idPib){  //opCode11
		hist.addLogin1FASuccess(idPib);
	}
	
	private void login1FANotSuccess(String idPib){  //opCode21
		hist.addLogin1FANotSuccess(idPib);
	}
	
	private void getHistory(String idPib) throws Exception{ //opcode = 81
		List<HistoryData> historyList = hist.getHistory(idPib);
		if(!historyList.isEmpty()){
			int i = 0;
			String replyString = "89|";
			int size = historyList.size();
			String holdingString = null;
			
			while(i!=size){
				holdingString = Long.toString(historyList.get(i).getTime());
				replyString = replyString + holdingString+"|";
				replyString = replyString + historyList.get(i).getTxnName()+"|";
				holdingString = Double.toString(historyList.get(i).getAmount());
				replyString = replyString + holdingString+"|";
				holdingString = historyList.get(i).getStatus();
				replyString = replyString + holdingString+"|";
				holdingString = Long.toString(historyList.get(i).getTxnNumber());
				replyString = replyString + holdingString+"|";
				i++;
			}
			
			replyToServlet(replyString);
		}else
		{
			replyToServlet("80||");
		}
	}
}