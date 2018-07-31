package com.adam.ThreadTest;

public class MainTest {

	
	public static void main(String[] args) {
		
		Thread oneThread = new Thread(new Test());
		oneThread.start();
	}
	
	public static class Test implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread()+" is running ");
		}
	}
}
