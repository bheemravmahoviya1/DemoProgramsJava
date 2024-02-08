package com.demo.programs.collection.queue;

import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.demo.programs.collection.source.DataSourceBooks;

public class QueueSimpleTest {
	
  public static void main(String[] args) {
		Queue<String> priorityQueue=DataSourceBooks.BOOKS_QUEUE;
		Queue<String>  list=new LinkedList<>();
	
		retriveOperation(priorityQueue);
		addOpeartion(priorityQueue);
		
		/**
		 * 
		 * 
		 * */
		
		
		
		
		
		priorityQueue.remove();
		System.out.println("priorityQueue after Remove : "+priorityQueue);
}
  
	/* 
	 * Retrieve operation from Queue
	 * @param		priorityQueue		Will give list of queue
	 * */
  	public static void retriveOperation(Queue<String> priorityQueue) {
  		System.out.println("priorityQueue : "+priorityQueue);
		System.out.println("retreiveing head element by peek method : "+priorityQueue.peek());
		System.out.println("priorityQueue after peek : "+priorityQueue);
		System.out.println("retreiveing head element by poll method : : "+priorityQueue.poll());
		System.out.println("priorityQueue after poll : "+priorityQueue);
  	}
  	
  	public static void addOpeartion(Queue<String> priorityQueue) {
  		System.out.println("Is 'TEST' add to priorityQueue? : "+priorityQueue.offer("TEST"));
		System.out.println("priorityQueue after add 'TEST' : "+priorityQueue);
  	}
}
