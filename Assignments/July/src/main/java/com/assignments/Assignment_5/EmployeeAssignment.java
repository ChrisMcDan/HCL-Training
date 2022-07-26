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

class Employee
{
	int empID;	//Employee ID.
	int empAge;	//Employee Age.
	int empYrJoin;	//Employee Year of Joining.
	double empSalary;	//Employee Salary.

	String empName;	//Employee Name.
	String empGender;	//Employee Gender.
	String empDept;	//Employee Department.
	
	public Employee(int empID, int empAge, int empYrJoin, double empSalary, String empName, String empGender, String empDept)
	{
		this.empID = empID;
		this.empAge = empAge;
		this.empYrJoin = empYrJoin;
		this.empSalary = empSalary;
		this.empName = empName;
		this.empGender = empGender;
		this.empDept = empDept;
	}
	
	public int getID()
	{
		return empID;
	}
	
	public int getAge()
	{
		return empAge;
	}
	
	public int getYrJoin()
	{
		return empYrJoin;
	}
	
	public double getSalary()
	{
		return empSalary;
	}
	
	public String getName()
	{
		return empName;
	}
	
	public String getGender()
	{
		return empGender;
	}
	
	public String getDept()
	{
		return empDept;
	}
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
		
		
		
		/**********1. How many male and female employees are there in this organization?**********/
		Map<String, Long> numGender = list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		
		System.out.println("----------------Question 1----------------");
		
		System.out.println("Number of each Gender: " + numGender);
		
		
		
		/**********2. Find out Average age of male and female employees?**********/
		Map<String, Double> avgAge = list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

		System.out.println("\n----------------Question 2----------------");
		
		System.out.println("Average age of employees: " + avgAge);
		
		
		
		/**********3. Find the highest paid employee in this organization?**********/
		Optional<Employee> highestPay = list.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

		Employee highest = highestPay.get();

		System.out.println("\n----------------Question 3----------------");
		
		System.out.println("The highest paid employee is: " + highest.getName() + ", ID: " + highest.getID());
		
		
		
		/**********4. List all the names of employees who have joined after 2015?**********/
		Map<String, List<Employee>> joinAfter = list.stream().filter(emp -> emp.getYrJoin() > 2015).collect(Collectors.groupingBy(Employee::getName));

		System.out.println("\n----------------Question 4----------------");
		
		joinAfter.forEach((empName, year) -> System.out.println("Joined after 2015: " + empName));
		
		
		
		/**********5. Find out the senior most employee in this organization?**********/
		Optional<Employee> seniorEmployee = list.stream().sorted(Comparator.comparingInt(Employee::getYrJoin)).findFirst();
		
		Employee longest = seniorEmployee.get();

		System.out.println("\n----------------Question 5----------------");
		
		System.out.println("The Employee who's been here the longest is: " + longest.getName() + ", ID: " + highest.getID());
		
		
		
		/**********6. Count the number of employees in each department?**********/
		Map<String, Long> eachDept = list.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));

		System.out.println("\n----------------Question 6----------------");
		
		eachDept.forEach((empDept, empCount) -> System.out.println(empDept + " has " + empCount + " employees."));
		
		
		
		/**********7. Find which male and female employees are in the Maintenance department?**********/
		Map<String, List<Employee>> empMaint = list.stream().filter(emp -> emp.getDept() == "Maintenance").collect(Collectors.groupingBy(Employee::getName));

		System.out.println("\n----------------Question 7----------------");
		
		empMaint.forEach((empName, department) ->  System.out.println(empName + " is in Maintenance."));
		
		
		
		/**********8. Find the average salary of male and female employees?**********/
		Map<String, Double> empAvg = list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));

		System.out.println("\n----------------Question 8----------------");
		
		System.out.println("Average Salary is:" + empAvg);
		
		
		
		/**********9. Differentiate the employees who are younger or equal to 30 years from those employees who are older than 25 years?**********/
		Map<String, List<Employee>> diffAge1 = list.stream().filter(emp -> emp.getAge() <= 30).collect(Collectors.groupingBy(Employee::getName));
		Map<String, List<Employee>> diffAge2 = list.stream().filter(emp -> emp.getAge() > 25).collect(Collectors.groupingBy(Employee::getName));

		System.out.println("\n----------------Question 9----------------");
		
		System.out.println("Younger or equal to 30 years: ");
		diffAge1.forEach((empName, age) -> System.out.println(empName));
		
		System.out.println("\nOlder than 25 years: ");
		diffAge2.forEach((empName, age) -> System.out.println(empName));
		
		
		
		/**********10. List down the names of all employees in each department?**********/
		Map<String, List<Employee>> empEachDept = list.stream().collect(Collectors.groupingBy(Employee::getDept));
		
		Set<Entry<String, List<Employee>>> entrySet = empEachDept.entrySet();

		System.out.println("\n----------------Question 10----------------");
		
		for(Entry<String, List<Employee>> entry : entrySet)
		{
			System.out.println("\nEmployees in " + entry.getKey() + ": ");
			
			List<Employee> deptList = entry.getValue();
			
			for(Employee emp : deptList)
			{
				System.out.println(emp.getName());
			}
		}
	}
}