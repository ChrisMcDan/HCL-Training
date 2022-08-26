package com.daily.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChrisController
{
	@GetMapping("/")
	public String getDocker()
	{
		return "Welcome to docker!";
	}
}