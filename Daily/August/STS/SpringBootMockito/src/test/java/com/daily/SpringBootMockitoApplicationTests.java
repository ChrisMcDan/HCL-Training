/*August 15, 2022*/

package com.daily;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.daily.Model.Person;
import com.daily.Repo.PersonRepo;

@SpringBootTest
class SpringBootMockitoApplicationTests
{
	@Autowired
	private PersonRepo repo;

	@Test
	void toCheckPersonExists()
	{
		Person p = new Person(1, "Chris", "Hutto");
		repo.save(p);
		boolean b = repo.isPersonExistsById(1);
		assertThat(b).isTrue();
	}
}