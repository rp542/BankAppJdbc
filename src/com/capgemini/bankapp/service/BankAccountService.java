package com.capgemini.bankapp.service;

import javax.security.auth.login.AccountNotFoundException;

import com.capgemini.bankapp.exceptions.UserNotFoundException;

public interface BankAccountService {

	
	public double getBalance(long accountId) throws AccountNotFoundException;
	public boolean withdraw(long accountId, double amount) throws AccountNotFoundException;
	public boolean deposit(long accountId, double amount);
	public boolean fundTransfer(long fromAcc, long toAcc, double amount) throws AccountNotFoundException, UserNotFoundException;

}