package com.adam.map.test.myThreadPool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Test {

	
	public static void main(String[] args) throws Exception{
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		
		
		final ThreadPool pool = new BasicThreadPool(2, 6, 4, 1000);
		for (int i = 0; i < 20; i++) {
			
			pool.execute(() -> {
				
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			});
		}
		
		for (;;) {
			
			System.out.println("active count"+ pool.getActiveCount());
			System.out.println("queue size"+ pool.getQueueSize());
			System.out.println("core size"+ pool.getCoreSize());
			System.out.println("max size"+ pool.getMaxSize());
			TimeUnit.SECONDS.sleep(5);
		}
		
		
		
	}
	
}
