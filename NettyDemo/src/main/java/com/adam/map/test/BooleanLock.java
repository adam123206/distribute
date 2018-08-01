package com.adam.map.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

public class BooleanLock implements Lock{

	private Thread  currentThread;
	private boolean  locked = false;
	private final List<Thread> lockedList = new ArrayList<Thread>();
	@Override
	public void lock() throws InterruptedException {
		// TODO Auto-generated method stub
		
		synchronized(this){
			
			while(locked){
				
				if (!lockedList.contains(Thread.currentThread())) {
					
					lockedList.add(Thread.currentThread());
					this.wait();
				}
				
			}
			
			lockedList.remove(currentThread);
			this.locked = true;
			this.currentThread = Thread.currentThread();
		}
	}

	@Override
	public void lock(long mills) throws InterruptedException, TimeoutException {
		// TODO Auto-generated method stub
		synchronized(this){
			
			if(mills<0){
				
				this.lock();
			}else{
				
				long remainingMills = mills;
				long endMills = System.currentTimeMillis()+remainingMills;
				
				while(locked){
					
					if(remainingMills < 0){
						
						throw new TimeoutException();
					}
					
					if (!lockedList.contains(Thread.currentThread())) {
						
						lockedList.add(Thread.currentThread());
					}
					this.wait(remainingMills);
					remainingMills = endMills - System.currentTimeMillis();
				}
				lockedList.remove(Thread.currentThread());
				this.locked = true;
				this.currentThread = Thread.currentThread();
				
			}
		}
	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		synchronized(this){
			
			if(currentThread == Thread.currentThread()){
				this.locked = false;
				System.out.println(Thread.currentThread() +" releas the lock");
				this.notifyAll();
			}
		}
	}

	@Override
	public List<Thread> getBlockedThreads() {
		// TODO Auto-generated method stub
		return java.util.Collections.unmodifiableList(lockedList);
	}

}
