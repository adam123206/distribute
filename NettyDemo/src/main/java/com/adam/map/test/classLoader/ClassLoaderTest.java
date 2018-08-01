package com.adam.map.test.classLoader;

public class ClassLoaderTest {

	public static void main(String[] args) {
		
		System.out.println("System bootstrap classloader " +String.class.getClassLoader());
		System.out.println("class path "+System.getProperty("sun.boot.class.path"));
		System.out.println("extendsion classloader "+System.getProperty("java.ext.dirs"));
		System.out.println("application classloader "+System.getProperty("java.class.path"));
		System.out.println("application classloader "+ClassLoaderTest.class.getClassLoader());
	}
}
