package com.adam.map.test.myThreadPool;

public interface ThreadPool {

	public void execute(Runnable runnable);
	
	public void shudown();
	
	public int getInitSize();
	
	public int getMaxSize();
	
	public int getCoreSize();
	
	public int getQueueSize();
	
	public int getActiveCount();
	
	boolean isShutdown();
}
