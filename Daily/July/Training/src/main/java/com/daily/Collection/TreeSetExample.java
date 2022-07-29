/*July 25, 2022*/

package com.daily.Collection;

//import java.util.Collections;
//import java.util.Iterator;
//import java.util.Set;
import java.util.TreeSet;

/*
 * TreeSet -> contains unique elements.
 * Retrieval times are fast.
 * Doesn't allow null elements.
 * Not a thread safe (not synchronized).
 * Maintains the ascending order.
 */

public class TreeSetExample
{
	public static void main(String[] args)
	{
		TreeSet<String> set = new TreeSet<>();
		
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		set.add("E");
		
//		set.forEach(System.out::println);
//
//		Iterator<String> itr = set.descendingIterator();
//		
//		while(itr.hasNext())
//		{
//			System.out.println(itr.next());
//		}
//		
//		System.out.println("Lowest Value: " + set.pollFirst());
//		System.out.println("Highest Value: " + set.pollLast());
		System.out.println("Initial Set: " + set);
		System.out.println("Reverse the Set: " + set.descendingSet());
		System.out.println("Head set: " + set.headSet("C", true));	//Prints only A, B < C
		System.out.println("Sub set: " + set.subSet("A", false, "E", true));
		
		System.out.println("Tail Set: " + set.tailSet("C", false));
	}

}
