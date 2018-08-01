package com.adam.map.test.classLoader;

import java.util.concurrent.TimeUnit;

public class VolatileFoo {

	private final static int max = 5;
	
	private volatile static int init_value= 0;
	
	public static void main(String[] args) {
		
		new Thread(() ->{
			
			int localValue = init_value;
			while(localValue < max){
				
				if(init_value != localValue){
					
					System.out.printf("the init_value is update to [%d]\n" , localValue);
					localValue = init_value;
				}
			}
		},"Reader").start();
		
		new Thread(() -> {
			
			int localValue = init_value;
			while(localValue < max){
				
				System.out.printf("the init_value will change to %d\n",localValue);
				init_value = localValue;
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (Exception e) {
					// TODO: handle exception
				}
				localValue++;
			}
			
		},"update").start();
	}
}
