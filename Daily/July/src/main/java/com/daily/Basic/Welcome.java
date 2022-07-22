//July 19, 2022

package com.daily.Basic;

public class Welcome
{
	int x = 2;	//Instance variable.		Binary value for 2 = 1 0
	static int y = 2;	//Class variables or static variable.	Binary value for 2 = 1 0
	int v = x&y;	//Output = 2
	
	public void call()
	{
		int z = 10;	//Local variable must be initialized.
		System.out.println(z);
		System.out.println(v);
	}
	
	public static void main(String[] args)	//Entry point for Java.
	{
		Welcome w = new Welcome();
		
		System.out.println("Welcome July 2022 Batch!");
		System.out.println(w.x);
		System.out.println(Welcome.y);
		
		w.call();
	}
}