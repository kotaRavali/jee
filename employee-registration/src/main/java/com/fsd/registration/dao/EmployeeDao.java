package com.fsd.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.fsd.registration.model.Employee;

public class EmployeeDao {
	
	
	
	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		
		String INSERT_EMPLOYEE_DETAILS=" insert into employee_register"
				+"(id,firstname,lastname, username,password,address,contact) values (?,?,?,?,?,?,?);";
		
		int result =0;
		// step 1: register jdbc driver
		
		String dbDriver = "com.mysql.jdbc.Driver";

		
		Class.forName(dbDriver);


		// step 2: Create connection obj
		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javafsd?useSSL=false","root","Root Password");
		
			// step 3: create a statement using connection obj
		PreparedStatement preparedStatement = con.prepareStatement(INSERT_EMPLOYEE_DETAILS);
		preparedStatement.setInt(1, 4);
		preparedStatement.setString(2, employee.getFirstName());
		preparedStatement.setString(3, employee.getLastName());
		preparedStatement.setString(4, employee.getUserName());
		preparedStatement.setString(5, employee.getPassword());
		preparedStatement.setString(6, employee.getAddress());
		preparedStatement.setString(7, employee.getContact());

		System.out.println(preparedStatement);

		// step 4 execute preparedStatment

		result = preparedStatement.executeUpdate();
		con.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
}

}