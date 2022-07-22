/* 07-21-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 3.2****
 * Create a class Student which has following methods:
 *	- Average: which would accept marks of 3 examinations & return whether the
 * 	  student has passed or failed depending on whether he has scored an average above 50 or not?
 *	- Input: which would accept the name of the
 *	  student & returns the name.
 */

package com.assignments.Assignment_3;

import java.util.*;

class Student
{
	public static boolean Average(int mark_1, int mark_2, int mark_3)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first examination score: ");
		mark_1 = input.nextInt();
		
		System.out.print("Enter the second examination score: ");
		mark_2 = input.nextInt();
		
		System.out.print("Enter the third examination score: ");
		mark_3 = input.nextInt();
		
		input.close();
		
		int result = ((mark_1 + mark_2 + mark_3) / 3);
		
		System.out.println("The average is: " + result);
		
		if(result > 50)
		{
			System.out.println("Passed");
			return true;
		}
		else
		{
			System.out.println("Failed");
			return false;
		}		
	}
	
	public String Input(String studentName)
	{
		return studentName;		
	}
	
	public static void main(String[] args)
	{
		Average(0, 0, 0);
	}
}