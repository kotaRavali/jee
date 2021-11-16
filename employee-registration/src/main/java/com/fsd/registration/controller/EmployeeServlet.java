package com.fsd.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsd.registration.dao.EmployeeDao;
import com.fsd.registration.model.Employee;


@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	private EmployeeDao employeeDao;
	
	public EmployeeServlet() {
	}



	public void init() {
	employeeDao = new EmployeeDao();

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/employeeregister.jsp");
		dispatcher.forward(request, response);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");

		Employee employee = new Employee();

		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUserName(username);
		employee.setPassword(password);
		employee.setAddress(address);
		employee.setContact(contact);



		try {
		employeeDao.registerEmployee(employee);
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}

		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/employeesuccess.jsp");
		dispatch.forward(request, response);
		

		}

}
