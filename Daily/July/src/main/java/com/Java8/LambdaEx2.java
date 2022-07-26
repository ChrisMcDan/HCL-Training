/*7-26-2022*/

package com.Java8;

public class LambdaEx2
{
	interface EmpFactory<E extends Emp>
	{
		E create(String empFirstName, String empLastName);
	}
	
	public static void main(String[] args)
	{
		EmpFactory<Emp> empFac = Emp::new;	//Constructor reference new Emp().
		Emp emp = empFac.create(" Chris", " McDaniel");
		System.out.println(emp);
		
	}

}
