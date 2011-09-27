package com.accountLink;
import java.util.List;

import javax.ejb.Remote;


@Remote
public interface AccountLinkRemote {
	public AddPayee2FAData addAccountLink2FA1(String idPib, long payeeAccount, long payerAccount,String telephone, String fromType, String toType) throws Exception;

	public List<AccountLinkDataStructure> getPayee(String idPib) throws Exception;

	public payPayee2FAData payPayee2FA1(String payeeIndexHash, double amount) throws Exception;

	public payPayee2FAData payPayee2FA2(String indexHash, String hash2fa)throws Exception;

	public AddPayee2FAData addAccountLink2FA2(String indexHash, String hash2FA) throws Exception;

	public long getToAccountNumber(String indexHash)throws Exception;

	public List<AccountLinkDataStructure> getAccountLink(long fromAccount) throws Exception;
}

