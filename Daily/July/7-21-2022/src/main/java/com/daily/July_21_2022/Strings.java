package com.daily.July_21_2022;

public class Strings
{

	public static void main(String[] args)
	{
		String s1 = "Dylan";	//String is always immutable.
		String s2 = "Dylan";
//		s1 = "ABC";
		s1.concat("Chris");
		String s3 = new String("Dylan");
		String s4 = s3.intern();	//Store the string in the constant pool.
		
		// S1 and S2
		if(s1.equals(s2))
		{
			System.out.println(true);
		}
		else
		{
			System.out.println(false);
		}
		
		if(s1 == s2)
		{
			System.out.println(true);
		}
		else
		{
			System.out.println(false);
		}
		
		//S1 and S3
		if(s1.equals(s3))
		{
			System.out.println(true);
		}
		else
		{
			System.out.println(false);
		}
		
		if(s1 == s3)
		{
			System.out.println(true);
		}
		else
		{
			System.out.println(false);
		}
		
		//S1 and S4
		if(s1.equals(s4))
		{
			System.out.println(true);
		}
		else
		{
			System.out.println(false);
		}
		
		if(s1 == s4)
		{
			System.out.println(true);
		}
		else
		{
			System.out.println(false);
		}
	}

}
