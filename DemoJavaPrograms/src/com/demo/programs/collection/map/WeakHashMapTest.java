package com.demo.programs.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
class Test{
	
}

public class WeakHashMapTest {
	
	public static void main(String[] args) {
		///Map<Test,Object>  map=new HashMap<>();
		Map<Test,Object>  map=new WeakHashMap();
		testWeekHashMap(map);
	
	}
	
	public static void testWeekHashMap(Map<Test, Object> map) {
		Test key= new Test();
		String value="India";
		map.put(key, value);
		System.out.println(map);
		key=null;
		System.out.println(map);
		System.gc();
		try {
			Thread.sleep(10000);	
		}catch (Exception e) {
			// TODO: handle exception
		}
	
		System.out.println(map);
	}

}
