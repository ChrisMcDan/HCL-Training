/*July 27, 2022*/

package com.daily.Thread;

public class ThreadEx4
{

	public static void main(String[] args)
	{
		Runnable r1 = () ->
		{
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " is Running.");
			
			try
			{
				Thread.sleep(5000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(threadName + " is Finished.");
		};
		
		Thread t = new Thread(r1, "Chris Thread");
		t.start();
		
		Thread t1 = new Thread(r1, "Saran Thread");
		t1.start();

		Thread t2 = new Thread(r1, "Bradan Thread");
		t2.start();
	}

}
