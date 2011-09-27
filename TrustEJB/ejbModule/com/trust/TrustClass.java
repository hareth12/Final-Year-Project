package com.trust;


import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TrustClass {
	@Id
	private String cookieHash;
	private String loginName;
	private long timeStarted;
	private long timeToEnd;
	private int is2FA;
	
	public TrustClass(){}
	
	public TrustClass(String cookieHash, String loginName, boolean is2FABoolean){
		this.cookieHash=cookieHash;
		this.loginName=loginName;
		long timeToEnd = System.currentTimeMillis()+180000;
		long timeStarted = System.currentTimeMillis();
		this.timeStarted=timeStarted;
		this.timeToEnd=timeToEnd;
		if(is2FABoolean){
			this.is2FA=1;
		}else
			this.is2FA=0;
	}
	
	public void updateTime(){
		long timeToEnd = System.currentTimeMillis()+180000;
		long timeStarted = System.currentTimeMillis();
		this.timeStarted=timeStarted;
		this.timeToEnd=timeToEnd;
	}
	
	public boolean checkTime(){
		System.out.println("time to end: "+this.timeToEnd);
		System.out.println("System     : "+System.currentTimeMillis());
		if(this.timeToEnd>System.currentTimeMillis())
			return true;
		else
			return false;
	}
	
	public void setCookieHash(String cookieHash) {
		this.cookieHash = cookieHash;
	}
	public String getCookieHash() {
		return cookieHash;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setTimeStarted(long timeStarted) {
		this.timeStarted = timeStarted;
	}
	public long getTimeStarted() {
		return timeStarted;
	}
	public void setTimeToEnd(long timeToEnd) {
		this.timeToEnd = timeToEnd;
	}
	public long getTimeToEnd() {
		return timeToEnd;
	}

	public void setIs2FA(boolean is2FABoolean) {
		if(is2FABoolean){
			this.is2FA = 1;
		}
		else
			this.is2FA=0;
	}

	public boolean isIs2FA() {
		System.out.print("<TrustClass><isIs2FA>is2FA = " + this.is2FA);
		boolean returnBool = false;
		if(this.is2FA==1){
			returnBool=true;
		}
		else
			returnBool= false;
		return returnBool;
	}
	

	
}
