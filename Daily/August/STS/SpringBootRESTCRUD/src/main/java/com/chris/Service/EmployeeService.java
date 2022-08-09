/*August 5, 2022*/

package com.chris.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.Model.Employee;
import com.chris.Repo.EmployeeRepository;

@Service
public class EmployeeService
{
	@Autowired
	EmployeeRepository repo; // HAS A

	public List<Employee> getAllEmps()
	{
		return repo.findAll();
	}

	public Optional<Employee> getEmpById(int id)
	{
		return repo.findById(id);
	}

	public void deleteEmp(Integer id)
	{
		repo.deleteById(id);
	}

	public void addEmp(Employee emp)
	{
		repo.save(emp);
	}
}
