package com.adam.map.test.myThreadPool;

import java.util.LinkedList;

public class LinkedRunnableQueue implements RunnableQueue{

	private final int limit;
	
	private final DenyPolicy denpolicy;
	
	private final LinkedList<Runnable> runnableList = new LinkedList<>();
	
	private final ThreadPool threadPool;
	
	public LinkedRunnableQueue(int limit,DenyPolicy denyPolicy,ThreadPool threadPool){
		
		this.limit = limit;
		this.denpolicy = denyPolicy;
		this.threadPool = threadPool;
	}
	
	@Override
	public void offer(Runnable runnable) {
		// TODO Auto-generated method stub
		synchronized(runnableList){
			
			if(runnableList.size() > limit){
				
				denpolicy.reject(runnable, threadPool);
			}else{
				
				runnableList.addLast(runnable);
				runnableList.notifyAll();
			}
		}
	}

	@Override
	public Runnable take() {
		// TODO Auto-generated method stub
		synchronized(runnableList){
			
			while(runnableList.isEmpty()){
				
				try {
					runnableList.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return runnableList.removeFirst();
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		synchronized(runnableList){
			
			return runnableList.size();
		}
	}
}
