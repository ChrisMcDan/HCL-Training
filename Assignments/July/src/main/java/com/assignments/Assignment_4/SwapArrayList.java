/* 07-22-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 4.2****
 * Write a Java program to swap two elements in an array list?
 */

package com.assignments.Assignment_4;

import java.util.ArrayList;
import java.util.Collections;

public class SwapArrayList
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

		//Display the Array List before the swap.
		System.out.println("How the original Array looked: " + list1);
		
		//Swap the elements at index 1 and 3, 'Krishna' and 'Kemet'.
		Collections.swap(list1, 1, 3);

		//Display the Array List after the swap.
		System.out.println("\nHow the new Array looks: " + list1);
	}
}