package com.demo.programs.collection.compare;

import java.util.Collections;
import java.util.List;

import com.demo.programs.collection.source.DataSourceEmployee;
import com.demo.programs.collection.source.Employee;

public class ComparableTest {
  public static void main(String[] args) {
	  myEmployeeComparableTest();
	
}
  
  public static void myEmployeeComparableTest() {
	    List<Employee>  employees=DataSourceEmployee.getEmployeeList();
		System.out.println("Employee list before sorting .....................");
		for(Employee emp:employees) {
			System.out.println("Emp: "+emp);
		}
		
		System.out.println("Employee list After sorting .....................");
		Collections.sort(employees);
		for(Employee emp:employees) {
			System.out.println("Emp: "+emp);
		}
  }
  
  public static int compare (int x, int y) {
	  return (x < y) ? -1 : (x == y ) ? 0 : 1;  
  }
}
