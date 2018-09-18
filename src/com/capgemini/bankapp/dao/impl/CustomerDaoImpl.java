package com.capgemini.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.login.AccountNotFoundException;

import com.capgemini.bankapp.dao.CustomerDao;

import com.capgemini.bankapp.dao.dbconnection.DbUtil;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer authenticate(Customer customer) throws AccountNotFoundException {
		String customerQuery = "SELECT * FROM customers WHERE customerid = ? AND password = ?";
		String accountQuery = "SELECT * FROM accounts WHERE customerid = ?";
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(customerQuery);
				PreparedStatement statement2 = connection.prepareStatement(accountQuery)) {

			statement.setInt(1, customer.getCustomerId());
			statement.setString(2, customer.getPassword());
			try (ResultSet result = statement.executeQuery()) {
				if (result.next()) {
					customer.setCustomerName(result.getString(2));
					customer.setEmail(result.getString(4));
					customer.setAddress(result.getString(5));
					customer.setDateOfBirth(result.getDate(6).toLocalDate());

					statement2.setLong(1, customer.getCustomerId());
					try (ResultSet result2 = statement2.executeQuery()) {
						if (result2.next()) {
							BankAccount bank = new BankAccount();
							bank.setAccountId(result2.getLong(1));
							bank.setAccountType(result2.getString(2));
							bank.setBalance(result2.getDouble(3));
							customer.setBankAccount(bank);
							return customer;
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new AccountNotFoundException("Account does not exist!");
	}

	@Override
	public Customer updateProfile(Customer customer) {
		String query = "UPDATE customers SET address = ?,dateofbirth= ?,email=?,customername=? WHERE customerid = ? ";
		String query2 = "SELECT * FROM accounts WHERE customer_id = ?";

		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);
				PreparedStatement statement2 = connection.prepareStatement(query2)) {

			statement.setString(1, customer.getAddress());
			statement.setDate(2, Date.valueOf(customer.getDateOfBirth()));
			statement.setString(3, customer.getEmail());
			statement.setString(4, customer.getCustomerName());
			statement.setInt(5, customer.getCustomerId());

			if (statement.executeUpdate() != 0) {
				statement2.setInt(1, customer.getCustomerId());
				try (ResultSet result = statement2.executeQuery()) {
					if (result.next()) {
						customer.setCustomerName(result.getString(2));
						customer.setEmail(result.getString(4));
						customer.setAddress(result.getString(5));
						customer.setDateOfBirth(result.getDate(6).toLocalDate());
						return customer;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		String query = "update customers set customers.password=? WHERE customers.customerid=?";
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setString(1, newPassword);
			statement.setLong(2, customer.getCustomerId());
			if (statement.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


}