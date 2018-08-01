package com.adam.map.test.myThreadPool;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;



public class BasicThreadPool extends Thread implements ThreadPool{

	private final int maxSize;
	private final int initSize;
	private final int coreSize;
	private int activeSize;
	private final RunnableQueue runnableQueue;
	private volatile boolean isShutdown = false;
	
	private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();
	
	private final static DenyPolicy denyPolicy = new DenyPolicy.AbortDenyPolicy();
	
	private static ThreadFactory threadFactory = new ThreadFactory.DefaultThreadFactory();

	private final long keepAliveTime;
	
	private final TimeUnit timeUnit;
	
	
	public BasicThreadPool(int initSize,int maxSize,int coreSize,int queueSize) {
		// TODO Auto-generated constructor stub
		this(initSize, maxSize, coreSize, threadFactory, queueSize, denyPolicy, 10, TimeUnit.SECONDS);
	}
	
	public BasicThreadPool(int initSize,int maxSize,int coreSize,ThreadFactory threadFactory,int queueSize,DenyPolicy denyPolicy,long keeyAliveTime,TimeUnit timeUnit){
		
		this.initSize = initSize;
		this.maxSize = maxSize;
		this.coreSize =  coreSize;
		this.threadFactory = threadFactory;
		this.runnableQueue = new LinkedRunnableQueue(queueSize, denyPolicy, this);
		this.keepAliveTime = keeyAliveTime;
		this.timeUnit = timeUnit;
		this.Init();
	}
	
	public void Init(){
		
		start();
		for (int i = 0; i < this.initSize; i++) {
			
			newThread();
		}
	}
	
	private void newThread() {
		// TODO Auto-generated method stub
		
		InternalTask task = new InternalTask(runnableQueue);
		Thread thread = this.threadFactory.createThread(task);
		ThreadTask threadTask = new ThreadTask(thread,task);
		threadQueue.offer(threadTask);
		this.activeSize++;
		thread.start();
	}

	@Override
	public void execute(Runnable runnable) {
		// TODO Auto-generated method stub
		
		if(this.isShutdown){
			
			throw new IllegalStateException("illega state exception");
		}
		this.runnableQueue.offer(runnable);
	}
	
	private void removeThread(){
		
		ThreadTask task = threadQueue.remove();
		task.task.stop();
		this.activeSize--;
	}

	@Override
	public void shudown() {
		// TODO Auto-generated method stub
		synchronized(this)
		{
			if(isShutdown){
				
				return;
			}
			isShutdown = true;
			threadQueue.forEach(threadTask -> {
				
				threadTask.task.stop();
				threadTask.thread.interrupt();
			});
			this.interrupt();
		}
	}

	@Override
	public int getInitSize() {
		// TODO Auto-generated method stub
		if(isShutdown)
			throw new IllegalArgumentException("wrong ");
		
		return this.initSize;
	}

	@Override
	public int getMaxSize() {
		// TODO Auto-generated method stub
		if(isShutdown)
			throw new IllegalArgumentException("wrong ");
		
		return this.maxSize;
	}

	@Override
	public int getCoreSize() {
		// TODO Auto-generated method stub
		if(isShutdown)
			throw new IllegalArgumentException("wrong ");
		
		return this.coreSize;
	}

	@Override
	public int getQueueSize() {
		if(isShutdown)
			throw new IllegalArgumentException("wrong ");
		
		return this.runnableQueue.size();
	}

	@Override
	public int getActiveCount() {
		if(isShutdown)
			throw new IllegalArgumentException("wrong ");
		synchronized(this){
			
			return this.activeSize;
		}
	}

	@Override
	public boolean isShutdown() {
		// TODO Auto-generated method stub
		return this.isShutdown;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!isShutdown && !isInterrupted()){
			
			try {
				timeUnit.sleep(keepAliveTime);
			} catch (Exception e) {
				// TODO: handle exception
				isShutdown = true;
				break;
			}
			
			synchronized(this){
				
				if(isShutdown){
					
					if(runnableQueue.size()>0 && activeSize <coreSize){
						
						for (int i = initSize; i < coreSize; i++) {
							
							newThread();
						}
						continue;
					}
					
					if(runnableQueue.size()>0 && activeSize < maxSize){
						
						for (int i = coreSize; i < maxSize; i++) {
							
							newThread();
						}
						
					}
					
					if(runnableQueue.size()==0 && activeSize>coreSize){
						
						for (int i = coreSize; i < activeSize; i++) {
							
							removeThread();
						}
					}
				}
			}
		}
	}
	
	private static class ThreadTask{
		
		Thread thread;
		InternalTask task;
		public ThreadTask(Thread thread,InternalTask task){
			
			this.thread = thread;
			this.task = task;
		}
	}
	
}
