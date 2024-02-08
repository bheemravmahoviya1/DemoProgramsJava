package com.demo.programs.collection.source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DataSourceBooks {
	public static final String BOOK_MATH = "Math Book";
	public static final String BOOK_SCIENCE = "Science Book";
	public static final String BOOK_SO_SCIENCE = "So. Science Book";
	public static final String BOOK_ENGLISH = "English Book";
	public static final String BOOK_HINDI = "Hindi Book";
	public static final List<String> BOOKS_LIST =new ArrayList<>();
	public static final Map<Integer,String> BOOKS_MAP =new HashMap();
	public static final Queue<String> BOOKS_DE_QUEUE =new LinkedList<>();
	public static final Queue<String> BOOKS_QUEUE =new PriorityQueue<>();
	
	static {
		/*LIST ARRAY VALUES */
		BOOKS_LIST.add(BOOK_ENGLISH);
		BOOKS_LIST.add(BOOK_HINDI);
		BOOKS_LIST.add(BOOK_MATH);
		BOOKS_LIST.add(BOOK_SCIENCE);
		BOOKS_LIST.add(BOOK_SO_SCIENCE);
		
		/*LIST QUEUE VALUES */
		BOOKS_QUEUE.add(BOOK_ENGLISH);
		BOOKS_QUEUE.add(BOOK_HINDI);
		BOOKS_QUEUE.add(BOOK_MATH);
		BOOKS_QUEUE.add(BOOK_SCIENCE);
		BOOKS_QUEUE.add(BOOK_SO_SCIENCE);
		
		/*LIST DE_QUEUE VALUES */
		BOOKS_DE_QUEUE.add(BOOK_ENGLISH);
		BOOKS_DE_QUEUE.add(BOOK_HINDI);
		BOOKS_DE_QUEUE.add(BOOK_MATH);
		BOOKS_DE_QUEUE.add(BOOK_SCIENCE);
		BOOKS_DE_QUEUE.add(BOOK_SO_SCIENCE);
		
		/*Map  VALUES */
		BOOKS_MAP.put(1,BOOK_ENGLISH);
		BOOKS_MAP.put(2,BOOK_HINDI);
		BOOKS_MAP.put(3,BOOK_MATH);
		BOOKS_MAP.put(4,BOOK_SCIENCE);
		BOOKS_MAP.put(5,BOOK_SO_SCIENCE);
	}
}
