package com.capgemini.bankapp.serviceimpl;

import javax.security.auth.login.AccountNotFoundException;

import com.capgemini.bankapp.dao.CustomerDao;
import com.capgemini.bankapp.dao.impl.CustomerDaoImpl;
import com.capgemini.bankapp.exceptions.UserNotFoundException;
import com.capgemini.bankapp.model.Customer;
import com.capgemini.bankapp.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao customerDao;

	public CustomerServiceImpl() {
		super();
		customerDao = new CustomerDaoImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer authenticate(Customer customer) throws UserNotFoundException, AccountNotFoundException {
		return customerDao.authenticate(customer);

	}

	@Override
	public Customer updateProfile(Customer customer) {
		Customer c = customerDao.updateProfile(customer);
		return c;
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		if(customerDao.updatePassword(customer, oldPassword, newPassword))
		{
		return true;
	}
		else
		{
			return false;
		}
	}
	

}