/*August 8, 2022*/

package com.daily.Cucumber_test;

import org.junit.Assert;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DiscountServiceTest
{
	private DiscountService discountService = new DiscountService();
	private String percentage = "";

	@Given("^Execute DiscountService Business$")
	public void execute_DiscountService_Business() throws Throwable
	{
		// Write code here that turns the phrase above into concrete actions
//		throw new PendingException();
	}

	@When("^if i will enter (\\d+)$")
	public void if_i_will_enter(int arg1) throws Throwable
	{
		// Write code here that turns the phrase above into concrete actions

		percentage = discountService.getDiscount(arg1);

//		throw new PendingException();
	}

	@Then("^we should get ten percentage discount$")
	public void we_should_get_ten_percentage_discount() throws Throwable
	{
		// Write code here that turns the phrase above into concrete actions

		Assert.assertEquals("10%", percentage);

//		throw new PendingException();
	}

	@Then("^we should get fifteen percentage discount$")
	public void we_should_get_fifteen_percentage_discount() throws Throwable
	{
		// Write code here that turns the phrase above into concrete actions

		Assert.assertEquals("15%", percentage);

//		throw new PendingException();
	}

	@Then("^we shouldn't get any percentage$")
	public void we_shouldn_t_get_any_percentage() throws Throwable
	{
		// Write code here that turns the phrase above into concrete actions

		Assert.assertEquals("NA", percentage);

//		throw new PendingException();
	}
}
