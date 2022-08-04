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
import java.sql.SQLException;
import java.util.List;

import com.assignments.DAO.EmployeeDAO;
import com.assignments.Model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/")
public class EmployeeController extends HttpServlet
{
	private EmployeeDAO empDAO;

	public void init()
	{
		empDAO = new EmployeeDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getServletPath();
		
		try
		{
			switch (action)
			{
				case "/new":
					newForm(request, response);
					break;
				case "/insert":
					insertEmp(request, response);
					break;
				case "/delete":
					deleteEmp(request, response);
					break;
				case "/edit":
					editForm(request, response);
					break;
				case "/update":
					updateEmp(request, response);
					break;
				default:
					listEmp(request, response);
					break;
			}
		}
		catch (SQLException ex)
        {
            throw new ServletException(ex);
        }
	}

	protected void listEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException
	{
		List<Employee> empList = empDAO.readAllEmp();
		request.setAttribute("listEmp", empList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeList.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void newForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeForm.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void editForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Employee exist = empDAO.readSingleUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeForm.jsp");
		request.setAttribute("emp", exist);
		dispatcher.forward(request, response);
	}
	
	protected void insertEmp(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		String fullName = request.getParameter("fullname");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		Employee newEmp = new Employee(0, fullName, userName, password, address, contact);
		empDAO.insertEmp(newEmp);
		response.sendRedirect("list");
	}
	
	protected void updateEmp(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		String fullName = request.getParameter("fullname");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		Employee empUpdate = new Employee(id, fullName, userName, password, address, contact);
		empDAO.updateEmp(empUpdate);
		response.sendRedirect("list");
	}
	
	protected void deleteEmp(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		empDAO.deleteEmp(id);
		response.sendRedirect("list");
	}
}