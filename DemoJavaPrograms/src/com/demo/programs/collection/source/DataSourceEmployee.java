package com.demo.programs.collection.source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSourceEmployee {
	
	/** 
	 * This method return reach set of data of employees.
	 * */
	public static List<Employee> getEmployeeList(){
		List<Employee> employees=new  ArrayList<>();
		/** BHEEMRAV MAHOVIYA */
		employees.add(new Employee(1000, ConstantEmp.Names.BHEEMRAV, ConstantEmp.LOCATION.PUNE.name(), 14.0, ConstantEmp.getDOB(30)
				, ConstantEmp.Gender.MALE,Arrays.asList(ConstantEmp.Skils.JAVA,ConstantEmp.Skils.SPRING,ConstantEmp.Skils.SPRING_BOOT,ConstantEmp.Skils.ANGULAR
						,ConstantEmp.Skils.DOCKER,ConstantEmp.Skils.KUBERNETES)));
		
		/** VINDO MAHOVIYA */
		employees.add(new Employee(1901, ConstantEmp.Names.VINDO, ConstantEmp.LOCATION.BHOPAL.name(), 6.0, ConstantEmp.getDOB(27)
				, ConstantEmp.Gender.MALE,Arrays.asList(ConstantEmp.Skils.JAVA,ConstantEmp.Skils.SPRING,ConstantEmp.Skils.SPRING_BOOT)));
		
		
		/** RAHUL GHADGE */
		employees.add(new Employee(1002, ConstantEmp.Names.RAHUL, ConstantEmp.LOCATION.INDORE.name(), 28.0, ConstantEmp.getDOB(29)
				, ConstantEmp.Gender.MALE,Arrays.asList(ConstantEmp.Skils.JAVA,ConstantEmp.Skils.SPRING,ConstantEmp.Skils.SPRING_BOOT,ConstantEmp.Skils.ANGULAR
						,ConstantEmp.Skils.DOCKER,ConstantEmp.Skils.KUBERNETES,ConstantEmp.Skils.AWS,ConstantEmp.Skils.CLOUD,ConstantEmp.Skils.JENKINS)));
		
		
		/** PRAMOD MAHOVIYA */
		employees.add(new Employee(1033, ConstantEmp.Names.PRAMOD, ConstantEmp.LOCATION.BHOPAL.name(), 10.0, ConstantEmp.getDOB(33)
				, ConstantEmp.Gender.MALE,Arrays.asList(ConstantEmp.Skils.ANGULAR,ConstantEmp.Skils.TYPESCRIPT,ConstantEmp.Skils.CSS,ConstantEmp.Skils.HTML)));
		
		
		/** MOHAN AHIRWAR */
		employees.add(new Employee(1004, ConstantEmp.Names.MOHAN, ConstantEmp.LOCATION.BHOPAL.name(), 5.0, ConstantEmp.getDOB(18)
				, ConstantEmp.Gender.MALE,Arrays.asList(ConstantEmp.Skils.ANGULAR,ConstantEmp.Skils.TYPESCRIPT,ConstantEmp.Skils.CSS,ConstantEmp.Skils.HTML)));
		
		
		/** PRIYANKA CHOPRA */
		employees.add(new Employee(1005, ConstantEmp.Names.PRIYANKA, ConstantEmp.LOCATION.DEHLI.name(), 8.0, ConstantEmp.getDOB(40)
				, ConstantEmp.Gender.FEMALE,Arrays.asList(ConstantEmp.Skils.ORACLE,ConstantEmp.Skils.POSTGRES,ConstantEmp.Skils.JENKINS,ConstantEmp.Skils.DOCKER)));
		
		
		/** AMITABH BACHCHAN */
		employees.add(new Employee(1006, ConstantEmp.Names.AMITABH, ConstantEmp.LOCATION.DEHLI.name(), 10.0, ConstantEmp.getDOB(52)
				, ConstantEmp.Gender.MALE,Arrays.asList(ConstantEmp.Skils.ANGULAR,ConstantEmp.Skils.TYPESCRIPT,ConstantEmp.Skils.CSS,ConstantEmp.Skils.HTML)));
		
		
		/** SALMAN KHAN */
		employees.add(new Employee(1007, ConstantEmp.Names.SALMAN_KHAN, ConstantEmp.LOCATION.DEHLI.name(), 8.0, ConstantEmp.getDOB(40)
				, ConstantEmp.Gender.MALE,Arrays.asList(ConstantEmp.Skils.KUBERNETES,ConstantEmp.Skils.JENKINS,ConstantEmp.Skils.DOCKER)));
		
		/** AMIR KHAN */
		employees.add(new Employee(1008, ConstantEmp.Names.AMIR_KHAN, ConstantEmp.LOCATION.INDORE.name(), 8.0, ConstantEmp.getDOB(28)
				, ConstantEmp.Gender.MALE,Arrays.asList(ConstantEmp.Skils.KUBERNETES,ConstantEmp.Skils.JENKINS,ConstantEmp.Skils.DOCKER,ConstantEmp.Skils.ORACLE,ConstantEmp.Skils.POSTGRES,ConstantEmp.Skils.MICROSERVICES)));
		
		
		/** HEMA MALINI */
		employees.add(new Employee(1009, ConstantEmp.Names.HEMA_MALINI, ConstantEmp.LOCATION.DEHLI.name(), 12.0, ConstantEmp.getDOB(37)
				, ConstantEmp.Gender.FEMALE,Arrays.asList(ConstantEmp.Skils.JAVA,ConstantEmp.Skils.SPRING,ConstantEmp.Skils.SPRING_BOOT)));
	
		
		/** RANI MUKERJI */
		employees.add(new Employee(1010, ConstantEmp.Names.RANI_MUKERJI, ConstantEmp.LOCATION.NAGPUR.name(), 15.0, ConstantEmp.getDOB(37)
				, ConstantEmp.Gender.FEMALE,Arrays.asList(ConstantEmp.Skils.JAVA,ConstantEmp.Skils.SPRING,ConstantEmp.Skils.SPRING_BOOT,ConstantEmp.Skils.ANGULAR
						,ConstantEmp.Skils.DOCKER,ConstantEmp.Skils.KUBERNETES)));
		
		return employees;
	}

}


 