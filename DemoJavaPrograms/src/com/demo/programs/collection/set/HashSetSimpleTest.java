package com.demo.programs.collection.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.demo.programs.collection.source.DataSourceBooks;

public class HashSetSimpleTest {
	private static final Object PRESENT = new Object();
	private static final String DUMMY = "I am dummy.";
	private static final String DUMMY1 = "I am dummy1.";
	private static final String DUMMY2 = "I am dummy2.";
	private static final String I_AM_NULL = null;
	public static void main(String[] args) {
		HashMap<String,Object>  map=new HashMap <>();
		map.put(DataSourceBooks.BOOK_ENGLISH, DUMMY);
		map.put(DataSourceBooks.BOOK_HINDI, I_AM_NULL);
		map.put(DataSourceBooks.BOOK_MATH, DUMMY);
		System.out.println("HashMap ----- map: "+map);
		System.out.println("HashMap remove BOOK_MATH when present  "+map.remove(DataSourceBooks.BOOK_HINDI));
		System.out.println("HashMap remove BOOK_MATH when not present  "+map.remove(DataSourceBooks.BOOK_HINDI));
		System.out.println("HashMap ----- map: "+map);
		
		HashSet<String>  books=new HashSet <>();
		 //addOperation(books); //To add operation test
		//removeOperation(books); //To remove operation test
		
	}
	
	/**  
	 *  It is section to perform add operation any element in HashSet
	 *  @param		books		Giving any hash set to find the values
	 * */
	private static void addOperation(HashSet<String>  books) {
		System.out.println("HashSetSimpleTest ----- (Add)-----  START");
		System.out.println("HashSetSimpleTest   Empty: "+books);
		System.out.println("HashSetSimpleTest    Is Added new BOOK_ENGLISH: "+books.add(DataSourceBooks.BOOK_ENGLISH));
		System.out.println("HashSetSimpleTest    Is Added new BOOK_HINDI: "+books.add(DataSourceBooks.BOOK_HINDI));
		System.out.println("HashSetSimpleTest    Is Added deplicate BOOK_ENGLISH: "+books.add(DataSourceBooks.BOOK_ENGLISH));
		System.out.println("HashSetSimpleTest    Is Added new BOOK_MATH: "+books.add(DataSourceBooks.BOOK_MATH));
		System.out.println("HashSetSimpleTest   Added: "+books);
		System.out.println("HashSetSimpleTest ----- (Add)-----  END");
	}
	
	
	/**  
	 * It is section to perform find operation any element in HashSet
	 * @param		books		giving any hash set to find the values
	 * 
	 * */
	private static void removeOperation(HashSet<String>  books) {
		books.add(DataSourceBooks.BOOK_ENGLISH);
		books.add(DataSourceBooks.BOOK_HINDI);
		books.add(DataSourceBooks.BOOK_SCIENCE);
		books.add(DataSourceBooks.BOOK_MATH);
		System.out.println("HashSetSimpleTest ----- (Add)-----  START");
		System.out.println("HashSetSimpleTest   Hash element: "+books);
		System.out.println("HashSetSimpleTest    remove element when BOOK_ENGLISH present: "+books.remove(DataSourceBooks.BOOK_HINDI));
		System.out.println("HashSetSimpleTest    remove element when BOOK_ENGLISH not present: "+books.remove(DataSourceBooks.BOOK_HINDI));
		System.out.println("HashSetSimpleTest   Added: "+books);
		System.out.println("HashSetSimpleTest ----- (Add)-----  END");
	}
}