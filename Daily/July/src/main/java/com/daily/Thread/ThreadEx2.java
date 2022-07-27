/*July 27, 2022*/

package com.daily.Thread;

public class ThreadEx2 implements Runnable
{
	@Override
	public void run()
	{
		System.out.println("My Thread is Running.");
		System.out.println("My Thread is Finished.");
	}
	
	public static void main(String[] args)
	{
		ThreadEx2 t1 = new ThreadEx2();
		Thread tt = new Thread(t1);
		tt.start();
	}

}
