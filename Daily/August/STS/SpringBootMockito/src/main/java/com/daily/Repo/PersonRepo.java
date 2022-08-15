/*August 15, 2022*/

package com.daily.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daily.Model.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>
{
	@Query("select case when count(p) > 0 then true else false end from Person p where p.prID = ?1")
	boolean isPersonExistsById(Integer id);
}