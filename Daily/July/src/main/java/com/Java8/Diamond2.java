/*July 27, 2022*/

package com.Java8;

/*
 * Diamond Problem -> related with multiple inheritance.
 * Java DOES NOT support multiple inheritance (more than one base class) but,
 * it DOES supports multilevel inheritance (Single base class).
 * You must override the display method in the implementation class.
 */

interface Test11
{
	public default void display()
	{
		System.out.println("Calling from Test11 interface.");
	}
}

interface Test22
{
	public void display();
}

public class Diamond2 implements Test11, Test22
{	
	@Override
	public void display()
	{
		System.out.println("Calling from test 22.");
	}
	
	public static void main(String[] args)
	{
		Diamond2 d = new Diamond2();
		d.display();
		Test11 tt = new Diamond2();
		tt.display();
		Test11 tt1 = (Test11)d;
		tt1.display();
		
	}
}