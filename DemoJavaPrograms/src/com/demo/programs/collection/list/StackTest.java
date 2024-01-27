package com.demo.programs.collection.list;



import java.util.Stack;

public class StackTest {
	
	private static final String BOOK_MATH = "Math Book";
	private static final String BOOK_SCIENCE = "Science Book";
	private static final String BOOK_SO_SCIENCE = "So. Science Book";
	private static final String BOOK_ENGLISH = "English Book";
	private static final String BOOK_HINDI = "Hindi Book";
	
	public static void main(String[] args) {
		Stack<String> booksStack=new Stack<>();
		/** Added books to Stack   */
		addOrPushOperation(booksStack);
		booksStack.add(BOOK_ENGLISH);
		
		/** Pop operation on books Stack   */
		PopOperation(booksStack);
		
		/** Added books to Stack   */
		addOrPushOperation(booksStack);

		
		/** Read book to Stack   */
		PeepOperation(booksStack);
		
		/** Find the position of book in Stack   */
		SearchOperation(booksStack);
	   
	}
	
	
	
	/**
	 *  Add multiple elements to stack using add or push method. 
	 * @parama booksStack reference of stack object
	 * 
	 * */
	public static void addOrPushOperation(Stack<String> booksStack) {
		System.out.println("------------------------- Push ---------------------------------");
		/** Added books to Stack   */
		booksStack.add(BOOK_MATH);  // Added first
		booksStack.push(BOOK_SCIENCE);
		booksStack.push(BOOK_SO_SCIENCE); // Added mid
		booksStack.push(BOOK_ENGLISH);
		booksStack.add(BOOK_HINDI); // Added last
		System.out.println("booksStack :->  " +booksStack);
	}

	
	/**
	 * Reading using pop method and remove from stack and 
	 * remaining element only you can find.
	 * @parama booksStack reference of stack object
	 * */
	public static void PopOperation(Stack<String> booksStack) {
		System.out.println("------------------------- POP ---------------------------------");
		System.out.println("Give last element of booksStack :->  " +booksStack.pop());
		System.out.println("Give second last element of  booksStack :->  " +booksStack.pop());
		System.out.println("Give third last element of  booksStack :->  " +booksStack.pop());
		System.out.println("booksStack :->  " +booksStack);
	}
	
	/**
	 * Reading using peak method but i will read only same data which keep on top of stack 
	 * and no change in structure of stack.
	 * @parama booksStack reference of stack object
	 * 
	 * */
	public static void PeepOperation(Stack<String> booksStack) {
		System.out.println("------------------------- PEEK ---------------------------------");
		System.out.println("booksStack.peek() "+booksStack.peek());
		System.out.println("booksStack.peek() "+booksStack.peek());
		System.out.println("booksStack :->  " +booksStack);
	}
	
	/**
	 * Search any book index based on name of book 
	 * and no change in structure of stack.
	 * @parama booksStack reference of stack object
	 * 
	 * */
	public static void SearchOperation(Stack<String> booksStack) {
		System.out.println("------------------------- SEARCH POSSITION ---------------------------------");
		System.out.println(BOOK_MATH+" store in index of "+booksStack.search(BOOK_MATH));
		System.out.println(BOOK_SCIENCE+" store in index of "+booksStack.search(BOOK_SCIENCE));
		System.out.println(BOOK_HINDI+" store in index of "+booksStack.search(BOOK_HINDI));
		System.out.println("booksStack :->  " +booksStack);
	}

}
