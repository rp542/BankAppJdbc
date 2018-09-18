package com.capgemini.bankapp.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.bankapp.dao.CustomerDao;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.model.Customer;
import com.capgemini.bankapp.service.CustomerService;




@WebServlet("/edit")
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CustomerDao customerDao;
       BankAccount account;
    public ServletContext context;
    private CustomerService service;

    public EditProfileController() {
        super();
       
    }
    

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
		service = (CustomerService) context.getAttribute("service");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		String customerName = request.getParameter("customerName");
		String email = request.getParameter("email");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String address = request.getParameter("address");

		HttpSession session = request.getSession();
		

		Customer customer=new Customer(customerName,customerId,null,email,address,LocalDate.parse(dateOfBirth),null);

		customer = service.updateProfile(customer);
		if (customer != null) {
			request.setAttribute("success", true);
			session.setAttribute("customer", customer);
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("success", false);
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
			dispatcher.forward(request, response);
		}

	}

}