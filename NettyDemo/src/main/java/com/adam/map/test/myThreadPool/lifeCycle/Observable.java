package com.adam.map.test.myThreadPool.lifeCycle;

public interface Observable {

	enum Cycle {
		
		started,running,done,error
	}
	
	public Cycle getCycle();
	
	public void start();
	
	public void interrupt();
	
}
