/* 08-02-2022 
 * Christopher McDaniel 
 * christopher.mcdaniel@hcl.com 
 * 
 * *****ASSIGNMENT 7*****
 * Create a Maven web project and apply MVC design pattern using JDBC,
 * Servlets, and JSP CRUD operation connecting with Database.
 * 
 * *****Continuation*****
 * MVC(Servlet, JSP and POJO)
 * 1. Retrieve all the employees.
 * 2. Update the employee by Id
 * 3. Delete an employee by Id
 * 4. Search an employee by Id.
 */

package com.assignments.Controller;

import java.io.IOException;

import com.assignments.DAO.EmployeeDAO;
import com.assignments.Model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class EmployeeUpdate extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;

	public void init()
	{
		employeeDAO = new EmployeeDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String state = request.getParameter("state");
        String phone = request.getParameter("phone");

        Employee employee = new Employee();//model object
        
        employee.setFullname(fullname);
        employee.setUsername(username);
        employee.setState(state);
        employee.setPhone(phone);
        employee.setId(id);
        
        try
        {
        	employeeDAO.updateEmp(employee);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
	}
}
