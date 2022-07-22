/* 07-20-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 2.1****
 * Print the Fibonacci Series by getting the value from the user (0,1,1,2,3,5,8,13...)?
 */

package com.assignments.Assignment_2;

import java.util.Scanner;

public class Fibonacci
{
	public static void main(String[] args)
	{
		//Initialize variables.
		int fib0 = 0;
		int fib1 = 1;
		int fibN;
		int count;
		
		//User input.
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter number of terms: ");
		
		count = input.nextInt();
		input.close();	//Close to prevent leaks.
		
		System.out.println('\n' + "Fibonacci series for " + count + " is:");
		
		for(int i = 0; i <= count; i++)
		{
			if(i <= 1)
			{
				fibN = i;
			}
			else
			{
				fibN = fib0 + fib1;
				fib0 = fib1;
				fib1 = fibN;
			}			
			System.out.println(fibN);	//Print Fibonacci sequence.
		}	
	}
}