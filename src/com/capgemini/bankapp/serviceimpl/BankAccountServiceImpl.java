package com.capgemini.bankapp.serviceimpl;

import javax.security.auth.login.AccountNotFoundException;

import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.dao.impl.BankAccountDaoImpl;
import com.capgemini.bankapp.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService {

	private BankAccountDao bankAccountDao;

	public BankAccountServiceImpl() {
		bankAccountDao = new BankAccountDaoImpl();
	}

	@Override
	public double getBalance(long accountId) throws AccountNotFoundException {
		return bankAccountDao.getBalance(accountId);
	}

	@Override
	public boolean withdraw(long accountId, double amount) throws AccountNotFoundException {
		System.out.println("BankAccountServiceImpl");
		if (bankAccountDao.updateBalance(accountId, bankAccountDao.getBalance(accountId) - amount)) {
			System.out.println("BankAccountServiceImplIf");
			return true;
		}
		return false;
	}

	@Override
	public boolean deposit(long accountId, double amount) {
		System.out.println("BankAccountServiceImpl");
		if (bankAccountDao.updateBalance(accountId, amount)) {
			System.out.println("BankAccountServiceImpdepositlIf");
			return true;
		}
		return false;
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount) throws AccountNotFoundException {
		if (bankAccountDao.getBalance(toAcc) < 0) {
			return false;
		}

		else if (bankAccountDao.updateBalance(fromAcc, -1 * amount)) {
			if (bankAccountDao.updateBalance(toAcc, amount)) {
				return true;
			}
		}
		return false;

	}

}