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

package com.assignments.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee
{
	private int id;
	private String fullname;
	private String username;
	private String state;
	private String phone;
	
//	public int getId()
//	{
//		return id;
//	}
//	
//	public void setId(int id)
//	{
//		this.id = id; 
//	}
//	
//	public String getFullname()
//	{
//		return fullname;
//	}
//	
//	public void setFullname(String fullname)
//	{
//		this.fullname = fullname; 
//	}
//	
//	public String getUsername()
//	{
//		return username;
//	}
//	
//	public void setUsername(String Username)
//	{
//		this.username = Username; 
//	}
//	
//	public String getState()
//	{
//		return state;
//	}
//	
//	public void setState(String state)
//	{
//		this.state = state; 
//	}
//	
//	public String getPhone()
//	{
//		return phone;
//	}
//	
//	public void setPhone(String phone)
//	{
//		this.phone = phone;
//	}
}
