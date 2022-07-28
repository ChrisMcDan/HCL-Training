/*July 28, 2022*/

package com.daily.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx3
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JulyTraining", "root", "root");
		CallableStatement cst = con.prepareCall("{call insertEmp(?, ?, ?)}");
		
		cst.setInt(1, 7);
		cst.setString(2, "Chris");
		cst.setInt(3, 25);
		cst.execute();
		
		System.out.println("CallableStatement record inserted");
	}
}