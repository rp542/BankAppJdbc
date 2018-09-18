package com.capgemini.bankapp.dao;

import javax.security.auth.login.AccountNotFoundException;

public interface BankAccountDao {
	public double getBalance(long accountId) throws AccountNotFoundException;

	public boolean updateBalance(long accountId, double newBalance);

}
