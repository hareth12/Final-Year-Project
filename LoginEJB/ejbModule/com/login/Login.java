package com.login;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateful(mappedName="Login")
public class Login implements LoginRemote {

	
	@PersistenceContext(unitName="login-unit")
	private EntityManager em;

	@Override
	public boolean login(String idPib, String password) throws Exception {
		LoginClass x= em.find(LoginClass.class, idPib);
		if(x!=null){
			if(x.getPassword().equals(password))
				if(x.isActivated())
					return true;
			else
				return false;	
		}
		System.out.println(idPib+" not found in db");

		return false;
	}
	
	public SSOData login2FA1(String idPib, String password) throws Exception{
		LoginClass x = em.find(LoginClass.class,idPib);
		SSOData ssoData = new SSOData();
		if(x!=null){
			if(x.isActivated())
				if(x.getPassword().equals(password))
				{
				String pre2FAHash = hashGeneratorForPreHash(4);
				x.setPre2FAHash(pre2FAHash);
				String hash2FA = hashGenerator(6);
				x.setHash2FA(hash2FA);
				x.updateTime();
				ssoData.setIs2FA(true);
				ssoData.setPre2FAHash(pre2FAHash);
				ssoData.setLogin2FA1Success(true);
				
				String timeToExpire = changeDate(x.getTimeToEnd());
				sendSMS(pre2FAHash,hash2FA, x.getTelephone(), timeToExpire);
				return ssoData;
				}else{
				ssoData.setIs2FA(true);
				ssoData.setLogin2FA1Success(false);
				return ssoData;
			}				
		}
		System.out.println(idPib+" not found in db");
		return ssoData;
	}

	private String changeDate(long now){
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(now);
		System.out.println(formatter.format(calendar.getTime()));
		String x = formatter.format(calendar.getTime());
		String[] y = x.split(" ");
		x=y[0]+"+"+y[1];
		return x;
	}
	
    private void sendSMS(String preHash,String Hash , String telephone, String time) throws Exception{
    	String Msg = "The+SMS-OTP+is+"+preHash+"+"+Hash+"+for+TheBank+Personal+Internet+Banking+Please+enter+by+"+time+"+Singapore+Time";
        URL smsURL = new URL("http://www.smsxchange.com/scripts/sendsms.asp?phone="+telephone +"&sms="+Msg+"&userid=zhongcai&password=607945");
            URLConnection yc = smsURL.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while((inputLine=in.readLine())!=null){
                System.out.println(inputLine);
            }
            in.close();
        }
	
	private String hashGenerator(int len){
		String AB = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );		
		return sb.toString();
		
	}	
	
	private String hashGeneratorForPreHash(int len){
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );		
		return sb.toString();
		
	}
	
	private int randomCustomerNumberGenerator(){
		
		String AB = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(6);
		for( int i = 0; i < 6; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );		
		String resultString=sb.toString();	
		int resultInt=Integer.parseInt(resultString);	
		
		return resultInt;
	}

	@Override
	public boolean login2FA2(String idPib, String hash2FA) throws Exception {
		LoginClass x = em.find(LoginClass.class,idPib);
		SSOData ssoData = new SSOData();
		if(x!=null){
			if(x.getHash2FA().equals(hash2FA))
				if(x.checkTime())
					return true;					
		}
		System.out.println(idPib+" not found in db or other reasons");
		return false;
	}
	
	public String requestNewHash2FA(String idPib){
		LoginClass x = em.find(LoginClass.class,idPib);
		String pre2FAHash = hashGeneratorForPreHash(4);
		x.setPre2FAHash(pre2FAHash);
		String hash2FA = hashGenerator(6);
		x.setHash2FA(hash2FA);
		x.updateTime();
		return pre2FAHash;	
	}

	@Override
	public String getTelephone(String idPib) throws Exception {
		LoginClass x = em.find(LoginClass.class,idPib);
		if(x!=null){
			return x.getTelephone();
		}
		return null;
	}

	@Override
	public SSOData send2FACode(String idPib) throws Exception {
		LoginClass x = em.find(LoginClass.class,idPib);
		SSOData ssoData = null;
		if(x!=null){
				String pre2FAHash = hashGeneratorForPreHash(4);
				x.setPre2FAHash(pre2FAHash);
				String hash2FA = hashGenerator(6);
				x.setHash2FA(hash2FA);
				x.updateTime();
				ssoData = new SSOData();
				ssoData.setIs2FA(true);
				ssoData.setPre2FAHash(pre2FAHash);
				ssoData.setLogin2FA1Success(true);
				
				String timeToExpire = changeDate(x.getTimeToEnd());
				
				
				
			///	sendSMS(pre2FAHash,hash2FA, x.getTelephone(), timeToExpire);
				
				
				
				return ssoData;
			}				
		System.out.println(idPib+" not found in db");
		return ssoData;
	}

	@Override
	public boolean createPIBaccount(String idPib, String telephone) {
		LoginClass x = em.find(LoginClass.class,idPib);
		if(x==null){
			x = new LoginClass();
			x.setIdPib(idPib);
			int a = randomCustomerNumberGenerator();
			x.setIdCustomer(a);
			x.setTelephone(telephone);
			String password = hashGenerator(6);
			x.setPassword(password);
			x.setActivated(false);
			em.persist(x);
			return true;
		}
		return false;
	}

	@Override
	public boolean activateAccount(String idPib) {
		LoginClass x = em.find(LoginClass.class, idPib);
		if(x!=null){
			x.setActivated(true);
			em.persist(x);
			return true;
		}
		return false;
		
	}

	@Override
	public List<String> getListOfUnactivatedPIBId() {
		Query q = em.createQuery("SELECT m from LoginClass m where m.activated = ?1 ");
		q.setParameter(1, false);
		List<LoginClass> resultList=q.getResultList();
		List<String> xList = new ArrayList<String>();
		
		int size = resultList.size();
		int i = 0;
		while(i<size){
			xList.add(resultList.get(i).getIdPib());
			i++;
		}
		
		return xList;
	}

	@Override
	public boolean changePassword(String idPib,String oldPassword, String newPassword1,
			String newPassword2) {
		LoginClass x = em.find(LoginClass.class, idPib);
		if(x!=null){
			if(x.getPassword().equals(oldPassword)){
				if(newPassword1.equals(newPassword2)){
					x.setPassword(newPassword1);
					em.persist(x);
					return true;
				}
			}	
		}
		return false;
	}

}
