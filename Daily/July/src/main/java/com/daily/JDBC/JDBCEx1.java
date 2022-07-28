/*July 28, 2022*/

package com.daily.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx1
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JulyTraining", "root", "root");
		Statement st = con.createStatement();
		
//		st.execute("Insert into emp values(1, 'Dylan', 25)");
//		st.execute("Insert into emp values(2, 'Ajay', 26)");
//		st.execute("Insert into emp values(3, 'Chris', 27)");
//		st.execute("Insert into emp values(4, 'Joshua', 28)");
//		st.execute("Insert into emp values(5, 'Saran', 29)");
//		st.execute("Insert into emp values(6, 'dummy', 29)");
		
		st.execute("Update emp set name = 'Kemet' where id = 3");
		st.execute("Delete from emp where id = 6");
		ResultSet rs = st.executeQuery("Select * from emp");
		
		while(rs.next())
		{
			System.out.println('\n' + "Emp Number " + rs.getInt(1));
			System.out.println("Emp Name " + rs.getString("name"));
			System.out.println("Emp Age " + rs.getInt(3));
		}
	}
}