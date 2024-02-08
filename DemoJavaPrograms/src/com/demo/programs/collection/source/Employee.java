package com.demo.programs.collection.source;

import java.time.LocalDate;
import java.util.List;

import com.demo.programs.collection.source.ConstantEmp.Gender;

public class Employee implements Comparable<Employee>{
	
	private int empId;
	private String fullName;
	private String location;
	private double salary;
	private LocalDate dob;
	private Gender gender;
	private List<String> skils;
	public Employee(int empId, String fullName, String location, double salary, LocalDate dob,Gender gender,
			List<String> skils) {
		this.empId = empId;
		this.fullName = fullName;
		this.location = location;
		this.salary = salary;
		this.dob = dob;
		this.gender=gender;
		this.skils = skils;
	}
	
	

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public List<String> getSkils() {
		return skils;
	}
	public void setSkils(List<String> skils) {
		this.skils = skils;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", location=" + location + ", salary=" + salary
				+ ", dob=" + dob + ", gender=" + gender + ", skils=" + skils + "]";
	}


	
	 public int compareTo(Employee employee) {
		 
		 return (this.empId < employee.empId) ? -1 : ((this.empId == employee.empId) ? 0 : 1);  
	 }
	 
}
