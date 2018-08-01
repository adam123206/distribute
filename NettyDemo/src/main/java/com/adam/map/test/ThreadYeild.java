package com.adam.map.test;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadYeild {

	public static void main(String[] args) throws InterruptedException{
		
		//IntStream.range(0, 2).mapToObj(ThreadYeild::create).forEach(Thread::start);
		/*Thread t1 = new Thread(() -> {
			
			System.out.println(Thread.currentThread().getName() + "is running");
		}) ;
		t1.setPriority(3);
		
		Thread t2 = new Thread(() -> {
			
			System.out.println(Thread.currentThread().getThreadGroup().getMaxPriority());
		}) ;
		t2.setPriority(4);
		
		t1.start();
		t2.start();*/
		
		Thread t1 = new Thread(() -> {
			
			int i=0;
			for(;i<10;i++){
				
				System.out.println("thread 1 running ");
			}
			
		});
		
		t1.start();
		
		Thread.currentThread().join();
		
		for (int i = 0; i < 20; i++) {
			
			System.out.println("main thread running");
		}
		
		
	}
	
	private static Thread create(int index){
		
		return new Thread(() -> { 
			System.out.println(index);
		});
	}
}
