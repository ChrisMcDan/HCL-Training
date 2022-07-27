/*July 21, 2022*/

package com.daily.Exception;

import java.io.FileOutputStream;

public class TryWithResources
{
	public static void main(String[] args)
	{
		try(FileOutputStream fos = new FileOutputStream("Chris.txt"))
		{
			String txt = "Welcome to Output Streams in Java!";
			
			//Converts the string into a byte of array.
			byte arr[] = txt.getBytes();
			
			fos.write(arr);
		}catch(Exception e) {System.out.println(e);}
	}
}