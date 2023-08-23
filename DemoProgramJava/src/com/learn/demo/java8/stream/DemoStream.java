package com.learn.demo.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DemoStream {

	public static void main(String[] args) {
	
		//Combine the two stream in single
		List<Integer> listInteger=getStreamByList();
		Stream<Integer> streamInteger=getStreamFromStream();
		Stream<Integer> combineStream=Stream.concat(listInteger.stream(),streamInteger);
		
		//Print all list values
		listInteger.stream().forEach(System.out::println);
		System.out.print("-------------------------------------------");
		//Print all list values in natural sorting
		listInteger.stream().sorted().forEach(System.out::println);
	}
	
	
	public static List<Integer> getStreamByList(){
		List<Integer> list=Arrays.asList(new Integer[] {1,4,2,5,7,6,8});
		return list;
	}
	
	
	public static Stream<Integer> getStreamFromStream(){
		Stream<Integer> stream=Stream.of(1,2,3,4,6,7,5);
		return stream;
	}
}
