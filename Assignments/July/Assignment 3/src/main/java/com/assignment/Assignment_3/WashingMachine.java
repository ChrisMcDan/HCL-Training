/* 07-21-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 3.1****
 * Create a washing machine class with the methods:
 *	- switchON
 *	- acceptClothes (accepts the no_ofClothes as an argument & returns the no_ofClothes.)
 *	- acceptDetergent
 *	- switchOFF.
 */

package com.assignment.Assignment_3;

public abstract class WashingMachine
{	
	public abstract void switchON();
	
	public int acceptClothes(int no_ofClothes)
	{
		return no_ofClothes;
	}
	
	public abstract void acceptDetergent();
	
	public abstract void switchOFF();
	
	public static void main(String[] args)
	{
		System.out.println("Operation complete.");
	}

	
}