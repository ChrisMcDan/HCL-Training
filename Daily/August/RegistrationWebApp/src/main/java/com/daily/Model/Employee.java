/*August 2, 2022*/

package com.daily.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//MODEL->POJO and your business logic

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee
{
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String address;
	private String contact;
}