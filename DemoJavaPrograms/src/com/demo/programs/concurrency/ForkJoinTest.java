package com.demo.programs.concurrency;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {
	public static void main(String[] args) {
		   int nThreads = Runtime.getRuntime().availableProcessors();
		  System.out.println("nThreads presents: "+nThreads);
		  int [] inputData = new int[10];
		  for(int i=0 ; i <= inputData.length-1; i++) {
			  inputData[i]=i;
		  }
		 /* 
   		long startTime = System.currentTimeMillis();
   		long output = sequenceFlow(inputData, 0, inputData.length);
 		long endTime = System.currentTimeMillis();
 		System.out.println("output is : " + (output) );
 		System.out.println("Time took : " + (endTime-startTime) );
 		*/
 		System.out.println("----------------Fork Join Pool --------------");
 		
 		 ForkJoinPool forkJoinPool = new ForkJoinPool(nThreads);
 		 
 		ForkJoinPool forkJoinPoolCommon = ForkJoinPool.commonPool();
 		System.out.println(forkJoinPoolCommon);
 		long startTimeFork = System.currentTimeMillis();
 	     Long result = forkJoinPool.invoke(new Sum(inputData,0,inputData.length));
 	    long endTimeFork = System.currentTimeMillis();
 	   System.out.println("output from fork : " + (result) );
		System.out.println("Time took : " + (endTimeFork-startTimeFork) );
		  
	}
	
	
	
	private static long sequenceFlow(int[] inputData, int low, int high) {
		long sum = 0;
		 for(int i = low; i < high; ++i) 
             sum += inputData[i];
             return sum;
      
	}
	
	
	static class Sum extends RecursiveTask<Long> {
		  int low;
	      int high;
	      int[] array;

		  Sum(int[] array, int low, int high) {
		         this.array = array;
		         this.low   = low;
		         this.high  = high;
		   }

		@Override
		protected Long compute() {
			 if(high - low <= 3) {
		            long sum = 0;
		            
		            for(int i = low; i < high; ++i) 
		               sum += array[i];
		               return sum;
		         } else {	    	
		            int mid = low + (high - low) / 2;
		            Sum left  = new Sum(array, low, mid);
		            Sum right = new Sum(array, mid, high);
		            left.fork();
		            long rightResult = right.compute();
		            long leftResult  = left.join();
		            return leftResult + rightResult;
		         }
		}
		
		
	}
	
}
