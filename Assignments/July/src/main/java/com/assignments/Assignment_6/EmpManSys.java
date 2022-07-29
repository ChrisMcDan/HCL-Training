/* 07-28-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 6****
 * JDBC -> Use Prepared and Callable Statement.  
 * Java Console -> Front-End  
 * MySQL Database -> Back-End (Store at least 5 records minimum.)
 * 
 * Getting the values from the user, apply CRUD operations (Create, Read, Update, Delete):
 * 
 * 1. Get the list of employees.
 * 2. Update the existing employee based on his/her ID.
 * 3. Delete an employee based on the employee ID.
 * 4. Get the employee by the ID.
 */

package com.assignments.Assignment_6;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpManSys
{	
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JulyTraining", "root", "root");

		while(true)
		{
			Scanner switchInput = new Scanner(System.in);
			System.out.println("\nWhat would you like to do(Create, Read, Update, Delete, or Exit)?: ");
			String msg = switchInput.next().toUpperCase();
			
			while(true)
			{
				switch(msg)
				{
				case "CREATE":
					
					CallableStatement createStat = con.prepareCall("{CALL insertEmp(?, ?, ?)}");
					
					try(Scanner empInput = new Scanner(System.in))
					{
						System.out.print("Please enter employee ID: ");
						int empID = empInput.nextInt();
						
						System.out.print("Please enter employee Name: ");
						String empName = empInput.next();
	
						System.out.print("Please enter employee Age: ");
						int empAge = empInput.nextInt();
	
						System.out.println("The employee information is, ID: " + empID
																	+ ", Name: " + empName
																	+ ", Age: " + empAge);
						
						createStat.setInt(1, empID);
						createStat.setString(2, empName);
						createStat.setInt(3, empAge);
						
						int recordInsert = createStat.executeUpdate();
						
						if(recordInsert != 0)
						{
							System.out.println("Record added.");
						}
						else
						{
							System.out.println("Failed to add record.");
						}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					
					break;
					
				case "READ":
	
					Scanner readInput = new Scanner(System.in);
					System.out.println("\nWould you like to read All of the employees, a Single one, or exit(All, Single, or Exit)?: ");
					String readMsg = readInput.next().toUpperCase();
					
					switch(readMsg)
					{
					case "ALL":
						
						PreparedStatement readStat = con.prepareStatement("SELECT * FROM emp");
						ResultSet rs = readStat.executeQuery();
						
						while(rs.next())
						{
							System.out.println('\n' + "Employee ID	" + rs.getInt(1));
							System.out.println("Employee Name	" + rs.getString("EmpName"));
							System.out.println("Employee Age	" + rs.getInt(3));
						}
						
						break;
						
					case "SINGLE":
						
						Scanner singleInput = new Scanner(System.in);
						System.out.println("\nID of the employee?: ");
						int empID = singleInput.nextInt();
						
						PreparedStatement singleStat = con.prepareStatement("SELECT * FROM emp WHERE empID = ?");
						
						singleStat.setInt(1, empID);
						
						ResultSet singleRS = singleStat.executeQuery();
						
						while(singleRS.next())
						{
							System.out.println('\n' + "Employee ID	" + singleRS.getInt(1));
							System.out.println("Employee Name	" + singleRS.getString("EmpName"));
							System.out.println("Employee Age	" + singleRS.getInt(3));
						}
						
						break;
						
					default:
						
						System.out.println("Invalid input");
					}
					
					break;
					
				case "UPDATE":
					
					CallableStatement updateStat = con.prepareCall("UPDATE emp SET empName = ?, empAge = ? WHERE empID = ?");
					
					try(Scanner empInput = new Scanner(System.in))
					{
						System.out.print("Please enter OLD employee ID: ");
						int empID = empInput.nextInt();
						
						System.out.print("Please enter NEW employee Name: ");
						String empName = empInput.next();
	
						System.out.print("Please enter NEW employee Age: ");
						int empAge = empInput.nextInt();
	
						System.out.println("The NEW employee information is, ID: " + empID
																	+ ", Name: " + empName
																	+ ", Age: " + empAge);

						updateStat.setInt(1, empID);
						updateStat.setString(2, empName);
						updateStat.setInt(3, empAge);
						updateStat.execute();
						
						System.out.println("CallableStatement record updated");
					}
					
					break;
					
				case "DELETE":
					
					PreparedStatement deleteStat = con.prepareStatement("DELETE FROM emp WHERE empID = ?");
					
					try(Scanner empInput = new Scanner(System.in))
					{
						System.out.print("Please enter employee ID to delete: ");
						int empID = empInput.nextInt();
						
						deleteStat.setInt(1, empID);
	
						int x = deleteStat.executeUpdate();
						System.out.println(x + " record(s) deleted.");
					}
					
					break;
					
				case "EXIT":
					return;
					
				default:
					System.out.println("Invalid input");
				}
			}
//			switchInput.close();
		}
	}
}