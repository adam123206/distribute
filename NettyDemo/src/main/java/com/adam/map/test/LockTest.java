package com.adam.map.test;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class LockTest {

	private BooleanLock lock = new BooleanLock();
	
	public void synMehtod() {
		
		try {
			lock.lock();
			int randomInt = new Random().nextInt(10);
			System.out.println(Thread.currentThread() + " get the lock");
			TimeUnit.SECONDS.sleep(randomInt);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		LockTest test = new LockTest();
		IntStream.range(1,10).mapToObj(i -> new Thread(test::synMehtod)).forEach(Thread::start);
			
	}
}
