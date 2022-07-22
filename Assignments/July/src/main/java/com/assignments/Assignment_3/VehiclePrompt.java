/* 07-21-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 3.4****
 * Create a Vehicle having following attributes: Vehicle no, Model manufacturer and color.
 * Create truck which has following additional attributes: loadingCapacity (100 tons).
 * Add a behavior to change the color and loadingCapacity. Display the updated truck details.
 */

package com.assignments.Assignment_3;

class Vehicle
{
	int vehicleNo;
	String model;
	String manufacturer;
	String color = "Black";
}

class Truck extends Vehicle
{
	int loadingCapacity = 100;	//In tons.
	
	public void changeCandL()
	{
		String nColor = "White";
		int newCap = 300;
		
		this.color = nColor;
		this.loadingCapacity = newCap;
		
		System.out.println("New Color: " + nColor);
		System.out.println("New Loading Capacity: " + newCap);
	}
}

public abstract class VehiclePrompt
{
	public static void main(String[] args)
	{
		Truck t = new Truck();
		t.changeCandL();
	}
}