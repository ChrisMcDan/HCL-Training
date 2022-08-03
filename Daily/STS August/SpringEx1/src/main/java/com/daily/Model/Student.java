/* August 3, 2022 */

package com.daily.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student
{
	private int id;
	private String name;
	private String address;
	private Address addr;	// HAS A -> aggregation -> loose coupling.

	public void call()
	{
		System.out.println("Student ID: " + id + ", Student Name: " + name + ", Student Address: " + address);
	}
	
	public void display()
	{
		System.out.println(addr);
	}
}