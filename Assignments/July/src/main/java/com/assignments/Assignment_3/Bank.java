/* 07-21-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 3.3****
 * Create a Bank class with methods deposit & withdraw.
 * 	- The deposit method would accept attributes amount & balance then
 * 	  returns the new balance (which is the sum of amount & balance).
 * 	- Similarly, the withdraw method would accept the attributes amount &
 * 	  balance & returns the new balance if (balance >= amount or return 0 otherwise).
 */

package com.assignments.Assignment_3;

public class Bank
{
	public static void main(String [] args)
	{
		deposit();
		withdraw();
	}
	
	public static int deposit()
	{
		int amount = 108234;
		int balance = 2989743;
		
		int newBalance = amount + balance;
		
		return newBalance;
		
	}
	
	public static int withdraw()
	{
		int amount = 108234;
		int balance = 2989743;
		
		int newBalance = amount - balance;
		
		if(balance >= amount)
		{
			return newBalance;
		}
		else
		{
			return 0;
		}
	}
}