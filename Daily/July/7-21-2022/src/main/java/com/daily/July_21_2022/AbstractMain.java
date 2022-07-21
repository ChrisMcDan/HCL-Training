package com.daily.July_21_2022;

abstract class Generic
{
	public abstract int discount(int x);
	public void print()
	{
		System.out.println("Any message");
	}
}

class Costco extends Generic
{
	@Override
	public int discount(int x)
	{
		return 1;
	}
}

class Walmart extends Generic
{
	@Override
	public int discount(int x)
	{
		return 2;
	}
}

public class AbstractMain
{
	public static void main(String[] args)
	{
		Costco c1 = new Costco();
		c1.discount(1);
		c1.print();
	}

}