package com.adam.map.test.classLoader;

public class ThreadContextClassLoader {

	public static void main(String[] args) {
		
		System.out.println(System.class.getClassLoader());
		System.out.println(Class.class.getClassLoader());
		System.out.println(ThreadContextClassLoader.class.getClassLoader());
		System.out.println(Thread.currentThread().getContextClassLoader());
		
		
	}
}
