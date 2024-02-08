package com.demo.programs.java8;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.demo.programs.collection.source.ConstantEmp;
import com.demo.programs.collection.source.DataSourceBooks;
import com.demo.programs.collection.source.DataSourceEmployee;
import com.demo.programs.collection.source.Employee;

public class FuctionalProgramming {
	public static void main(String[] args) {
		//consumerTest();
		//predicateTest();
		//functionTest();
		supplierTest();
	}
	
	
	/**
	 * It is one of type function which don't take input and just return output.
	 * 
	 * */
	public static void supplierTest() {
		Supplier<List<Employee>>  empList = () -> DataSourceEmployee.getEmployeeList();
		empList.get().stream().forEach(System.out::println);
	}

	/**
	 * Note: Function is also a functional interface which take input and post processing return the value.
	 *       it is just like other functions but good thing is here it working in side of method.
	 *       mean you don't need to create a function at instant level now you can create local function also like local variable which 
	 *       have method body scope.
	 */
	public static void functionTest() {
		Function<Employee, String>   employeeNameFunc = emp -> emp.getFullName();
		Function<Employee, String>   employeeLocationFunc = emp -> emp.getLocation();
		// It returns the name of employee using our custom Function
		DataSourceEmployee.getEmployeeList().stream().map(employeeNameFunc).forEach(System.out::println);
		
		System.out.println("__________________after customer name function_________________________");
		Function<String, String> employeeFirstCharFunc = name -> ""+name.charAt(0);
		Function<String, String>  namePrefixLower = name -> name.toLowerCase();
		Function<String, String> finalFunction = employeeFirstCharFunc.andThen(namePrefixLower);
		DataSourceEmployee.getEmployeeList().stream().map(employeeNameFunc.andThen(finalFunction)).forEach(System.out::println);
		
		System.out.println("__________________after customer name function and andThen _________________________");
		
		//Function<String, String> firstCompose = employeeNameFunc.compose(employeeLocationFunc).compose(namePrefixLower);
	}
	
	
	/**
	 * Note: Please go throw the all methods of Predict interface and understand the use case of each method as 
	 *  	 each method is very helpful in real time development.
	 */
	public static void predicateTest() {
	Predicate<Employee>  salaryPredicate = employee -> employee.getSalary() > 10;	
	Predicate<Employee>  locationPredicate = employee -> ConstantEmp.LOCATION.PUNE.name().equals(employee.getLocation());;
	DataSourceEmployee.getEmployeeList().stream().filter(salaryPredicate.and(locationPredicate)).forEach(emp -> System.out.println(emp));
	
	
	}
	
	
	/**
	 * Note: Consumer is also a functional interface which take input and processing it but don't return any value. 
	 * 
	 * */
	public static void consumerTest() {
		/*
		 * Note: we an only use list with consumer as type we define is single value. 
		 */
		Consumer<String> booksConsumer = (book) -> System.out.println(book);
		Consumer<String> booksUpperName = book -> System.out.println(book);
 		DataSourceBooks.BOOKS_LIST.forEach(booksConsumer);
		DataSourceBooks.BOOKS_LIST.forEach(booksConsumer.andThen(booksUpperName));
		
		/*
		 * Note: we can not use consumer with Map as map having two value key and 
		 * value so doing operation on map we need Bi consumer. 
		 * 
		 */
		BiConsumer<Integer, String> bookBiConsumer = (sNo,name) -> {
			System.out.println("Book No : "+sNo);
			System.out.println("Book Name : "+name);
		};
		DataSourceBooks.BOOKS_MAP.forEach(bookBiConsumer);
	}
	
}
