//July 20, 2022

package com.daily.Basic;

public class Static	// Keyword is static (Java is case sensitive).
{
    
	/*static*/ int y = 0;	// Will get memory only once and retains its value
    
	Static()
	{
        y++;	//0
        System.out.println(y);	//1
    }
	
    public static void main(String[] args)
    {    	
        @SuppressWarnings("unused")	//Added this line in to get rid of notification.
		Static s1 = new Static(); // 1	/*static 1*/
        
        @SuppressWarnings("unused")	//Added this line in to get rid of notification.
		Static s2 = new Static(); // 1	/*static 2*/
        
        @SuppressWarnings("unused")	//Added this line in to get rid of notification.
		Static s3 = new Static(); // 1	/*static 3*/
    }
}