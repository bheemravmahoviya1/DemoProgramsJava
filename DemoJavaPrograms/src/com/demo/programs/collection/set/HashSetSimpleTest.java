package com.demo.programs.collection.set;

import java.util.HashSet;
import com.demo.programs.collection.source.DataSourceBooks;

public class HashSetSimpleTest {
	public static void main(String[] args) {
		HashSet<String>  books=new HashSet <>();
		addOperation(books); //To add operation test
		removeOperation(books); //To remove operation test
		
		System.out.println("HashSetSimpleTest    Is BOOK_ENGLISH contains: "+books.contains(DataSourceBooks.BOOK_ENGLISH));

		
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
		System.out.println("HashSetSimpleTest    Is BOOK_ENGLISH contains: "+books.removeIf( book -> book.equals(DataSourceBooks.BOOK_ENGLISH)));
		System.out.println("HashSetSimpleTest   Added: "+books);
		System.out.println("HashSetSimpleTest ----- (Add)-----  END");
	}
}