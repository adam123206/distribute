package rcptest.jobs;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class FirstJob extends Job{

	public FirstJob(String name) {
		super(name);
		//����ϵͳjob�������ػ��߳�;�������ö���schedule֮ǰ������Ч��
		//setSystem(true); 
		// TODO Auto-generated constructor stub
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		for (int i=0;i<100;i++) {
			
			System.out.println("job is running");
			
		}
		return Status.OK_STATUS;
	}

}
