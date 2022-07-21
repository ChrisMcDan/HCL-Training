/* 07-20-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 2.3****
 * Write a Java program to swap two variables.
 */

package com.assignment.Assignment_2;

public class SwapVar
{
	public static void main(String[] args)
	{
		//Initialize variables.
		int x = 100;
		int y = 200;
		int temp;
		
		//Pre flipped.
		System.out.println("Numbers before Swap" + '\n' +
							"X = " + x + '\n' + "Y = " + y);
		//Flip flop numbers.
		temp = x;
		x = y;
		y = temp;
		
		//Post flipped.
		System.out.println('\n'+ "Numbers after Swap" + '\n' +
							"X = " + x + '\n' + "Y = " + y);
	}

}
