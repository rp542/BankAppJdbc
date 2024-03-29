package com.capgemini.bankapp.model;
import java.util.Objects;

public class BankAccount {
	private long accountId;
	private double balance;
	private String accountType;
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(long accountId, double balance, String accountType) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.accountType = accountType;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(accountId,accountType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (accountId != other.accountId)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
}