package com.demo.programs.oops;


public class inheritanceTest {
	public static void main(String[] args) {
		MyHashMap hashMap=new MyLinkedHashMap();
		hashMap.put("Ram");
		hashMap.put("Raj");
		
	}
}


class MyHashMap{
	
	 String newNode(String name) {
		 return "I am from MyHashMap name: "+name;
	 }
	 
	 void put(String name){
		String value =newNode(name);
		System.out.println(value);
	 }
}

class MyLinkedHashMap extends MyHashMap{
	
	 String newNode(String name) {
		 return "I am from myLinkedHashMap name: "+name;
	 }

}