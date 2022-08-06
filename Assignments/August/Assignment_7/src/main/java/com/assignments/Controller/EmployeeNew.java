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
//import java.sql.SQLException;
//import java.util.List;

import com.assignments.DAO.EmployeeDAO;
import com.assignments.Model.Employee;

//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/new")
public class EmployeeNew extends HttpServlet
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
		String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String state = request.getParameter("state");
        String phone = request.getParameter("phone");

        Employee employee = new Employee();//model object
        
        employee.setFullname(fullname);
        employee.setUsername(username);
        employee.setState(state);
        employee.setPhone(phone);
        
        try
        {
        	employeeDAO.insertEmp(employee);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        response.sendRedirect("success.jsp");
	}
}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//	{
//		String action = request.getServletPath();
//		
//		try
//		{
//			switch (action)
//			{
//				case "/new":
//					newForm(request, response);
//					break;
//				case "/insert":
//					insertEmp(request, response);
//					break;
//				case "/delete":
//					deleteEmp(request, response);
//					break;
//				case "/edit":
//					editForm(request, response);
//					break;
//				case "/update":
//					updateEmp(request, response);
//					break;
//				default:
//					listEmp(request, response);
//					break;
//			}
//		}
//		catch (SQLException ex)
//        {
//            throw new ServletException(ex);
//        }
//	}
//
//	private void listEmp(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException, ServletException
//	{
//		List<Employee> listEmp = employeeDAO.readAllEmp();
//		request.setAttribute("listEmp", listEmp);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeList.jsp");
//		dispatcher.forward(request, response);
//	}
//	
//	private void newForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException
//	{
//		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeForm.jsp");
//		dispatcher.forward(request, response);
//	}
//	
//	private void editForm(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, ServletException, IOException 
//	{
//		int id = Integer.parseInt(request.getParameter("id"));
//		Employee exist = employeeDAO.readSingleEmp(id);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeForm.jsp");
//		request.setAttribute("employee", exist);
//		dispatcher.forward(request, response);
//	}
//	
//	private void insertEmp(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException
//	{
//		String fullname = request.getParameter("fullname");
//		String username = request.getParameter("username");
//		String state = request.getParameter("state");
//		String phone = request.getParameter("phone");
//		
//		Employee newEmp = new Employee(0, fullname, username, state, phone);
//		employeeDAO.insertEmp(newEmp);
//		response.sendRedirect("list");
//	}
//	
//	private void updateEmp(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException
//	{
//		int id = Integer.parseInt(request.getParameter("id"));
//		
//		String fullname = request.getParameter("fullname");
//		String username = request.getParameter("username");
//		String state = request.getParameter("state");
//		String phone = request.getParameter("phone");
//		
//		Employee empUpdate = new Employee(id, fullname, username, state, phone);
//		employeeDAO.updateEmp(empUpdate);
//		response.sendRedirect("list");
//	}
//	
//	private void deleteEmp(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException
//	{
//		int id = Integer.parseInt(request.getParameter("id"));
//		employeeDAO.deleteEmp(id);
//		response.sendRedirect("list");
//	}
//}