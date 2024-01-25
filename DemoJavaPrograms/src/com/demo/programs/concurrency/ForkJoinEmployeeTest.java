package com.demo.programs.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;


import com.demo.programs.collection.source.ConstantEmp;
import com.demo.programs.collection.source.DataSourceEmployee;
import com.demo.programs.collection.source.Employee;

public class ForkJoinEmployeeTest {
	public static void main(String[] args) {
		//Filter without fork join
		//filterWithoutFormJoin();
		
		filterWithFormJoin();
		
	}
	
	
	
	public static void filterWithoutFormJoin() {
		/** 
		  *  Find the employees which have below criteria.
		  *  LOCATION IN = DEHLI | PUNE
		  *  SALARY  = 12 LAC TO 25 LAC
		  * 
		  * */	
		FilterWithoutForkJoin filterWithoutForkJoin = new FilterWithoutForkJoin();
		System.out.println("filterWithoutForkJoin - start with location");
	    List<Employee> employeesAfterLocation =	filterWithoutForkJoin.employeeFilterByLocation(DataSourceEmployee.getEmployeeList(), 
	    		Arrays.asList(ConstantEmp.LOCATION.DEHLI.name(),ConstantEmp.LOCATION.BHOPAL.name()));
	    
	    employeesAfterLocation.stream().forEach(System.out::println);
		System.out.println("filterWithoutForkJoin - end with location");
		System.out.println("filterWithoutForkJoin - start with salary");
	    List<Employee> employeesAfterSalary =  filterWithoutForkJoin.employeeFilterBySalary(employeesAfterLocation, 1000000.00, 2500000.00);
	    employeesAfterSalary.stream().forEach(System.out::println);
		System.out.println("filterWithoutForkJoin - end with salary");
	}
	
	public static  void filterWithFormJoin() {
		System.out.println("filterWithoutForkJoin - start with location");
		ForkJoinPool forkJoinPool=ForkJoinPool.commonPool();
		List<Employee> employees=DataSourceEmployee.getEmployeeList();
		com.demo.programs.concurrency.EmployeeFilterByLocationRecursieTask employeeLoationTask 
		= new com.demo.programs.concurrency.EmployeeFilterByLocationRecursieTask(employees,Arrays.asList(ConstantEmp.LOCATION.DEHLI.name(),ConstantEmp.LOCATION.BHOPAL.name()), 0, employees.size()-1);
		List<Employee> employeesFilterByLocation = forkJoinPool.invoke(employeeLoationTask);
		employeesFilterByLocation.stream().forEach(System.out::println);
		System.out.println("filterWithoutForkJoin - end with location");
		
	}
	
}


 class FilterWithoutForkJoin{
	 
	 /** 
	  * Filter employees by Location
	  * */
	 public List<Employee> employeeFilterByLocation(List<Employee>  employees,List<String> locations){
		 System.out.println("employeeFilterByLocation(-) start ");
		List<Employee> filteredEmp = employees.stream().filter(employee -> {
			System.out.println("employeeLocation: "+employee.getLocation()+", Thread name : "+Thread.currentThread().getName());
			return locations.contains(employee.getLocation());
		}).collect(Collectors.toList());

		return filteredEmp;
	 }
	 
	 /** 
	  * Filter employees who's having salary b/w criteria
	  * */
	 public List<Employee> employeeFilterBySalary(List<Employee>  employees,double minSalary,double maxSalary){
		 System.out.println("employeeFilterByLocation(-) start ");
		List<Employee> filteredEmp = employees.stream().filter(employee -> {
			System.out.println("employeeLocation: "+employee.getSalary()+ ", Thread name : "+Thread.currentThread().getName());
			return employee.getSalary()>= minSalary && employee.getSalary() < maxSalary;
		}).collect(Collectors.toList());

		return filteredEmp;
	 }
 }

	 
	 /** 
	  * Filter employees by Location
	  * */
	
	 class EmployeeFilterByLocationRecursieTask extends RecursiveTask<List<Employee>> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private static final int THRESHOLD = 2;
		private List<Employee> employees;
		private List<String> locations;
		
		private int start;
		private int end;
		
		public EmployeeFilterByLocationRecursieTask(List<Employee> employees,List<String> locations,int start,int end) {
			this.employees=employees;
			this.locations=locations;
			this.start=start;
			this.end=end;
		}
		

		@Override
		protected List<Employee> compute() {
			if(end-start <= THRESHOLD) {
				 System.out.println("compute.executeTask (-) by start :  "+start+"  end : "+end + " Thrad Name: "+Thread.currentThread().getName());
				return filterData(employees, locations, start, end);
			}else {
				int mid = (start+end) /2;
				 System.out.println("compute.divideTask (-) by start :  "+start+"  mid  "+ mid+" end : "+end+" Thrad Name: "+Thread.currentThread().getName());
					
				EmployeeFilterByLocationRecursieTask leftTask = new EmployeeFilterByLocationRecursieTask(employees,locations, start, mid);
				EmployeeFilterByLocationRecursieTask rightTask = new EmployeeFilterByLocationRecursieTask(employees,locations, mid, end);
				leftTask.fork();
				rightTask.fork();
				
				List<Employee> leftResult= leftTask.join();
				List<Employee> rightResult= rightTask.join();
				List<Employee> employeesList= new ArrayList<>();
				System.out.println("compute.divideTask.leftResult (-) Reuslt: "+leftResult);
				System.out.println("compute.divideTask.rightResult (-) Reuslt: "+rightResult);
				
				employeesList.addAll(leftResult);
				employeesList.addAll(rightResult);
				return employeesList;
			}
		}
		public List<Employee> filterData(List<Employee> employees,List<String> locations,int start,int end){
			 List<Employee> employeesList=new ArrayList<>();
				for(int i=start; i < end; i++ ) {
					Employee employee = employees.get(i);
					if(locations.contains(employee.getLocation())) {
						employeesList.add(employees.get(i));
					}	
				}	
			return employeesList;
		 } 
	 }
	 
	 
	 
	 /** 
	  * Filter employees who's having salary b/w criteria
	  * */
	
