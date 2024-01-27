package com.demo.programs.memory.stack;

public class StackMemoryTest {
	 
	public static void main(String[] args) {
		testOutOfMemoryError();
	}
	
	
	public static void  testOutOfMemoryError() {
		System.out.println("testOutOfMemoryError.testOutOfMemoryError(-)    START");
		try{
			Thread thread =Thread.currentThread();	
			 StackTraceElement[]  values =	thread.getStackTrace();
			 
			for(StackTraceElement element: values) {
				System.out.println("StackTraceElement -> "+element.toString());
			}
		}catch (Error e) {

		}
		System.out.println("testOutOfMemoryError.testOutOfMemoryError(-)    END");
	}
}
