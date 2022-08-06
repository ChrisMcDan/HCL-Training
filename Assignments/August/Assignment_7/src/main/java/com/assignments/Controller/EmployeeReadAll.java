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
import java.util.ArrayList;
import java.util.List;

import com.assignments.DAO.EmployeeDAO;
import com.assignments.Model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/readall")
public class EmployeeReadAll extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;

	public void init()
	{
		employeeDAO = new EmployeeDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");

		List<Employee> empList = new ArrayList<Employee>();

		request.setAttribute("action", "retrieve");

		try
		{
			empList = employeeDAO.readAllEmp();
			request.setAttribute("employeeList", empList);
			System.out.println("List of Employees: " + empList.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
	}
}
