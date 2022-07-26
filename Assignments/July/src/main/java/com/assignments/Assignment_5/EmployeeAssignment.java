/* 07-25-2022
 * Christopher McDaniel
 * christopher.mcdaniel@hcl.com
 * 
 * ****ASSIGNMENT 5****
 * Create a class, Employee, while the properties of an Employee are id, name, age, gender, dept, yearofjoining, and salary.
 * Based on the above context:
 * Based on the questions try to create hard coded data; using only java 8 features.
 */

package com.assignments.Assignment_5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee
{
	private int empID;	//Employee ID.
	private int empAge;	//Employee Age.
	private int empYrJoin;	//Employee Year of Joining.
	private double empSalary;	//Employee Salary.

	private String empName;	//Employee Name.
	private String empGender;	//Employee Gender.
	private String empDept;	//Employee Department.
}

public class EmployeeAssignment
{

	public static void main(String[] args)
	{
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee(101, 23, 2020, 60000, "Ferris Bueller", "Male", "Maintenance"));
		list.add(new Employee(102, 35, 2002, 75000, "Neo", "Male", "IT"));
		list.add(new Employee(103, 68, 1985, 150000, "Frodo Baggins", "Male", "Maintenance"));
		list.add(new Employee(104, 37, 2018, 90000, "Gal Gadot", "Female", "IT"));
		list.add(new Employee(105, 77, 1995, 200000, "Jane Doe", "Female", "IT"));
		list.add(new Employee(106, 24, 2018, 70000, "Janice", "Female", "Maintenance"));
		list.add(new Employee(107, 27, 2016, 80000, "Jenny", "Female", "Maintenance"));
		
		
		
		/**********1. How many male and female employees are there in this organization?**********/
		Map<String, Long> numGender = list.stream().collect(Collectors.groupingBy(Employee::getEmpGender, Collectors.counting()));
		
		System.out.println("----------------Question 1----------------");
		
		System.out.println("Number of each Gender: " + numGender);
		
		
		
		/**********2. Find out Average age of male and female employees?**********/
		Map<String, Double> avgAge = list.stream().collect(Collectors.groupingBy(Employee::getEmpGender, Collectors.averagingInt(Employee::getEmpAge)));

		System.out.println("\n----------------Question 2----------------");
		
		System.out.println("Average age of employees: " + avgAge);
		
		
		
		/**********3. Find the highest paid employee in this organization?**********/
		Optional<Employee> highestPay = list.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getEmpSalary)));

		Employee highest = highestPay.get();

		System.out.println("\n----------------Question 3----------------");
		
		System.out.println("The highest paid employee is: " + highest.getEmpName() + ", ID: " + highest.getEmpID());
		
		
		
		/**********4. List all the names of employees who have joined after 2015?**********/
		Map<String, List<Employee>> joinAfter = list.stream().filter(emp -> emp.getEmpYrJoin() > 2015).collect(Collectors.groupingBy(Employee::getEmpName));

		System.out.println("\n----------------Question 4----------------");
		
		joinAfter.forEach((empName, year) -> System.out.println("Joined after 2015: " + empName));
		
		
		
		/**********5. Find out the senior most employee in this organization?**********/
		Optional<Employee> seniorEmployee = list.stream().sorted(Comparator.comparingInt(Employee::getEmpYrJoin)).findFirst();
		
		Employee longest = seniorEmployee.get();

		System.out.println("\n----------------Question 5----------------");
		
		System.out.println("The Employee who's been here the longest is: " + longest.getEmpName() + ", ID: " + highest.getEmpID());
		
		
		
		/**********6. Count the number of employees in each department?**********/
		Map<String, Long> eachDept = list.stream().collect(Collectors.groupingBy(Employee::getEmpDept, Collectors.counting()));

		System.out.println("\n----------------Question 6----------------");
		
		eachDept.forEach((empDept, empCount) -> System.out.println(empDept + " has " + empCount + " employees."));
		
		
		
		/**********7. Find which male and female employees are in the Maintenance department?**********/
		Map<String, List<Employee>> empMaint = list.stream().filter(emp -> emp.getEmpDept() == "Maintenance").collect(Collectors.groupingBy(Employee::getEmpName));

		System.out.println("\n----------------Question 7----------------");
		
		empMaint.forEach((empName, department) ->  System.out.println(empName + " is in Maintenance."));
		
		
		
		/**********8. Find the average salary of male and female employees?**********/
		Map<String, Double> empAvg = list.stream().collect(Collectors.groupingBy(Employee::getEmpGender,Collectors.averagingDouble(Employee::getEmpSalary)));

		System.out.println("\n----------------Question 8----------------");
		
		System.out.println("Average Salary is:" + empAvg);
		
		
		
		/**********9. Differentiate the employees who are younger or equal to 30 years from those employees who are older than 25 years?**********/
		Map<String, List<Employee>> diffAge1 = list.stream().filter(emp -> emp.getEmpAge() <= 30).collect(Collectors.groupingBy(Employee::getEmpName));
		Map<String, List<Employee>> diffAge2 = list.stream().filter(emp -> emp.getEmpAge() > 25).collect(Collectors.groupingBy(Employee::getEmpName));

		System.out.println("\n----------------Question 9----------------");
		
		System.out.println("Younger or equal to 30 years: ");
		diffAge1.forEach((empName, age) -> System.out.println(empName));
		
		System.out.println("\nOlder than 25 years: ");
		diffAge2.forEach((empName, age) -> System.out.println(empName));
		
		
		
		/**********10. List down the names of all employees in each department?**********/
		Map<String, List<Employee>> empEachDept = list.stream().collect(Collectors.groupingBy(Employee::getEmpDept));
		
		Set<Entry<String, List<Employee>>> entrySet = empEachDept.entrySet();

		System.out.println("\n----------------Question 10----------------");
		
		for(Entry<String, List<Employee>> entry : entrySet)
		{
			System.out.println("\nEmployees in " + entry.getKey() + ": ");
			
			List<Employee> deptList = entry.getValue();
			
			for(Employee emp : deptList)
			{
				System.out.println(emp.getEmpName());
			}
		}
	}
}