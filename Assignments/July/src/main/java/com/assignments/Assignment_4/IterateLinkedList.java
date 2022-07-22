/* 07-22-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 4.3****
 * Write a Java program to iterate through all elements in a
 * linked list starting at a specified position?
 */

package com.assignments.Assignment_4;

import java.util.LinkedList;

public class IterateLinkedList
{
	public static void main(String[] args)
	{
		//Created the Linked List.
		LinkedList<String> linked = new LinkedList<>();	//Runtime polymorphism.
		
		//Add the values to the Array List.
		linked.add("Chris");
		linked.add("Saran");
		linked.add("Krishna");
		linked.add("Kemet");
		linked.add("Bueller");
		
		//Initialize variable.
		int i = 0;
		
		//Iterates through the Linked List starting at position 'i'.
		while(i < linked.size())
		{
			System.out.println(linked.get(i));	//Prints the result.
			i++;	//Increment until reach end of list.
		}
	}
}