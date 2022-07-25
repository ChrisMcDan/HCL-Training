/*7-25-2022*/

package com.daily.Collection;

import java.util.HashMap;
import java.util.Map;

public class MapExample
{
	//Map is not a part of Collection.
	/*Real time use case -> Lets say in an organization we have a lot of employees,
	 * if we want to find the details of employees (I have multiple names, Brandon)
	 * with the help of ID's (ID must be unique).
	 * Map stores key value pairs
	 * ID = 1,  name = Brandon
	 * ID = 23,  name = Brandon
	 * Map doesn't allow primitive data types.
	 * HashMap does allow one null key and many number of null values.
	 */
	public static void main(String[] args)
	{
		Map<Integer, String> map = new HashMap<>();
		
		map.put(121, "Brandon");
		map.put(122, "Chris");
		map.put(123, "Rachid");
		map.put(124, "Vijaya");
		map.put(125, "Claudio");
		
		System.out.println(map);
		System.out.println(map.get(123));
		System.out.println(map.containsKey(123));
		System.out.println(map.containsValue("Claudi"));
		
		map.put(124, "Saran");

		System.out.println(map);
		
		map.replace(123, "Gaurav");

		System.out.println(map);
		
		map.putIfAbsent(126, "Ajay");

		System.out.println(map);
	}
}