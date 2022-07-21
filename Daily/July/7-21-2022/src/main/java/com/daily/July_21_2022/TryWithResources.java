package com.daily.July_21_2022;

import java.io.FileOutputStream;

public class TryWithResources
{
	public static void main(String[] args)
	{
		try(FileOutputStream fos = new FileOutputStream("Chris.txt"))
		{
			String txt = "Welcome to Output Streams in Java!";
			byte arr[] = txt.getBytes();
			fos.write(arr);
		}catch(Exception e) {System.out.println(e);}
	}
}