package com.adam.map.test.myThreadPool.lifeCycle;


public class ObservableThread<T> extends Thread implements Observable{

	private final TaskLifecycle<T> lifecycle;
	
	private final Task<T> task;
	
	private Cycle cycle;
	
	public ObservableThread(Task<T> task) {
		// TODO Auto-generated constructor stub
		this(new TaskLifecycle.EmptyLifecycle<T>(), task);
	}
	
	public ObservableThread(TaskLifecycle<T> lifecycle,Task<T> task){
		
		super();
		if(task == null)
			throw new IllegalArgumentException();
		
		this.lifecycle = lifecycle;
		this.task = task;
	}
	
	@Override
	public final void run(){
		
		this.update(Cycle.started, null, null);
		try {
			this.update(Cycle.running, null, null);
			T result = this.task.call();
			this.update(Cycle.done,result, null);
		} catch (Exception e) {
			// TODO: handle exception
			this.update(Cycle.error, null, e);
		}
	}
	@Override
	public Cycle getCycle() {
		// TODO Auto-generated method stub
		return this.cycle;
	}

	@Override
	public void interrupt() {
		// TODO Auto-generated method stub
		super.interrupt();
	}
	
	private void update(Cycle cycle,T result,Exception e){
		
		this.cycle = cycle;
		if(lifecycle == null)
			return ;
		
		try {
			switch (cycle) {
			case started:
				this.lifecycle.onStart(currentThread());
				break;
			case running:
				this.lifecycle.onRunning(currentThread());
				break;
			case done:
				this.lifecycle.onFinish(currentThread());
				break;
			case error:
				this.lifecycle.onError(currentThread());
				break;
			default:
				break;
			}
		} catch (Exception e2) {
			
			if (cycle == Cycle.error) {
				
				throw e2;
			}
		}
	}
	

}
