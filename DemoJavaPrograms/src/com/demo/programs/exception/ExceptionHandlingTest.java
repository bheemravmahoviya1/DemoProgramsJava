package com.demo.programs.exception;

public class ExceptionHandlingTest {
	



	
	public static void main(String[] args) {
		//checkedExceptionHandling();
		//uncheckedExceptionHandling();
		//finallyBlockTesting();
		exceptionWithMethodOverriding();
	}
	
	
	private static void exceptionWithMethodOverriding() {
		MyExceptionHandling myExceptionHandling = new MyExceptionHandling();
		/**
		 * Note: when caller method throw checked exception then either need to handle it or calling method will re-throw it.  
		 * 
		 * */
		printMsg("Checked Exceptions");
		try {
			myExceptionHandling.checkedExceptionM1();
		}catch (Exception e) {
			
		}
		
		printMsg("Unchecked Exceptions");		
		/**
		 * Note: when caller method throw unchecked exception then exception handling is optional.  
		 * 
		 * */
		myExceptionHandling.uncheckedExceptionM1();
		
	}
	 
		/**
		 * Note: Finally block is mandatory block and it will be execute all the time even the exception will occures or not. 
		 *       If you have return value from try, catch and finally block then you will get always finally block value. 
		 */
		private static void finallyBlockTesting() {
			int val = finallyBlockM1(1);
			System.out.println("return value: "+val);
		}
	
	
		/**
		 * Note: If your calling method is throwing the any predefine or custom checked exception then it is mandatory to 
		 *       handle it or throw it to it's caller so he can handle it. Mean it will force you to handle that exception.  
		 * */
		private static void checkedExceptionHandling() {
			try {
				System.out.println("checkedExceptionHanlding start");
				checkedExceptionWithTryBlock();
			} catch (MyCheckedException e) {
			
				e.printStackTrace();
			}
			System.out.println("checkedExceptionHanlding end");
		}
	
	   /**
		 * Note: If your calling method is throwing the any predefine or custom unchecked exception then it is not mandatory to 
		 *       handle it or throw it to it's caller. Mean it will not force you to handle that exception.  
		 * */
		private static void uncheckedExceptionHandling() {
				System.out.println("uncheckedExceptionHanlding start");
				uncheckedExceptionWithoutTryBlock();
			    System.out.println("uncheckedExceptionHanlding end");
		}
			
	    private static void checkedExceptionWithTryBlock() throws MyCheckedException{
			System.out.println("I don't have any code.");
		}
	  
	 
	    private static void uncheckedExceptionWithoutTryBlock() throws MyUnCheckedException{
			System.out.println("I don't have any code.");
		}
	

	@SuppressWarnings("finally")
	private static int finallyBlockM1(int d) {
		
		try {
			System.out.println("try block start");
			int x=0/d;
			System.out.println("try block end");
			return 1;
		}catch (Exception e) {
			System.out.println("catch block");
			return 2;
		}finally {
			System.out.println("finally block");
			return 3;
		}
	}
	
	
	private static void printMsg(String msg) {
		System.out.println();
		System.out.println("------------------------- "+msg+" -------------------------");
		System.out.println();
	}
}


interface ExceptionHandling{
		public void checkedExceptionM1() throws MyCheckedException;
		public void uncheckedExceptionM1() throws MyUnCheckedException ;
}


class MyExceptionHandling implements ExceptionHandling{
	
	/**
	 *   
	 * Note: overridden method is throwing unchecked exception then we can not change it to checked exception.
	 *       overridden method is throwing MyUnCheckedException exception and we can change it to the it's super exception class RuntimeException
	 *       overridden method is throwing MyUnCheckedException exception and we can change it to the it's sub exception class MyChildUnCheckedException       
	 * */
	@Override
	public void uncheckedExceptionM1() throws MyChildUnCheckedException {
		System.out.println("uncheckedExceptionM1(-) can throws MyUnCheckedException");
		System.out.println("uncheckedExceptionM1(-) can throws RuntimeException");
		System.out.println("uncheckedExceptionM1(-) can throws MyChildUnCheckedException");
		System.out.println("uncheckedExceptionM1(-) #### unchecked exception can not convert to checked exception ####");
		
	}

	/**
	 *   
	 * Note: overridden method is throwing checked exception then we can change it to any unchecked exception.
	 *       overridden method is throwing MyUnCheckedException exception and we can not change it to the it's super exception class Exception
	 *       overridden method is throwing MyUnCheckedException exception and we can change it to the it's sub exception class MyChildCheckedException      
	 * */
	@Override
	public void checkedExceptionM1() throws MyChildUnCheckedException {
		System.out.println("checkedExceptionM1(-) can throws same exception MyCheckedException");
		System.out.println("checkedExceptionM1(-) can throws child class checked exception MyChildCheckedException");
		System.out.println("checkedExceptionM1(-) can throws any unchecked exception");
		System.out.println("checkedExceptionM1(-) #### MyCheckedException can not convert super class exception like Exception or it's sub classes  ####");
		
	}	
}





class MyCheckedException extends Exception{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4771202846652980699L;

	public MyCheckedException(String msg) {
		super(msg);
	}
	
}

class MyChildCheckedException extends MyCheckedException{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4771202846652980699L;

	public MyChildCheckedException(String msg) {
		super(msg);
	}
	
}


class MyUnCheckedException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1933864680591584827L;

	public MyUnCheckedException(String msg) {
		super(msg);
	}
}

class MyChildUnCheckedException extends MyUnCheckedException{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4697273968735207741L;

	public MyChildUnCheckedException(String msg) {
		super(msg);
	}
}
