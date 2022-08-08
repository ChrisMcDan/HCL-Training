package com.daily.Cucumber_test;

public class Calculations
{
	int totalDiscount = 0;
	String name = "";

	public void customerName(String name)
	{
		this.name = name;
	}

	public void addDiscount(int discount)
	{
		totalDiscount += discount;

	}

	public void getFinalDetails()
	{
		System.out.println("Customer " + name + "received a" + totalDiscount + "%discount");
	}

}