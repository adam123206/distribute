package com.adam.map.test;

import java.util.concurrent.TimeUnit;

public class ThreaHook {

	public static void main(String[] args) {
		
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			
			public void run(){
				
				try {
					System.out.println("the hook thread 1 is running");
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println("the hook thread 1 will exit");
			}
		});
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			
			public void run(){
				
				try {
					System.out.println("the hook thread 2 is running");
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println("the hook thread 2 will exit");
			}
		});
		
		System.out.println("jvm finish working ");
	}
}
