package com.demo.programs.java8;


import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.demo.programs.collection.source.ConstantEmp;
import com.demo.programs.collection.source.ConstantEmp.Gender;
import com.demo.programs.collection.source.DataSourceEmployee;
import com.demo.programs.collection.source.Employee;

public class StreamTest {

	public static void main(String[] args) {
		//filterData();
		//mapDataTransformation();
		//flatMapDataTransformation();
		//anyMatchCheckCondition();
		//allMatchCheckCondition();
		noneMatchCheckCondition();
	}
	
	/**
	 * This method is one of example of filter the data from the stream of employees based on creating predicate.
	 * 
	 * */
	private static void filterData() {
		Predicate<Employee>  genderPredicate = emp -> emp.getGender()==Gender.MALE;
		Predicate<Employee>  salaryPredicate = emp -> emp.getSalary() < 10;
	    DataSourceEmployee.getEmployeeList().stream().filter(genderPredicate.or(salaryPredicate).negate()).forEach(System.out::println);	
	}
	
	/**
	 * This method is one of example of map to transform the data from one form to another. 
	 * It accept the input as Function and return transformed value.
	 * 
	 * */
	private static void mapDataTransformation() {
		  Function<Employee,String>   nameAndLocationFucn = emp -> emp.getFullName()+"  -  "+emp.getLocation()+"  - "+emp.getSalary();
		  DataSourceEmployee.getEmployeeList().stream().map(nameAndLocationFucn).forEach(System.out::println);	
	}
	
	
	/**
	 * This method is one of example of flatMap to transform the data from one form to another. 
	 * It accept the input as Function and return transformed value.
	 *  
	 * Note: FlatMap is also same as Map but it has another advantage of merging the multiple list into single list. 
	 * 
	 * */
	private static void flatMapDataTransformation() {
		  Function<Employee,Stream<String>>   nameAndLocationFucn = emp -> emp.getSkils().stream();
		  DataSourceEmployee.getEmployeeList().stream().flatMap(nameAndLocationFucn).forEach(System.out::println);	
	}
	
	/**
	 * This method is helpful to check if any of element in stream is matching the prediction.
	 *  
	 *  If yes then return 'True' else 'False'
	 * 
	 * */
	private static void anyMatchCheckCondition() {
		  Predicate<Employee>   predicateAngular = emp -> emp.getSkils().contains(ConstantEmp.Skils.ANGULAR);
		  Predicate<Employee>   predicateAI = emp -> emp.getSkils().contains(ConstantEmp.Skils.AI);
		  boolean resultAngular= DataSourceEmployee.getEmployeeList().stream().anyMatch(predicateAngular);
		  boolean resultAI= DataSourceEmployee.getEmployeeList().stream().anyMatch(predicateAI);
		  		  
		  System.out.println("Is any employee know the Angular ? "+resultAngular);
		  System.out.println("Is any employee know the AI ? "+resultAI);
	}
	
	/**
	 * This method is helpful to check if all of element having prediction value or not.
	 *  
	 *  If yes then return 'True' else 'False'
	 * 
	 * */
	private static void allMatchCheckCondition() {
		  Predicate<Employee>   predicateAngular = emp -> emp.getSkils().contains(ConstantEmp.Skils.ANGULAR);
		  boolean resultAngular= DataSourceEmployee.getEmployeeList().stream().allMatch(predicateAngular);
			  
		  System.out.println("Is all employees know the Angular ? "+resultAngular);

	}
	
	/**
	 * This method is helpful to check if none of element having prediction value or not.
	 *  
	 *  If yes then return 'True' else 'False'
	 * 
	 * */
	private static void noneMatchCheckCondition() {
		  Predicate<Employee>   predicateAI = emp -> emp.getSkils().contains(ConstantEmp.Skils.AI);
		  boolean resultAI= DataSourceEmployee.getEmployeeList().stream().noneMatch(predicateAI);
			  
		  System.out.println("Is none of employees know the Artificial Intelligent ? "+resultAI);

	}
}
