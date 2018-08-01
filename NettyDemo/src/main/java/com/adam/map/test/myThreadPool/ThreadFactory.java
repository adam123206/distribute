package com.adam.map.test.myThreadPool;

@FunctionalInterface
public interface ThreadFactory {

	Thread createThread(Runnable runnable);
	
	public class DefaultThreadFactory implements ThreadFactory{

		
		@Override
		public Thread createThread(Runnable runnable) {
			// TODO Auto-generated method stub
			return new Thread(runnable);
		}
	}
}
