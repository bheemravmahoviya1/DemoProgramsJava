package com.demo.programs.concurrency;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import com.demo.programs.collection.source.DataSourceBooks;

public class CopyOnWriteArrayListTest {
	public static void main(String[] args) {

		ConcurrencyWithSet();
	
	}
	
	public static void ConcurrencyWithList() {
		List<String> arrayList1=DataSourceBooks.BOOKS_LIST;
		CopyOnWriteArrayList<String> arrayList=new CopyOnWriteArrayList<>(arrayList1);
		System.out.println("List = " + arrayList);
		Iterator<String> iterator=arrayList.iterator();
		arrayList.add("General knowledge");
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
	
	public static void ConcurrencyWithSet() {
		List<String> arrayList1=DataSourceBooks.BOOKS_LIST;
		CopyOnWriteArraySet<String> arrayList=new CopyOnWriteArraySet<>(arrayList1);
		System.out.println("List = " + arrayList);
		Iterator<String> iterator=arrayList.iterator();
		arrayList.add("General knowledge");
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
	
	public static void ConcurrencyWithMap() {
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>(DataSourceBooks.BOOKS_MAP);
		System.out.println("map1 : "+map);
		map.put(6, "General Knowledge");
		System.out.println("map2 : "+map);
		map.put(6, "General Knowledge");
	}
}
