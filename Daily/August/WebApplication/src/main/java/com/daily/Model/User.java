/*August 1, 2022*/

package com.daily.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//MODEL->POJO and your business logic

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
	private String username;
	private String password;

	public boolean validateUserNamePwd()
	{
		if (username.equals("test") && password.equals("123"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}