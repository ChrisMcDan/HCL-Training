/*August 2, 2022*/

package com.daily.Controller;

import java.io.IOException;

import com.daily.DAO.EmployeeDAO;
import com.daily.Model.Employee;

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