package com.adam.map.test;

import java.util.List;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

public interface Lock {

	public void lock() throws InterruptedException;
	
	public void lock(long mills) throws InterruptedException,TimeoutException;
	
	public void unlock();
	
	public List<Thread> getBlockedThreads();
}
