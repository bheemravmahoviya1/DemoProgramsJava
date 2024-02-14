package com.demo.programs.collection.source;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.demo.programs.collection.source.ConstantEmp.Gender;

public class Employee implements Comparable<Employee>,Serializable{
	
	private int empId;
	private String fullName;
	private String location;
	private double salary;
	private LocalDate dob;
	private Gender gender;
	private List<String> skils;
	private Optional<String> favourite = Optional.ofNullable("Singing");
	



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
	
	

	@Override
	public int hashCode() {
		return Objects.hash(dob, empId, fullName, gender, location, salary, skils);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dob, other.dob) && empId == other.empId && Objects.equals(fullName, other.fullName)
				&& gender == other.gender && Objects.equals(location, other.location)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary)
				&& Objects.equals(skils, other.skils);
	}

	public Optional<String> getFavourite() {
		return favourite;
	}



	public void setFavourite(Optional<String> favourite) {
		this.favourite = favourite;
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
