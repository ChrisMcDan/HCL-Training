package com.daily.July_21_2022;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerialize
{
	public static void main(String[] args)
	{
		Student s = null;
		
		try
		{
			FileInputStream fis = new FileInputStream("Student.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			//ois.readObject returns Object, but we only want student object.
			s = (Student)ois.readObject();
			
			fis.close();
			ois.close();
			
			System.out.println(s.stuName);
			System.out.println(s.stuAddress);
			System.out.println(s.stuSSN);
		}catch(Exception e) {e.printStackTrace();}
	}
}
