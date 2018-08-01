package com.adam.map.test.classLoader;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MyClassLoader extends ClassLoader{

	private final static Path DEFAULT_PATH = Paths.get("D","classloader");
	
	private final Path classDir;
	
	public MyClassLoader() {
		// TODO Auto-generated constructor stub
		super();
		this.classDir = DEFAULT_PATH; 
	}
	
	public MyClassLoader(String path){
		
		super();
		this.classDir = Paths.get(path);
	}
	
	//通过classLoader definedClass 返回class对象
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		byte[] classBytes = this.readClassBytes(name);
		if(null == classBytes || classBytes.length==0){
			throw new ClassNotFoundException("the class "+name +" not found");
		}
		
		return this.defineClass(name, classBytes, 0,classBytes.length);
	}
	
	//读取文件字节流
	private byte[] readClassBytes(String name) throws ClassNotFoundException{
		
		String classPath = name.replace(".", "/");
		Path classFullPath = classDir.resolve(Paths.get(classPath+".class"));
		if(!classFullPath.toFile().exists()){
			throw new ClassNotFoundException("the class "+name +" not found");
		}
		
		try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
			
			Files.copy(classFullPath, outputStream);
			return outputStream.toByteArray();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ClassNotFoundException("the class "+name +" not found");
		}
	}
	
	public String toString(){
		
		return "My Class Loader";
	}
	
	public static void main(String[] args) throws ClassNotFoundException,IllegalArgumentException,InstantiationException,NoSuchMethodException,InvocationTargetException, IllegalAccessException{
		
		
		MyClassLoader loader = new MyClassLoader("D://classloader");
		
		Class<?> aClass = loader.loadClass("Hello");
		
		System.out.println(aClass.getClassLoader());
		
		Object object = aClass.newInstance();
		System.out.println(object);
		
		Method method = aClass.getMethod("welcome", null);
		String result = (String)method.invoke(object,null);
		System.out.println("result is :"+result);
		
	}
}
