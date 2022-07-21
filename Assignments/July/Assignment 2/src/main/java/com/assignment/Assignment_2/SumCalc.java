/* 07-20-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 2.4****
 * Write a Java Program to calculate the sum of two integers
 * and return true if the sum is equal to a third integer?
 */

package com.assignment.Assignment_2;

import java.util.Scanner;

public class SumCalc {

	public static void main(String[] args)
	{
		//Initialize variables.
		int x;
		int y;
		int z;

		//Get user input.
		Scanner input = new Scanner(System.in);
		
		System.out.print("First integer: ");
		x = input.nextInt();
		
		System.out.print("Second integer: ");
		y = input.nextInt();
		
		System.out.print("Third Integer: ");
		z = input.nextInt();
		
		input.close();	//Close to prevent leaks.
		
		System.out.print("Do two of the integers equal a third? " + SumOfBoth(x, y, z));
	}
	
	public static boolean SumOfBoth(int a, int b, int c)
	{
		//Return true if the conditions are satisfied.
		return ((a + b) == c || (b + c) == a || (c + a) == b);
	}
}
