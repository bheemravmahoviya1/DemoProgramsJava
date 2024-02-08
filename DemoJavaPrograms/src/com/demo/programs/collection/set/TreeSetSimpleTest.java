package com.demo.programs.collection.set;


import java.util.TreeSet;

import com.demo.programs.collection.source.DataSourceBooks;

public class TreeSetSimpleTest {
	public static void main(String[] args) {
		TreeSet<String>  books=new TreeSet <>();
		addOperation(books); //To add operation test
		System.out.println("TreeSetSimpleTest    Is BOOK_ENGLISH contains: "+books.contains(DataSourceBooks.BOOK_ENGLISH));

		
	}
	
	/**  
	 *  It is section to perform add operation any element in HashSet
	 *  @param		books		Giving any hash set to find the values
	 * */
	private static void addOperation(TreeSet<String>  books) {
		System.out.println("TreeSetSimpleTest ----- (Add)-----  START");
		System.out.println("TreeSetSimpleTest   Empty: "+books);
		System.out.println("TreeSetSimpleTest    Is Added new BOOK_SCIENCE: "+books.add(DataSourceBooks.BOOK_SCIENCE));
		System.out.println("TreeSetSimpleTest    Is Added new BOOK_ENGLISH: "+books.add(DataSourceBooks.BOOK_ENGLISH));
		System.out.println("TreeSetSimpleTest    Is Added new BOOK_HINDI: "+books.add(DataSourceBooks.BOOK_HINDI));
		System.out.println("TreeSetSimpleTest    Is Added deplicate BOOK_ENGLISH: "+books.add(DataSourceBooks.BOOK_ENGLISH));
		System.out.println("TreeSetSimpleTest    Is Added new BOOK_MATH: "+books.add(DataSourceBooks.BOOK_MATH));
		System.out.println("TreeSetSimpleTest    Is Added new BOOK_SO_SCIENCE: "+books.add(DataSourceBooks.BOOK_SO_SCIENCE));
		System.out.println("TreeSetSimpleTest   Added: "+books.toString());
		System.out.println("TreeSetSimpleTest ----- (Add)-----  END");
	}
	
}
