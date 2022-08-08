/*August 8, 2022*/

package com.daily.Cucumber_test;

public class DiscountService
{
	//This code cannot be able to understand
	public String getDiscount(int amount)
	{
		String discountPercentage = "";
		if (amount > 5000 && amount < 10000)
		{
			discountPercentage = "10%";
		} else if (amount > 10000)
		{
			discountPercentage = "15%";
		} else
		{
			discountPercentage = "NA";
		}
		return discountPercentage;
	}
}
