package com.demo.programs.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;

import com.demo.programs.collection.source.DataSourceBooks;

public class LinkedHashSetSimpleTest {
	public static void main(String[] args) {
		LinkedHashSet<String>  books=new LinkedHashSet <>();
		addOperation(books); //To add operation test
		System.out.println("HashSetSimpleTest    Is BOOK_ENGLISH contains: "+books.contains(DataSourceBooks.BOOK_ENGLISH));

		
	}
	
	/**  
	 *  It is section to perform add operation any element in HashSet
	 *  @param		books		Giving any hash set to find the values
	 * */
	private static void addOperation(HashSet<String>  books) {
		System.out.println("HashSetSimpleTest ----- (Add)-----  START");
		System.out.println("HashSetSimpleTest   Empty: "+books);
		System.out.println("HashSetSimpleTest    Is Added new BOOK_MATH: "+books.add(DataSourceBooks.BOOK_SO_SCIENCE));
		System.out.println("HashSetSimpleTest    Is Added new BOOK_ENGLISH: "+books.add(DataSourceBooks.BOOK_ENGLISH));
		System.out.println("HashSetSimpleTest    Is Added new BOOK_HINDI: "+books.add(DataSourceBooks.BOOK_HINDI));
		System.out.println("HashSetSimpleTest    Is Added deplicate BOOK_ENGLISH: "+books.add(DataSourceBooks.BOOK_ENGLISH));
		System.out.println("HashSetSimpleTest    Is Added new BOOK_MATH: "+books.add(DataSourceBooks.BOOK_SCIENCE));
		System.out.println("HashSetSimpleTest   Added: "+books.toString());
		System.out.println("HashSetSimpleTest ----- (Add)-----  END");
	}
	
	
	
}