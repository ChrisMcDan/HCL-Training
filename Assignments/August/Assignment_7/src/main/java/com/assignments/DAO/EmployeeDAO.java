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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.assignments.Model.Employee;

public class EmployeeDAO
{
	private static final String CREATE_DATABASE_SQL = "CREATE DATABASE IF NOT EXISTS Assignment_7;";

	private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS employee"
			+ "	(id INT NOT NULL AUTO_INCREMENT," + " fullname varchar(20) DEFAULT NULL,"
			+ " username varchar(25) DEFAULT NULL," + " state VARCHAR(25) DEFAULT NULL,"
			+ " phone varchar(25) DEFAULT NULL," + " PRIMARY KEY(id));";

	private static final String OPEN_DATABASE_SQL = "USE Assignment_7;";

	private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee (fullname, username, state, phone) VALUES"
			+ " (?, ?, ?, ?);";

	private static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id = ?;";

	private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee;";

	private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employee WHERE id = ?;";

	private static final String UPDATE_EMPLOYEE_SQL = "UPDATE employee SET fullname = ?, username = ?, state = ?, phone = ?"
			+ " WHERE id = ?;";

	public EmployeeDAO(){}

	protected Connection getConnection()
	{
		Connection connection = null;

		EmployeeDAO empDAO = new EmployeeDAO();

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root");

			try
			{
				empDAO.createTable(connection);
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		return connection;
	}

	public void createTable(Connection connection) throws SQLException
	{
		// Step 1: Establish a Connection.
		try (Statement statement = connection.createStatement())
		{
			try
			{
				// Step 3: Execute the query or update query.
				statement.execute(CREATE_DATABASE_SQL);
				statement.execute(OPEN_DATABASE_SQL);
				statement.execute(CREATE_TABLE_SQL);
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
	}

	public void insertEmp(Employee employee) throws ClassNotFoundException
	{
		// try-with-resources -> it will close connection automatically. You don't have
		// to handle with finally block.
		// Step 1: Establish a Connection.
		try (Connection connection = getConnection();
				// Step 2:Create a statement using Connection object.
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL))
		{
			preparedStatement.setString(1, employee.getFullname());
			preparedStatement.setString(2, employee.getUsername());
			preparedStatement.setString(3, employee.getState());
			preparedStatement.setString(4, employee.getPhone());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query.
			preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			// Process SQL exception.
			printSQLException(e);
		}
	}

	public Employee readSingleEmp(Employee employee) throws ClassNotFoundException, SQLException
	{
		Employee emp = null;

		// Step 1: Establish a Connection.
		try (Connection connection = getConnection();
				// Step 2:Create a statement using Connection object.
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID))
		{
			preparedStatement.setInt(1, employee.getId());

			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query.
			ResultSet rs = preparedStatement.executeQuery();

			emp = new Employee();
			// Step 4: Process the ResultSet object.
			while (rs.next())
			{
				emp.setId(rs.getInt(1));
				emp.setFullname(rs.getString(2));
				emp.setUsername(rs.getString(3));
				emp.setState(rs.getString(4));
				emp.setPhone(rs.getString(5));
			}
		}
		catch(SQLException e)
		{
			// Process SQL exception.
			printSQLException(e);
		}
		return emp;
	}

	public List<Employee> readAllEmp() throws ClassNotFoundException, SQLException
	{
		List<Employee> empList = null;

		// Step 1: Establish a Connection.
		try (Connection connection = getConnection();
				// Step 2:Create a statement using Connection object.
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES))
		{
			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query.
			ResultSet rs = preparedStatement.executeQuery();
			empList = new ArrayList<Employee>();

			// Step 4: Process the ResultSet object.
			while (rs.next())
			{
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setFullname(rs.getString(2));
				emp.setUsername(rs.getString(3));
				emp.setState(rs.getString(4));
				emp.setPhone(rs.getString(5));
				empList.add(emp);
			}
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return empList;
	}

	public int deleteEmp(Employee employee) throws ClassNotFoundException
	{
		int result = 0;

		// Step 1: Establish a Connection.
		try (Connection connection = getConnection();
				// Step 2:Create a statement using Connection object.
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL))
		{
			preparedStatement.setInt(1, employee.getId());;

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query.
			result = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return result;
	}

	public int updateEmp(Employee employee) throws ClassNotFoundException
	{
		int result = 0;

		// Step 1: Establish a Connection.
		try (Connection connection = getConnection();
				// Step 2:Create a statement using Connection object.
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL))
		{
			preparedStatement.setString(1, employee.getFullname());
			preparedStatement.setString(2, employee.getUsername());
			preparedStatement.setString(3, employee.getState());
			preparedStatement.setString(4, employee.getPhone());
			preparedStatement.setInt(5, employee.getId());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query.
			result = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return result;
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