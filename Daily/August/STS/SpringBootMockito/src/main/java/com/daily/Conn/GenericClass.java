/*August 15, 2022*/

package com.daily.Conn;

public class GenericClass
{
	DatabaseConnection db;
	NetworkConnection nw;

	public boolean save(String fileName)
	{
		db.save(fileName);
		System.out.println("Save it in the Database");

		nw.save(fileName);
		System.out.println("Save it in the Network");

		return true;
	}
}
