//July 22, 2022

package com.daily.Inner;

public class LocalInner
{
	private int y = 12;
	
	void print()
	{
		class Local
		{
			void display()
			{
				System.out.println("The private value of y is: " + y);
			}	
		}

		Local L1 = new Local();
		L1.display();
	}

	public static void main(String[] args)
	{
		LocalInner Lin = new LocalInner();
		Lin.print();
	}
}