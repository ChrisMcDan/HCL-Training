/*August 11, 2022*/

package com.daily.Service;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Value("${name}") // This value will be captured from application.properties
	private String name;

	public String getHelloMessage()
	{
		LOGGER.info("Name registered {}", name);
		return "Welcome " + name;
	}
}