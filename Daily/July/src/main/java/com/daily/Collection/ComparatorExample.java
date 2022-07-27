/*July 25, 2022*/

package com.daily.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Comparator -> java.util package and compare(Object1, Object2). (Compares 2 objects)
 * 		compare(Object1, Object2)
 * 		equals(Object)
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee
{
	int empId;
	String empName;
	int empAge;
}

class AgeComparator implements Comparator<Object>
{
	public int compare(Object o1, Object o2)
	{
		Employee e1 = (Employee)o1;
		Employee e2 = (Employee)o2;
		
		if(e1.empAge == e2.empAge)
		{
			return 0;
		}
		else if(e1.empAge > e2.empAge)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}

class NameComparator implements Comparator<Object>
{
	public int compare(Object o1, Object o2)
	{
		Employee e1 = (Employee)o1;
		Employee e2 = (Employee)o2;
		
		return e1.empName.compareTo(e2.empName);
	}
}

public class ComparatorExample
{
	public static void main(String[] args)
	{
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee(111, "Chris", 24));
		list.add(new Employee(222, "Dylan", 25));
		list.add(new Employee(333, "Ashley", 26));
		
		System.out.println("Sort by empName");
//		Collections.sort(list, new NameComparator());
//		list.forEach(System.out::println);	//Functional programming.
//		
//		System.out.println("\nSort by empAge");
//		Collections.sort(list, new AgeComparator());
//		list.forEach(System.out::println);	//Functional programming.
		
		Collections.sort(list, (o1, o2) -> (o1.getEmpName().compareTo(o2.getEmpName())));
	}
}