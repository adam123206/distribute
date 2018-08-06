package rcptest.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class BottomView extends ViewPart{

	public final static String id = "rcptest.view.BottomView";
	private Label label;
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		//参数：列数，等距分隔
		/*GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 5;
		gridLayout.marginHeight = 5;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		parent.setLayout(gridLayout);
		
		new Button(parent, SWT.NONE).setText("button 1");
		new Button(parent, SWT.NONE).setText("button 2");
		
		Button button3 = new Button(parent, SWT.NONE);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan = 2;
		button3.setText("button 3");
		button3.setLayoutData(gridData);*/
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

	
}
