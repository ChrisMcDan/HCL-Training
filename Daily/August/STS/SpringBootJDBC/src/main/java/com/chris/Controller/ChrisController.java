package com.chris.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChrisController
{
	@Autowired
	JdbcTemplate jdbc;
	@GetMapping("/insert")
	public String index()
	{
		jdbc.execute("INSERT INTO user(name, email) VALUES('Chris', 'chrismcdan97@gmail.com')");
		return 
	}
}
