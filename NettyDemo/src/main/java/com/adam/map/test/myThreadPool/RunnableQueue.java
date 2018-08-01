package com.adam.map.test.myThreadPool;

public interface RunnableQueue {

	void offer(Runnable runnable);
	
	Runnable take();
	
	int size();
}
