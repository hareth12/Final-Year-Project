package chinese.data;

public class SSOData {
	private Boolean loginSuccess;
	private String cookieHash;
	private Boolean is2FA;
	private String pre2FAHash;
	private Boolean login2FA1Success;
	private Boolean login2FA2Success;
	
	public SSOData(){
		this.loginSuccess=false;
		this.cookieHash = null;
		setIs2FA(null);
		this.pre2FAHash=null;
		this.login2FA1Success=false;
		this.login2FA2Success=false;
	}
	
	public void setLoginSuccess(Boolean loginSuccess) {
		this.loginSuccess = loginSuccess;
	}
	public Boolean getLoginSuccess() {
		return loginSuccess;
	}
	public void setCookieHash(String cookieHash) {
		this.cookieHash = cookieHash;
	}
	public void clearCookieHash(){
		this.cookieHash=null;
	}
	public String getCookieHash() {
		return cookieHash;
	}

	public void setIs2FA(Boolean is2FA) {
		this.is2FA = is2FA;
	}

	public Boolean getIs2FA() {
		return is2FA;
	}

	public void setPre2FAHash(String pre2FAHash) {
		this.pre2FAHash = pre2FAHash;
	}

	public String getPre2FAHash() {
		return pre2FAHash;
	}

	public void setLogin2FA1Success(Boolean login2FA1Success) {
		this.login2FA1Success = login2FA1Success;
	}

	public Boolean getLogin2FA1Success() {
		return login2FA1Success;
	}

	public void setLogin2FA2Success(Boolean login2FA2Success) {
		this.login2FA2Success = login2FA2Success;
	}

	public Boolean getLogin2FA2Success() {
		return login2FA2Success;
	}
	
	

}
