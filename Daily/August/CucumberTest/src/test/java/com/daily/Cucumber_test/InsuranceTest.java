package com.daily.Cucumber_test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InsuranceTest
{
	Calculations c = new Calculations();

	@Given("^Customer \"([^\"]*)\" signs up$")
	public void customer_signs_up(String arg1) throws Throwable
	{
		c.customerName(arg1);
		// throw new PendingException();
	}

	@When("^If customer age (\\d+) is greater than (\\d+), apply discount (\\d+)$")
	public void if_customer_age_is_greater_than_apply_discount(int arg1, int arg2, int arg3) throws Throwable
	{
		if (arg1 > arg2)
		{
			c.addDiscount(arg3);
		}
		// throw new PendingException();
	}

	@When("^If customer has no crashes \"([^\"]*)\",apply discount (\\d+)$")
	public void if_customer_has_no_crashes_apply_discount(String arg1, int arg2) throws Throwable
	{
		if (arg1.matches("True|true|T|t|Yes|yes|Y|y"))
		{
			c.addDiscount(arg2);
		}
		// throw new PendingException();
	}

	@When("^If customers credit score (\\d+) is greater than (\\d+),apply discount (\\d+)$")
	public void if_customers_credit_score_is_greater_than_apply_discount(int arg1, int arg2, int arg3) throws Throwable
	{
		if (arg1 > arg2)
		{
			c.addDiscount(arg3);
		}
		// throw new PendingException();
	}

	@Then("^Display     total discount$")
	public void display_total_discount() throws Throwable
	{
		c.getFinalDetails();
		// throw new PendingException();
	}

}