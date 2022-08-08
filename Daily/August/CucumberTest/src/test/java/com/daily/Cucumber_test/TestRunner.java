/*August 8, 2022*/

package com.daily.Cucumber_test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Discount.feature",
format = { "pretty", "json:target/discount.json" })
public class TestRunner
{
	
}