/* 07-20-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 2.5****
 * Write a Java Program to reverse a word?
 */

package com.assignments.Assignment_2;

import java.util.Scanner;

public class ReverseWord
{
	public static void main(String[] args)
	{
		//Initialize variables.
		String word;
		String result = "";
		char[] ch;
		
		//User input
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input a word: ");
		word = input.nextLine();
		input.close();	//Close to prevent leaks.
		
		ch = word.toCharArray();
		
		for(int i = ch.length - 1; i >= 0; i--)
		{
			result += ch[i];
		}
		
		System.out.print("The reversed word is: " + result);
	}
}