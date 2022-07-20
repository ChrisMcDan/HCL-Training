package com.hcl;

public class Static {	// Keyword is static (java is case sensitive
    
	/*static*/ int y = 0;	// Will get memory only once and retains its value
    
	Static(){
        y++;//0
        System.out.println(y);//1

    }
	
    public static void main(String[] args) {
        Static s1 = new Static(); // 1	/*static 1*/
        Static s2 = new Static(); // 1	/*static 2*/
        Static s3 = new Static(); // 1	/*static 3*/

    }
}