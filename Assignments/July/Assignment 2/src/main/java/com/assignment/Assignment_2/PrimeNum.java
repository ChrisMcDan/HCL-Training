/* 07-20-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 2.2****
 * Print the prime number by getting the value from the user?
 */

package com.assignment.Assignment_2;

import java.util.Scanner;

public class PrimeNum
{
	//private static Scanner input;
	public static void main(String[] args)
	{
		//Initialize variables.
		int num;
		int min;
		int max;
		
		//Get user input.
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the Minimum Value: ");
		min = input.nextInt();
		
		System.out.println("Enter the Maximum Value: ");
		max = input.nextInt();
		
		input.close();	//Close to prevent leaks.
		
		//Print Prime numbers.
		System.out.println("The Prime Numbers from " + min +
							" to " + max + " are: ");
		
		//Calculate if Prime.
		for(num = min; num <= max; num++)
		{
			int count = 0;
			
			for(int i = 2; i <= (num/2); i++)
			{
				while(num % i == 0)
				{
					count++;
					break;
				}
			}
			if(count == 0 && num != 1)
			{
				System.out.println(num + " ");
			}
		}
	}
}