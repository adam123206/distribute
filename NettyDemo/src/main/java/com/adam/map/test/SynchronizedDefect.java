package com.adam.map.test;

import java.util.concurrent.TimeUnit;

public class SynchronizedDefect {

	public void synMehtod() {

		try {
			System.out.println(Thread.currentThread().getName()+" is going to get monitor");
			synchronized (this) {
				System.out.println(Thread.currentThread().getName() + " get monitor ");
				TimeUnit.HOURS.sleep(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		final SynchronizedDefect defect = new SynchronizedDefect();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				defect.synMehtod();
			}
		}, "T1");
		t1.start();
		TimeUnit.MICROSECONDS.sleep(2);

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				defect.synMehtod();
			}
		}, "T2");
		t2.start();
	}

}
