package com.demo.programs.java8;

import java.util.List;
import java.util.function.Consumer;

import com.demo.programs.collection.source.ConstantEmp;
import com.demo.programs.collection.source.DataSourceEmployee;
import com.demo.programs.collection.source.Employee;

public class MethodReferencesTest {
	
	public static void main(String[] args) {
		
		filterDataByCityBhopal();
		
	}
	
	private static void filterDataByCityBhopal(){
		
	
		
		Consumer<Employee>  printDataConsumer = emp -> {
			System.out.println("Employee:"+emp);
		};
		EmployeeService employeeService=new EmployeeServiceImpl();
		
		getEmpList().stream()
			.filter(EmployeeService::isBhopalEmp) // Static method reference example
			.peek(emp -> {System.out.println("Employee Debug stage 1 : emp :"+emp);})
			.filter(employeeService::findById) //instance method reference example
			.peek(emp -> {System.out.println("Employee Debug stage 2 emp :"+emp);})
			.forEach(printDataConsumer);
			
		
	}
	
	
	private static List<Employee> getEmpList(){
		return DataSourceEmployee.getEmployeeList();
	}
	
	private static void printMsg(String msg) {
		System.out.println();
		System.out.println("------------------------- "+msg+" -------------------------");
		System.out.println();
	}
	
}



interface EmployeeService{
	boolean findById(Employee employee);
	public static boolean isBhopalEmp(Employee employees) {
		
		return employees.getLocation().equals(ConstantEmp.LOCATION.BHOPAL.name());
	}
	
}


class EmployeeServiceImpl implements EmployeeService{
	
	public boolean findById(Employee employee) {
	return employee.getEmpId()==1004;
		
	}
}