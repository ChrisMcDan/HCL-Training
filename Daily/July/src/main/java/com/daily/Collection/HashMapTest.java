/*7-25-2022*/

package com.daily.Collection;

//import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest
{
	/*
	 * When you use a HashMap it will throw ConcurrentModificationException.
	 * But, if you replace 'HashMap' with 'ConcurrentHashMap', then it will both read
	 * and write operations simultaneously.
	 * Java Collection are fail-fast.
	 */
	
	public static void main(String[] args)
	{
		Map<String, String> map = new ConcurrentHashMap<>();
		
		map.put("1",  "1");
		map.put("2",  "2");
		map.put("3",  "3");
		
		Iterator<String> itr = map.keySet().iterator();
		
		while(itr.hasNext())
		{
			String key = itr.next();
			System.out.println("Map Value: " + map.get(key));
			
			if(key.equals("2"))
			{
				map.put("4", "4");
			}
		}
	}
}