package com.daily.July_21_2022;

public class CustomException extends Exception
{
	public CustomException(String s)
	{
		super(s);
	}
}

class Main
{
	public static void main(String[] args)
	{
		try
		{
			throw new CustomException("Exception");	//Single line explicitly.
		}catch(CustomException e) {System.out.println(e.getMessage());}
	}
}