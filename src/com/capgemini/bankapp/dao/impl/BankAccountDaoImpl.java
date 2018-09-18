package com.capgemini.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.login.AccountNotFoundException;

import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.dao.dbconnection.DbUtil;

public class BankAccountDaoImpl implements BankAccountDao {

	@Override
	public double getBalance(long accountId) throws AccountNotFoundException{
		String query = "SELECT balance FROM accounts WHERE accountid = ?";
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			
			statement.setLong(1, accountId);
			try(ResultSet result = statement.executeQuery()){
			if (result.next()) {
				return result.getInt(1);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new AccountNotFoundException("Account doesn't exist!");
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		String query = "UPDATE accounts SET balance = ? WHERE accountid = ?";
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setDouble(1, newBalance);
			statement.setLong(2, accountId);
			if(statement.executeUpdate() != 0) {
				System.out.println("Record inserted successfully");
			return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


}