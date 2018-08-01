package com.adam.map.test.myThreadPool.lifeCycle;

import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {
		
		Observable observable = new ObservableThread<>(new Task<Thread>() {

			@Override
			public Thread call() {
				// TODO Auto-generated method stub
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("finfish");
				return null;
			}
		});
		
		observable.start();
	}
}
