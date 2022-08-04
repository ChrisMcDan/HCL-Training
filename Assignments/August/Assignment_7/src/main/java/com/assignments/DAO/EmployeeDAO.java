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

package com.assignments.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.assignments.Model.Employee;

public class EmployeeDAO
{

	private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee"
			+ "  (fullname, username, password, address, contact) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_EMPLOYEE_BY_ID = "SELECT"
			+ "id, fullname, username, password, address, contact"
			+ "FROM employee WHERE id = ?;";

	private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee;";
	private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employee WHERE id = ?;";
	private static final String UPDATE_EMPLOYEE_SQL = "UPDATE employee SET"
			+ "fullname = ?, username = ?, password = ?, address = ?, contact = ?;";

	public EmployeeDAO(){}

	protected Connection getConn()
	{
		Connection conn = null;

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", null);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		return conn;
	}

	public void insertEmp(Employee emp) throws SQLException
	{
		System.out.println(INSERT_EMPLOYEE_SQL);

		// try-with-resources -> it will close connection automatically. You don't have
		// to handle
		// with finally block.
		// Step 1: Establish a Connection.
		try (Connection conn = getConn();
				// Step 2:Create a statement using Connection object.
				PreparedStatement preparedStatement = conn.prepareStatement(INSERT_EMPLOYEE_SQL);)
		{
			preparedStatement.setString(1, emp.getFullName());
			preparedStatement.setString(3, emp.getUserName());
			preparedStatement.setString(4, emp.getPassword());
			preparedStatement.setString(5, emp.getAddress());
			preparedStatement.setString(6, emp.getContact());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query.
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			// Process SQL exception.
			printSQLException(e);
		}
	}

	public Employee readSingleUser(int id)
	{
		Employee emp = null;

		// Step 1: Establish a Connection.
		try (Connection conn = getConn();
				// Step 2:Create a statement using Connection object.
				PreparedStatement preparedStatement = conn.prepareStatement(SELECT_EMPLOYEE_BY_ID);)
		{
			preparedStatement.setInt(1, id);

			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query.
			preparedStatement.executeQuery();
		}
		catch (SQLException e)
		{
			// Process SQL exception.
			printSQLException(e);
		}
		return emp;
	}

	public List<Employee> readAllEmp()
	{
		List<Employee> emps = new ArrayList<>();

		// Step 1: Establish a Connection.
		try (Connection conn = getConn();
				// Step 2:Create a statement using Connection object.
				PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_EMPLOYEES);)
		{
			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query.
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next())
			{
				int id = rs.getInt("id");
				String fullName = rs.getString("fullname");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String contact = rs.getString("contact");

				emps.add(new Employee(id, fullName, userName, password, address, contact));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return emps;
	}

	public boolean deleteEmp(int id) throws SQLException
	{
		boolean empDelete;

		// Step 1: Establish a Connection.
		try (Connection conn = getConn();
				// Step 2:Create a statement using Connection object.
				PreparedStatement preparedStatement = conn.prepareStatement(DELETE_EMPLOYEE_SQL);)
		{
			preparedStatement.setInt(1, id);;

			// Step 3: Execute the query or update query if more than 0.
			empDelete = preparedStatement.executeUpdate() > 0;
		}
		return empDelete;
	}

	public boolean updateEmp(Employee emp) throws SQLException
	{
		boolean empUpdate;

		// Step 1: Establish a Connection.
		try (Connection conn = getConn();
				// Step 2:Create a statement using Connection object.
				PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_EMPLOYEE_SQL);)
		{
			preparedStatement.setString(1, emp.getFullName());
			preparedStatement.setString(3, emp.getUserName());
			preparedStatement.setString(4, emp.getPassword());
			preparedStatement.setString(5, emp.getAddress());
			preparedStatement.setString(6, emp.getContact());

			// Step 3: Execute the query or update query if more than 0.
			empUpdate = preparedStatement.executeUpdate() > 0;
		}
		return empUpdate;
	}

	private void printSQLException(SQLException ex)
	{
		for (Throwable e : ex)
		{
			if (e instanceof SQLException)
			{
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();

				while (t != null)
				{
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}