package com.demo.programs.collection.source;


import java.time.LocalDate;

public interface ConstantEmp {
     
	  interface Names{
		  String BHEEMRAV="BHEEMRAV MAHOVIYA";
		  String VINDO="VINDO MAHOVIYA";
		  String RAHUL="RAHUL GHADGE";
		  String PRAMOD="PRAMOD MAHOVIYA";
		  String MOHAN="MOHAN AHIRWAR";
		  String PRIYANKA ="PRIYANKA  CHOPRA";
		  String AMITABH ="AMITABH BACHCHAN";
		  String SALMAN_KHAN ="SALMAN  KHAN";
		  String AMIR_KHAN="AMIR KHAN";
		  String HEMA_MALINI ="HEMA MALINI";
		  String RANI_MUKERJI ="RANI MUKERJI";
	  }
	  
	  interface Skils{
		  String JAVA="JAVA";
		  String SPRING="SPRING";
		  String SPRING_BOOT="SPRING BOOT";
		  String MICROSERVICES="MICRO SERVICES";
		  String ORACLE="MOHAN AHIRWAR";
		  String DOCKER ="DOCKER";
		  String KUBERNETES ="KUBERNETES";
		  String JENKINS ="JENKINS";
		  String AWS="AWS";
		  String CLOUD ="CLOUD";
		  String ANGULAR ="ANGULAR";
		  String CSS ="CSS";
		  String BOOTSTRAP ="BOOTSTRAP";
		  String HTML ="HTML";
		  String TYPESCRIPT ="TYPE SCRIPT";
		  String POSTGRES ="POSTGRES";
		  String MYSQL ="MYSQL";
		  String AI ="Artificial Intelligent";
	  }
	  
	  
	  enum Gender{
		  MALE,
		  FEMALE
	  }
	  
	  enum LOCATION{
		  BHOPAL,
		  INDORE,
		  PUNE,
		  NAGPUR,
		  DEHLI
	  }
	  
	  public static LocalDate getDOB(int oldYear,int oldMonth,int oldDays) {
		  return getDOB(oldYear).minusMonths(oldMonth).minusDays(oldDays);
	  }
	  
	  public static LocalDate getDOB(int oldYear,int oldMonth) {
		  return getDOB(oldYear).minusMonths(oldMonth);
	  }
	  
	  public static LocalDate getDOB(int oldYear) {
		  return LocalDate.now().minusYears(oldYear);
	  }
}