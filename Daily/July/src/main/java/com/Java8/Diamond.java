/*July 27, 2022*/

package com.Java8;

interface Test1
{
	public default void display()
	{
		System.out.println("Calling from Test1 interface.");
	}
}

interface Test2
{
	public default void display()
	{
		System.out.println("Calling from Test2 interface.");
	}
}

public class Diamond implements Test1, Test2
{
	/*
	 * Diamond Problem -> related with multiple inheritance.
	 * Java DOES NOT support multiple inheritance (more than one base class) but,
	 * it DOES supports multilevel inheritance (Single base class).
	 * You must override the display method in the implementation class.
	 */
	
	@Override
	public void display()
	{
		Test1.super.display();
		Test2.super.display();			
	}
	
	public static void main(String[] args)
	{
		Diamond d = new Diamond();
		d.display();
	}
	
//	//Create ambiquity, which display method is called.
//	public void display()
//	{
//		System.out.println("Calling display method");
//	}
}