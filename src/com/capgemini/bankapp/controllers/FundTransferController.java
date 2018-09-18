package com.capgemini.bankapp.controllers;

import java.io.IOException;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.bankapp.exceptions.UserNotFoundException;
import com.capgemini.bankapp.model.Customer;
import com.capgemini.bankapp.service.BankAccountService;
import com.capgemini.bankapp.service.CustomerService;
import com.capgemini.bankapp.serviceimpl.BankAccountServiceImpl;

@WebServlet("/transfer")
public class FundTransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private CustomerService service;
	BankAccountService bankAccountService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		bankAccountService = new BankAccountServiceImpl();
		context = config.getServletContext();
		service = (CustomerService) context.getAttribute("service");
	}

	public FundTransferController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		long toAccount = Long.parseLong(request.getParameter("toAccount"));
		long amount = Long.parseLong(request.getParameter("amount"));
		context.setAttribute("bankService", bankAccountService);

		Customer customer = (Customer) session.getAttribute("customer");
		request.setAttribute("success", false);

		try {
			try {
				bankAccountService.fundTransfer(customer.getBankAccount().getAccountId(), toAccount, amount);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("success", true);
			RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);

		} catch (AccountNotFoundException e) {

			request.setAttribute("success", false);
			request.setAttribute("error", e.toString());
			RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

}
