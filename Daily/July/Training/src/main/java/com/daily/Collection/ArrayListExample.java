/*July 22, 2022*/

package com.daily.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample
{
	/*
	 *Creates a dynamic array; stores the duplicate elements of different data-types, maintains insertion order
	 *Non-synchronized.
	 *When you retrieve the values it will be faster.
	 *But, when you do manipulation(insert, delete, and update) it will be slower.
	 */
	
	public static void main(String[] args)
	{
		//Generics -> making sure that it is type safe.
		List<String> list1 = new ArrayList<>();	//Runtime polymorphism.
		
		list1.add("Justin");
		list1.add(new String("Chris"));
		list1.add("Rachid");
		
		Iterator<String> itr = list1.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		list1.remove("Dummy");
		
		System.out.println(list1);
		System.out.println(list1.contains("Chrs"));
	}

}
