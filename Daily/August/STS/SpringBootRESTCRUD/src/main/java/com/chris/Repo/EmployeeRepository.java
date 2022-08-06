package com.chris.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chris.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	
}
