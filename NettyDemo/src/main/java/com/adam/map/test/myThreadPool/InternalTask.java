package com.adam.map.test.myThreadPool;


public class InternalTask implements Runnable{

	private final RunnableQueue runnableQueue;
	
	private volatile boolean running = false;
	
	public InternalTask(RunnableQueue queue){
		
		this.runnableQueue = queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(running && !Thread.currentThread().isInterrupted()){
			
			try {
				
				Runnable task = runnableQueue.take();
				task.run();
			} catch (Exception e) {
				
				running = false;
				break;
			}
		}
	}
	
	public void stop(){
		
		this.running = false;
	}

}
