package com.daily.July_21_2022;

public class Ex1
{

	public static void main(String[] args)
	{
		int x = 45;
		int y = 0;
		try
		{
//			int x1 = Integer.parseInt("Welcome");
			getInt();
			int z = x/y;
		} catch(ArithmeticException | NumberFormatException e) {e.printStackTrace();}
		finally
		{
			System.out.println("Closing up memory resources. 'Finally' block will be executed"
					+ "whether exception is thrown or not.");
		}
		System.out.print("Continue working");
		
	}
	
	private static void getInt()
	{
		int u = Integer.parseInt("xyz");
	}
}