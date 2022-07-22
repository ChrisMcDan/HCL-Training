/* 07-22-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 4.1****
 * Write a Java program to reverse elements in an array list?
 */

package com.assignments.Assignment_4;

import java.util.ArrayList;
import java.util.ListIterator;

public class ReverseArrayList
{
	public static void main(String[] args)
	{
		//Create the Array List.
		ArrayList<String> list1 = new ArrayList<>();	//Runtime polymorphism.
		
		//Add the values to the Array List.
		list1.add("Chris");
		list1.add("Saran");
		list1.add("Krishna");
		list1.add("Kemet");
		list1.add("Bueller");
		
		//Create Iterator to iterate through the Array List.
		ListIterator<String> itr = list1.listIterator();
		
		//Display the Array List before reversal.
		System.out.println("How the original Array looked: ");
		
		while(itr.hasNext())	//Iterate through Array List and print result.
		{
			System.out.println(itr.next());
		}
		
		//Display the Array List after reversal.
		System.out.println("\nHow the reversed Array looks: ");
		
		while(itr.hasPrevious())	//Reverse the Array List.
		{
			System.out.println(itr.previous());
		}		
	}
}