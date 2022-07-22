//July 20, 2022

package com.daily.OOPS;

public class Vehicle
{
    int vid;
    String vname;

    Vehicle()
    {
        System.out.println(" Constructor is created");
    }
    
    Vehicle(int vid,String vname)
    {
        this.vid = vid;
        this.vname = vname;
        System.out.println(vid + "" + vname);
    }

    public static void main(String[] args)
    {
        @SuppressWarnings("unused")	//Added this line in to get rid of notification.
		Vehicle c = new Vehicle();
        @SuppressWarnings("unused")	//Added this line in to get rid of notification.
		Vehicle c1 = new Vehicle(12,"Bentley");
    }
}