package rcptest.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class TopView extends ViewPart{

	public final static String ID = "rcptest.view.TopView";
	
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		
		RowLayout layout = new RowLayout();
		//设置组件大小相同，默认组件大小不相同
		layout.pack = false;
		//组件间距随截面大小而变化，默认为false
		layout.justify = true;
		parent.setLayout(layout);
		
		//用来改变组件外观，大小
		RowData rowData = new RowData(30, 50);
		Button button = new Button(parent, SWT.NONE);
		button.setLayoutData(rowData);
			button.setText("button 11234567");
			
		new Button(parent, SWT.NONE).setText("button test 2");
		new Button(parent, SWT.NONE).setText("button 3");
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
