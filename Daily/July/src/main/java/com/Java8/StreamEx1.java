package com.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx1
{
	/*
	 * Stream -> sequence of object from a source (input from Collections or Arrays).
	 * Support -> aggregate operations (filter, map, reduce, find, match, etc.).
	 * Most of the stream operations are called as intermediate operations.
	 * stream() -> return the sequential stream.
	 * parallelStream() ->
	 */
	
	public static void main(String[] args)
	{
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		
		
		//Get the list of square the unique numbers.
		List<Integer> squareList = numbers.stream()
										  .map(s -> s * s)
										  .distinct()
										  .collect(Collectors.toList());
		System.out.println(squareList);
		
		
		//Wanted to reduce the size of a stream.
		//Generate a Random numbers -> wanted to limit only upto 20.
		Random r = new Random();
		r.ints().limit(2).forEach(System.out::println);
		
		
		//Parallel Stream. 
		List<String> list = Arrays.asList("abc", "", "bc", "efg", "", "abcd", "jdkl");
		//Count the empty string.
		long count = list.parallelStream()
						 .filter(s -> s.isEmpty())
						 .count();
		System.out.println(count);
		
		String[] arr = {"Welcome ", "To ", "Java!\n"};
		//Arrays.stream is used to get a sequential stream from the array passed as a parameter.
		//It returns a sequential stream.
		Stream<String> stream = Arrays.stream(arr);
		stream.forEach(System.out::print);

		//Stream.of method returns a sequential ordered stream() whose elements are specified as value.
		//Stream.of() it calls internally the Arrays.stream() method
		Stream<String> stream1 = Stream.of(arr);
		stream1.forEach(System.out::print);
		
		int arr1[] = {1, 2, 3, 4, 5};
		Stream<int[]> stream2 = Stream.of(arr1);
//		stream2.forEach(System.out::println);
		
		IntStream stream3 = Arrays.stream(arr1);
		stream3.forEach(System.out::println);
		
		IntStream stream4 = stream2.flatMapToInt(Arrays::stream);
		stream4.forEach(s -> System.out.print(s + ""));
		
		//Arrays.stream() method only works for primitive works.
		//Stream.of() method return genericStream of type T.
	}
}