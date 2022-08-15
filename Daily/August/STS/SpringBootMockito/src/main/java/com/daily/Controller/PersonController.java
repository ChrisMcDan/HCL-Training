/*August 15, 2022*/

package com.daily.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daily.Service.PersonService;

@RestController
public class PersonController
{
	@Autowired
	private PersonService service;

	@GetMapping("/person")
	public ResponseEntity<?> getAllPerson()
	{
		return ResponseEntity.ok(this.service.getAllPerson());
	}
}