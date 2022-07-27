/*July 26, 2022*/

package com.Java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LambdaEx1
{
	public static void main(String[] args)
	{
		List<String> names = Arrays.asList("Vijaya", "Justin", "David", "Chris");
		
		//Java 7
		Collections.sort(names, new Comparator<String>()
		{
			public int compare(String a, String b)
			{
				return b.compareTo(a);
			}
		});
		
		//Java 8 with data-types.
		Collections.sort(names, (String a, String b) ->
		{
			return b.compareTo(a);
		});
		
		//Java 8 without data-types.
		Collections.sort(names, (a, b) ->
		{
			return b.compareTo(a);
		});
		
		System.out.println(names);
		
		List<String> names2 = Arrays.asList("Vijaya", null, "Justin", "David", "Chris");
		
		names2.sort(Comparator.nullsLast(String::compareTo));	//:: method reference.
		System.out.println(names2);
		

		List<String> names3 = null;
		//Optional is used to handle null pointer exceptions
		Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));
		System.out.println(names3);
	}
}
