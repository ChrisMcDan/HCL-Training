/*7-25-2022*/

package com.Java8;

interface Calculator
{
	int add(int a, int b);
}

public interface FunctionalInterfaceTest
{
	void call1();
	
	default void call2()
	{
		System.out.println("Calling call2 method");
	}
	
	static void call3()
	{
		System.out.println("Calling static method");
	}
}

class CalculatorImplement
{
	public static void main(String[] args)
	{
		Calculator cal = (/*int*/ x, /*int*/ y) -> (x + y);
		System.out.println(cal.add(2, 3));

		Calculator cal2 = (a, b) ->{return (a+b);};
		System.out.println(cal2.add(3, 4));
	}
	
}