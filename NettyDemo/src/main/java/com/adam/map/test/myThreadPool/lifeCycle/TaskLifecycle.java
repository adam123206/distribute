package com.adam.map.test.myThreadPool.lifeCycle;

public interface TaskLifecycle<T> {

	void onStart(Thread thread);
	
	void onRunning(Thread thread);
	
	void onFinish(Thread thread);
	
	void onError(Thread thread);
	
	class EmptyLifecycle<T> implements TaskLifecycle<T>{

		@Override
		public void onStart(Thread thread) {
			// TODO Auto-generated method stub
			System.out.println(thread.getName() + " started ");
		}

		@Override
		public void onRunning(Thread thread) {
			// TODO Auto-generated method stub
			System.out.println(thread.getName() + " is running  ");
		}

		@Override
		public void onFinish(Thread thread) {
			// TODO Auto-generated method stub
			System.out.println(thread.getName() + " is finish ");
		}

		@Override
		public void onError(Thread thread) {
			// TODO Auto-generated method stub
			System.out.println(thread.getName() + " error ");
		}
	}
}
