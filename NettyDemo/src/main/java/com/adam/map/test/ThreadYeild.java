package com.adam.map.test;

import java.util.stream.IntStream;

public class ThreadYeild {

	public static void main(String[] args) {
		
		//IntStream.range(0, 2).mapToObj(ThreadYeild::create).forEach(Thread::start);
		Thread t1 = new Thread(() -> {
			
			System.out.println(Thread.currentThread().getName() + "is running");
		}) ;
		t1.setPriority(3);
		
		Thread t2 = new Thread(() -> {
			
			System.out.println(Thread.currentThread().getThreadGroup().getMaxPriority());
		}) ;
		t2.setPriority(4);
		
		t1.start();
		t2.start();
	}
	
	private static Thread create(int index){
		
		return new Thread(() -> { 
			System.out.println(index);
		});
	}
}
