/* 08-02-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * *****ASSIGNMENT 7*****
 * Create a Maven web project and apply MVC design pattern using JDBC, Servlets,
 * and JSP CRUD operation connecting with Database.
 * 
 * *****Continuation*****
 *   MVC(Servlet, JSP and POJO)
 * 1. Retrieve all the employees
 * 2. Update the employee by Id
 * 3. Delete an employee by Id
 * 4. Search an employee by Id
 */

package com.assignments.Controller;

import java.io.IOException;

import com.assignments.DAO.EmployeeDAO;
import com.assignments.Model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 
 
@SuppressWarnings("serial")
@WebServlet("/Register")
public class EmployeeController extends HttpServlet
{  
    private EmployeeDAO employeeDAO;//HAS A

    public void init()
    {
        employeeDAO = new EmployeeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

        Employee employee = new Employee();//model object
        
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUserName(username);
        employee.setPassword(password);
        employee.setContact(contact);
        employee.setAddress(address);

        try
        {
            employeeDAO.registerEmployee(employee);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        response.sendRedirect("Success.jsp");
    }
}
