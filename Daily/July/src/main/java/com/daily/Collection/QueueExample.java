/*7-25-2022*/

package com.daily.Collection;

import java.util.PriorityQueue;

public class QueueExample
{
	public static void main(String[] args)
	{
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i = 10; i > 0; i--)
		{
			queue.add(i);
		}
		
		System.out.println(queue);
		System.out.println(queue.size());
		System.out.println(queue.peek());	//Head of the Queue: 1
		
		queue.poll();	//To remove the head: 1
		
		System.out.println(queue.peek());
		System.out.println(queue.size());

		System.out.println("The size of the queue is " + queue.size());
	}
}