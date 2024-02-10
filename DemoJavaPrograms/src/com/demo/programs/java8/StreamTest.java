package com.demo.programs.java8;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
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
		//noneMatchCheckCondition();
		//findFirstElement();
		//findAnyElement();
		//collectElements();
		System.out.print(Integer.compare(Integer.MAX_VALUE +1, -1) );
	}
	
	
	private static void collectElements() {
	List<Employee>  empList=	DataSourceEmployee.getEmployeeList().stream().collect(Collectors.toList());
	empList.forEach(System.out::println);
	
	
	
	// Group the employee based on location 
    Map<String,List<Employee>>  locationByGroupedEmp = DataSourceEmployee.getEmployeeList().stream().collect(Collectors.groupingBy(Employee::getLocation));

    locationByGroupedEmp.forEach((location,emps) -> {
    	System.out.println("Location : "+location);
    	System.out.println("emps : "+emps);
    });
    
	// Group the employee based on gender and count it
    Map<Gender, Long>  locationByGroupedEmpCount = DataSourceEmployee.getEmployeeList().stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));

    locationByGroupedEmpCount.forEach((gender,empCount) -> {
    	System.out.println("gender : "+gender.name());
    	System.out.println("empCount : "+empCount);
    });

	// Find the average age of the employee 
    Map<Gender, Double>  locationByGroupedEmpAverage = DataSourceEmployee.getEmployeeList().stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));

    locationByGroupedEmpAverage.forEach((gender,avgSalary) -> {
    	System.out.println("gender : "+gender.name());
    	System.out.println("avgSalary : "+avgSalary);
    });
    
    //Converting Employee list into map<empName,emp> format.
    Function<Employee, Employee>  customIdentity = emp -> emp;
	DataSourceEmployee.getEmployeeList().stream().collect(Collectors.toMap(Employee::getFullName,Function.identity())).forEach((key,value) -> {
		System.out.println("key : "+key);
		System.out.println("value: "+value);
	});;
	
	//Count total number of employee there in Company. 
	Long totalEmployee = getEmpList().stream().collect(Collectors.counting());
    System.out.println("totalEmployee : "+totalEmployee);
  
    // Comparator to compare two employee object based on salary.
    Comparator<Employee>  empSalaryCompare = (emp1, emp2) -> {
    	return Double.compare(emp1.getSalary(), emp2.getSalary());
    };  
    
   
    
     // Find the employee who has min salary
     getEmpList().stream().collect(Collectors.minBy(empSalaryCompare)).ifPresentOrElse(emp -> {
    	 System.out.println("Min salary emp name: "+emp.getFullName()+"   emp salary: "+emp.getSalary());
     }, ()->{
    	 System.out.println("No max salary employee present.");
     });
    
     Comparator<Employee>  empSalaryCompareNew = Comparator.comparing(Employee::getSalary);
     // Find the employee who has max salary
     getEmpList().stream().collect(Collectors.maxBy(empSalaryCompareNew)).ifPresentOrElse(emp -> {
    	 System.out.println("Max salary emp name: "+emp.getFullName()+"   emp salary: "+emp.getSalary());
     },()-> {
    	 System.out.println("No max salary employee present.");
     } );
     
     // partitioning the employee list based on some logical condition and get the map 
     Predicate<Employee> salaryGreaterThenTenLac = emp -> emp.getSalary() > 10.0;
     getEmpList().stream().collect(Collectors.partitioningBy(salaryGreaterThenTenLac)).forEach((key,value) -> {
    	 System.out.println("key : "+key+"   value: "+value);
     });
     
     //Convert a list into a some format using the delimiter 
     Function<Employee,String>  employeeNameFunction = emp -> emp.getFullName();
     
     String formatedValue =getEmpList().stream().map(employeeNameFunction).collect(Collectors.joining("','","['","]}"));
      System.out.println(formatedValue);                
	}
 
	/**
	 * This method is helpful to get element if any element is present in the stream and return optional.
	 *  t
	 *  Note: It use the parallel streaming and whichever the element we found that we will serve.
	 *        But it is not having guarantee to give always new element or same.
	 * 
	 * */
	private static void findAnyElement() {
		
		  Optional<Employee> result1= DataSourceEmployee.getEmployeeList().stream().findAny();
		  result1.ifPresentOrElse(emp -> {
			  System.out.println("emp element present : "+emp);
		  }, ()-> System.out.println("No element present."));
			  
		  Predicate<Employee>  isAIEmployeePresent = emp -> emp.getSkils().contains(ConstantEmp.Skils.AI);

		  Optional<Employee> result2= DataSourceEmployee.getEmployeeList().stream().filter(isAIEmployeePresent).findAny();
		  result2.ifPresentOrElse(emp -> {
			  System.out.println("emp element present : "+emp);
		  }, ()-> System.out.println("No element present."));

	}
	
	/**
	 * This method is helpful to get first element from stream and return optional.
	 *  
	 * 
	 * */
	private static void findFirstElement() {
		
		  Optional<Employee> result1= DataSourceEmployee.getEmployeeList().stream().findFirst();
		  result1.ifPresentOrElse(emp -> {
			  System.out.println("emp element present : "+emp);
		  }, ()-> System.out.println("No element present."));
			  
		  Predicate<Employee>  isAIEmployeePresent = emp -> emp.getSkils().contains(ConstantEmp.Skils.AI);

		  Optional<Employee> result2= DataSourceEmployee.getEmployeeList().stream().filter(isAIEmployeePresent).findFirst();
		  result2.ifPresentOrElse(emp -> {
			  System.out.println("emp element present : "+emp);
		  }, ()-> System.out.println("No element present."));

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
	
	private static List<Employee> getEmpList(){
		return DataSourceEmployee.getEmployeeList();
	}
}
