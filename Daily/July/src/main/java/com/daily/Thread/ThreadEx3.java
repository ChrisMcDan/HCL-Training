/*July 27, 2022*/

package com.daily.Thread;

public class ThreadEx3
{

	public static void main(String[] args)
	{
		Runnable r = new Runnable(){ public void run()
			{
				System.out.println("Runnable is Running.");
				System.out.println("Runnable is Finished.");
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		
		Runnable r1 = () ->
		{
			System.out.println("Runnable Lambda is Running.");
			System.out.println("Runnable Lambda is Finished.");
		};
		
		Thread t1 = new Thread(r1);
		t1.start();
	}
}