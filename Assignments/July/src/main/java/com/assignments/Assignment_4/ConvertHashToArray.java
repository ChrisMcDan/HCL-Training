/* 07-22-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 4.5****
 * Write a Java program to convert a hash set to an array?
 */

package com.assignments.Assignment_4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConvertHashToArray
{
	public static void main(String[] args)
	{
		//Created the HashSet.
		Set<String> set = new HashSet<>();
		
		//Add the values to the Array List.
		set.add("Chris");
		set.add("Saran");
		set.add("Krishna");
		set.add("Kemet");
		set.add("Bueller");
		
		//Display the HashSet before conversion.
		System.out.println("The HashSet before conversion is: " + set);
		
		String arr[] = new String[set.size()];
		
		//Converts set to array.
		set.toArray(arr);
		
		//To read the populated string array
		System.out.println("After conversion: ");
		for(String str : arr)
		{
			System.out.println(str);
		}
	}
}