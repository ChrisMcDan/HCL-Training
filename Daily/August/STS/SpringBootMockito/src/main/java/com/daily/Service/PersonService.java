/*August 15, 2022*/

package com.daily.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.Model.Person;
import com.daily.Repo.PersonRepo;

@Service
public class PersonService
{
	@Autowired
	private PersonRepo repo;

	public List<Person> getAllPerson()
	{
		return repo.findAll();
	}

	public PersonService(PersonRepo repo)
	{
		this.repo = repo;
	}
}