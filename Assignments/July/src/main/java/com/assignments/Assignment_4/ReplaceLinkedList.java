/* 07-22-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 4.4****
 * Write a Java program to replace an element in a linked list?
 */

package com.assignments.Assignment_4;

import java.util.LinkedList;

public class ReplaceLinkedList
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
		
		//Display the Linked List before replacement.
		System.out.println("The Linked List before replacement is: " + linked);
		
		//Replace element at position 3 with 'Alex'.
		linked.set(3, "Alex");
		
		//Display the Linked List after replacement.
		System.out.println("\nThe Linked List after replacement is: " + linked);
	}
}