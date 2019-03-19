package service;

import domain.Account;

public interface AccountService {
	/**
	 * 账号id由规则生成
	 */
	void addAccount(String pwd, String type);

	void deleteAccount(String number);

	Account getAccount(String number);

	boolean isExist(String number);

	boolean isAccessible(String number, String pwd);
	
	void updatePassword(String number, String pwd);

	void updateType(String number, String type);
}
