package com.adam.map.test;

import java.util.concurrent.TimeUnit;


public class CaptureThreadException {

	public static void main(String[] args) {
		
		Thread.setDefaultUncaughtExceptionHandler((t,e) -> {
			
			System.out.println(t.getName() + "occure exception ");
			e.printStackTrace();
		});
		
		final Thread thread = new Thread(() -> {
			try
			{
				TimeUnit.SECONDS.sleep(2);
			}catch(InterruptedException e){
				
			}
			System.out.println(1/0);
		},"testThread");
		
		thread.start();
	}
}
