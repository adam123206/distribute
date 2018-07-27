package com.adam.map.test;

import java.util.HashMap;
import java.util.Iterator;


public class MapTest {

	public static void main(String[] args) throws Exception{
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		if (map.get("test") == null ) {
			
			map.put("test", "test");
		}
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String tmp = iterator.next();
		}
		int MAXIMUM_CAPACITY = 1 << 30 ;
		int MIXIMUM_CAPACITY = 17 >> 2 ;
		System.out.println(MAXIMUM_CAPACITY);
		System.out.println(MIXIMUM_CAPACITY);
	}
}
