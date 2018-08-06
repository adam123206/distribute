package rcptest.view.menuView;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.part.ViewPart;

public class MenuOne extends ViewPart{

	public final static String id="rcptest.view.menuView.MenuOne";
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		ViewForm viewForm = new ViewForm(parent, SWT.NONE);
		viewForm.setLayoutData(new FillLayout());
		
		final Text text = new Text(viewForm, SWT.BORDER |SWT.WRAP |SWT.V_SCROLL );
		viewForm.setContent(text);
		
		ToolBar toolBar = new ToolBar(viewForm, SWT.FLAT);
		ToolItem getItem = new ToolItem(toolBar, SWT.PUSH);
		getItem.setText("get");
		getItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				MessageDialog.openInformation(parent.getShell(), "info", ((ToolItem)e.getSource()).getText());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ToolItem clearItem = new ToolItem(toolBar, SWT.PUSH);
		clearItem.setText("clear");
		clearItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				MessageDialog.openInformation(parent.getShell(), "info", ((ToolItem)e.getSource()).getText());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		viewForm.setTopRight(toolBar);
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
