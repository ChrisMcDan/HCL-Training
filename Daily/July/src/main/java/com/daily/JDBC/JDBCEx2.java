/*July 28, 2022*/

package com.daily.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCEx2
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JulyTraining", "root", "root");
		
//		PreparedStatement pst = con.prepareStatement("Insert into emp values(?, ?, ?)");
//		
//		pst.setInt(1,  6);	//1 refers to the first parameter	'?' = '6'.
//		pst.setString(2,  "Hadiqa");	//'?' = 'Hadiqa'
//		pst.setInt(3, 24);	//'?' = '24'
//		
//		int x = pst.executeUpdate();
//		System.out.println(x + " record(s) inserted.");
		
		
		
//		PreparedStatement pst = con.prepareStatement("update emp set name = ? where id = ?");
//		
//		pst.setString(1,  "Blaise");
//		pst.setInt(2, 4);
//		int x = pst.executeUpdate();
//		System.out.println(x + " record(s) updated.");
		
		
		
//		PreparedStatement pst = con.prepareStatement("delete from emp where id = ?");
//		
//		pst.setInt(1, 5);
//		int x = pst.executeUpdate();
//		System.out.println(x + " record(s) deleted.");
		
		
		
		PreparedStatement pst = con.prepareStatement("select * from emp");
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
		}
	}

}
