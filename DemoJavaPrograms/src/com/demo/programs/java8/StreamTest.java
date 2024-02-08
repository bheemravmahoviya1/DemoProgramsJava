package com.demo.programs.java8;


import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.demo.programs.collection.source.ConstantEmp.Gender;
import com.demo.programs.collection.source.DataSourceEmployee;
import com.demo.programs.collection.source.Employee;

public class StreamTest {

	public static void main(String[] args) {
		//filterData();
		//mapDataTransformation();
		flatMapDataTransformation();
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
}
