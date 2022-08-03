/* August 3, 2022 */

package com.daily.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
	private int id;
	private String name;
	private List<String> address;
	
	public void print()
	{
		System.out.println("\nUser ID: " + id);
		System.out.println("User Name: " + name);
		System.out.println("List of addresses:");
		address.forEach(System.out::println);		
	}
}
