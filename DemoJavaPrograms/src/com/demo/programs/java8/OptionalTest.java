package com.demo.programs.java8;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.demo.programs.collection.source.DataSourceEmployee;
import com.demo.programs.collection.source.Employee;

public class OptionalTest {
	  public static void main(String[] args) {
		  //createOptional();
		  //isValuePresent();
		  //ifPresentCases();
		  //filterData();
		  //transformingData();
		  
	}
	  
	  private static void transformingData() {
			 Optional<Employee> emp1 = DataSourceEmployee.getEmployeeOptionalEmptyEntity();
			 Optional<Employee> emp2 = DataSourceEmployee.getEmployeeOptionalEntity();
			 Function<Employee, String>  fullNameFunction = emp -> emp.getFullName();
			 Function<Employee, Optional<String>>  favouriteFunction = emp -> emp.getFavourite();
				
			printMsg("Get data from Optional<Employee> when not present in old way");
			if(emp1.isPresent()) {
				String fullName = emp1.get().getFullName();;
			
				System.out.println("fullName: "+fullName);
			}
			printMsg("Get data from Optional<Employee> when present in old way");
			if(emp2.isPresent()) {
				
				String fullName = emp2.get().getFullName();;
				System.out.println("fullName: "+fullName);
			}
			
			printMsg("Get data from Optional<Employee> when not present in new way using map(-) method");
			
			emp1.map(fullNameFunction).ifPresentOrElse(System.out::println, () -> {
				System.out.println("emp1 is empty");
			});
			printMsg("Get data from Optional<Employee> when present in new way using map(-) method");
	
			emp2.map(fullNameFunction).ifPresentOrElse(System.out::println, () -> {
				System.out.println("emp1 is empty");
			});
			

			printMsg("Get data from Optional<Employee> when not present in new way using flatMap(-) method");
			emp1.map(fullNameFunction).ifPresentOrElse(System.out::println, () -> {
				System.out.println("emp1 is empty");
			});
			printMsg("Get data from Optional<Employee> when present in new way using flatMap(-) method");
	
			emp2.map(fullNameFunction).ifPresentOrElse(System.out::println, () -> {
				System.out.println("emp1 is empty");
			});
			 printMsg(" Different between Optional.map(-) and Optional.flatMapt(-) for understaning");
			 System.out.println( emp2.map(favouriteFunction));
			 System.out.println( emp2.flatMap(favouriteFunction));
	  }
	  
	 private static void createOptional() {
		 Optional<String>  myFirstOptional = Optional.empty();
		 Optional<String>  mySecondOptional = Optional.of("Bheemrav");
		 Optional<String>  myThirdOptional = Optional.ofNullable(null);
		 System.out.println("myFirstOptional: "+myFirstOptional);
		 System.out.println("mySecondOptional: "+mySecondOptional);
		 System.out.println("myThirdOptional: "+myThirdOptional);
		 
	 }
	 
	 
	 private static void isValuePresent() {
		 System.out.println("Is entity present ? "+		 DataSourceEmployee.getEmployeeOptionalEntity().isPresent());
		 System.out.println("Is entity empty ? "+		 DataSourceEmployee.getEmployeeOptionalEntity().isEmpty());
	 }
	 
	 private static void ifPresentCases() {
		 Optional<Employee>  emp1 = DataSourceEmployee.getEmployeeOptionalEmptyEntity();
		 Optional<Employee>  emp2 = DataSourceEmployee.getEmployeeOptionalEntity();
		 Consumer<Employee>  printEmployee = emp -> System.out.println(emp);
		 printMsg("When value is not present using ifPresent(-) method.");
		 emp1.ifPresent(printEmployee);
		 printMsg("When value is present using ifPresent(-) method .");
		 emp2.ifPresent(printEmployee);
		 
		 printMsg("When value is not present using ifPresent(-) method.");
		 emp1.ifPresentOrElse(printEmployee,() -> {
			 System.out.println("value not present in emp1.");
		 });
		 printMsg("When value is present using ifPresent(-) method .");
		 emp2.ifPresentOrElse(printEmployee,() -> {
			 System.out.println("value not present in emp2.");			 
		 });
		 
	 }
	 
	 private static void filterData() {
		 Optional<Employee>  emp1 = DataSourceEmployee.getEmployeeOptionalEmptyEntity();
		 Optional<Employee>  emp2 = DataSourceEmployee.getEmployeeOptionalEntity();
		 Predicate<Employee> isEmployeeWith1001Id = emp ->  {
			 return emp.getEmpId()== 1000 ? true : false;};
		
		 printMsg("When value is not present using filter(-) method.");
		 System.out.println(emp1.filter(isEmployeeWith1001Id));
		 
		 //You can give any condition with the help of predicate.
		 printMsg("When value is present using filter(-) method.");
		 System.out.println(emp2.filter(isEmployeeWith1001Id));
	 }
	 
	 
	private static void printMsg(String msg) {
			System.out.println();
			System.out.println("------------------------- "+msg+" -------------------------");
			System.out.println();
   }
	
	
}
