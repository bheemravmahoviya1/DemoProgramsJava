package com.demo.programs.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

import com.demo.programs.collection.source.DataSourceBooks;
import com.demo.programs.collection.source.ConstantEmp;

public class HashSetEmployeeTest {
	public static void main(String[] args) {
		HashSet<TempEmployee>  books=new HashSet <>();
		addOperation(books,false); //To add operation test
		containsOperation(books,false);//To check contain opration
		removeOperation(books); //To remove operation test
		
		//System.out.println("HashSetSimpleTest    Is BOOK_ENGLISH contains: "+books.contains(DataSourceBooks.BOOK_ENGLISH));

		
	}
	
	/**  
	 *  It is section to perform add operation any element in HashSet
	 *  @param		books		Giving any hash set to find the values
	 * */
	private static void addOperation(HashSet<TempEmployee>  books, boolean isPrint) {
		System.out.println("HashSetSimpleTest ----- (Add)-----  START");
		System.out.println("HashSetSimpleTest   Empty: "+books);
		System.out.println("HashSetSimpleTest    Is Added new BHEEMRAV: "+books.add(new TempEmployee(1001, ConstantEmp.Names.BHEEMRAV)));
		System.out.println("HashSetSimpleTest    Is Added new VINDO: "+books.add(new TempEmployee(1002, ConstantEmp.Names.VINDO)));
		System.out.println("HashSetSimpleTest    Is Added deplicate BHEEMRAV: "+books.add(new TempEmployee(1001, ConstantEmp.Names.BHEEMRAV)));
		System.out.println("HashSetSimpleTest    Is Added new SALMAN_KHAN: "+books.add(new TempEmployee(1003, ConstantEmp.Names.SALMAN_KHAN)));
		System.out.println("HashSetSimpleTest    Is Added new SALMAN_KHAN: "+books.add(new TempEmployee(1003, ConstantEmp.Names.AMIR_KHAN)));
		System.out.println("HashSetSimpleTest    Is Added new SALMAN_KHAN: "+books.add(new TempEmployee(1003, ConstantEmp.Names.AMITABH)));
		
		System.out.println("HashSetSimpleTest   Added: "+books);
		printOperation(books,isPrint);
		System.out.println("HashSetSimpleTest ----- (Add)-----  END");
	}
	
	/**  
	 *  It is section to perform contains operation to check that element is present or not in HashSet.
	 *  @param		books		Giving any hash set to find the values
	 * */
	private static void containsOperation(HashSet<TempEmployee>  books,boolean isPrint) {
		System.out.println("HashSetSimpleTest ----- (Contains)-----  START");
		System.out.println("HashSetSimpleTest   Hashset contain BHEEMRAV ? : "+books.contains(new TempEmployee(1001, ConstantEmp.Names.BHEEMRAV)));
		printOperation(books,isPrint);
		
		System.out.println("HashSetSimpleTest ----- (Contains)-----  END");
	}
	
	
	/**  
	 * It is section to perform find operation any element in HashSet
	 * @param		books		giving any hash set to find the values
	 * 
	 * */
	private static void removeOperation(HashSet<TempEmployee>  books) {
		System.out.println("HashSetSimpleTest ----- (Add)-----  START");
		System.out.println("HashSetSimpleTest _____________  Hash elements before remove ______________ ");
		printOperation(books, true);
		System.out.println("HashSetSimpleTest *************  Hash elements remove start ************* ");
		System.out.println("HashSetSimpleTest    remove element BHEEMRAV when  present: "+books.remove(new TempEmployee(1001, ConstantEmp.Names.BHEEMRAV)));
		System.out.println("HashSetSimpleTest    remove element BHEEMRAV when  not present: "+books.remove(new TempEmployee(1001, ConstantEmp.Names.BHEEMRAV)));
		System.out.println("HashSetSimpleTest    remove SALMAN_KHAN if contains: "+books.removeIf( book -> book.equals(new TempEmployee(1003, ConstantEmp.Names.SALMAN_KHAN))));
		System.out.println("HashSetSimpleTest *************  Hash elements remove end ************* ");
		System.out.println("HashSetSimpleTest ______________  Hash elements after remove ______________ ");
		printOperation(books, true);
		System.out.println("HashSetSimpleTest ----- (Add)-----  END");
	}
	
	private static void printOperation(HashSet<TempEmployee>  books, boolean isPrint) {
		if(isPrint) {
			Iterator<TempEmployee>  each = books.iterator();
			while(each.hasNext()) {
			  TempEmployee employee =	each.next();
			  System.out.println("hash code: "+employee.hashCode()+",  Temp employ  "+employee);
			}	
		}
		
	}
}



class TempEmployee {
	
	private int empId;
	private String fullName;

	public TempEmployee(int empId, String fullName) {
		this.empId = empId;
		this.fullName = fullName;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(empId, fullName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempEmployee other = (TempEmployee) obj;
		return empId == other.empId && Objects.equals(fullName, other.fullName);
	}

	@Override
	public String toString() {
		return "TempEmployee [empId=" + empId + ", fullName=" + fullName + "]";
	}

}