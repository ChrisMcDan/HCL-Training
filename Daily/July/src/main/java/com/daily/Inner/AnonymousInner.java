//July 22, 2022

package com.daily.Inner;

interface Product
{
	void getAllProducts();
}

public class AnonymousInner
{

	public static void main(String[] args)
	{
		Product p = new Product()
		{
			public void getAllProducts()
			{
				System.out.println("All products are being displayed");
			}
		};
		p.getAllProducts();
	}
}