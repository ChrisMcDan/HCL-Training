/*July 27, 2022*/

package com.daily.Thread;

public class ThreadEx1 extends Thread
{
	public void run()
	{
		System.out.println("My Thread is Running.");
		System.out.println("My Thread is Finished.");
	}
	
	public static void main(String[] args)	//Main method is always your main Thread (Parent Thread).
	{
		ThreadEx1 t1 = new ThreadEx1();	//Child Thread.
		t1.start();
	}

}
