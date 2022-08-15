/*August 15, 2022*/

package com.daily.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daily.Model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{

}