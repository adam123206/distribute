package com.adam.map.test.myThreadPool;


@FunctionalInterface
public interface DenyPolicy {

	void reject(Runnable runnable,ThreadPool threadPool);
	
	class DiscardDenyPoicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
	class AbortDenyPolicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool){
			// TODO Auto-generated method stub
			throw new RunnableDenyException("the runnable "+runnable);
		}
	}
	
	class RunnerDenyPolicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			// TODO Auto-generated method stub
			
			if(!threadPool.isShutdown()){
				
				runnable.run();
			}
		}
		
		
	}
	
}
