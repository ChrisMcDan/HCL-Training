/*August 4, 2022*/

package com.chris.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChrisController
{
	@GetMapping("/")	//Restful Endpoints.
	public String display()
	{
		return "Welcome to the world of Spring Boot!";
	}
}
