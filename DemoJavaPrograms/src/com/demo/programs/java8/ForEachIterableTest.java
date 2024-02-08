package com.demo.programs.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import com.demo.programs.collection.source.DataSourceBooks;

public class ForEachIterableTest {
	public static void main(String[] args) {
		MyJava8 myJava8=new MyJava8() {
			
			@Override
			public void myCall(int param0, int param1) {
				System.out.println("param 0 : "+param0);
				System.out.println("param 1 : "+param1);
			}
		};
		myJava8.myCall(10, 20);;
		
		
		MyJava8 java8 = (param0,param1) -> {
			System.out.println("param 0 : "+param0);
			System.out.println("param 1 : "+param1);
		};
		
		java8.myCall(50, 60);
		
	}
	
	public void forEachTest() {
		List<String> books = DataSourceBooks.BOOKS_LIST;
		List<String> newBooks=null;
		books.add(null);
		AtomicInteger count=new AtomicInteger();
		books.forEach(book -> {
			count.incrementAndGet();
				System.out.println("book: "+book);
			
		
		});
		System.out.println("count: "+count);
		
		Consumer<String> bookDecision = new Consumer<String>() {
			
			public void accept(String book) {
				System.out.println("book: "+book);
			}
		};
		books.forEach(bookDecision);
	}
}


interface MyJava8{
	
	public void myCall(int param0,int param1);
	
	public default void printBooks(List<String> books){
		books.forEach( book -> System.out.println(book));
	}
	

	public static void printBooksConstant(List<String> books ){	
		books.forEach(book -> System.out.println(book));
	}
}
