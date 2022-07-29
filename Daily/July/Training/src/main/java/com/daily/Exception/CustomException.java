/*July 21, 2022*/

package com.daily.Exception;

@SuppressWarnings("serial")	//Added this line in to get rid of notification.
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