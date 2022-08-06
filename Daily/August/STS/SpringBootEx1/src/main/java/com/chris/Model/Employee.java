/*August 5, 2022*/

package com.chris.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Employee
{
	private int eid;
	private String ename;
	
	@Autowired
	private Department department;
	
	public void showEmployeeDetails()
	{
		System.out.println("Employee ID: " + eid);
		System.out.println("Employee Name: " + ename);
		department.setDeptName("Information Technology");;
		System.out.println("Department: " + department.getDeptName());
	}
}
