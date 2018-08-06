package rcptest.view.menuView;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.part.ViewPart;
import org.omg.PortableInterceptor.NON_EXISTENT;

public class MenuTwo extends ViewPart{

	public final static String id="rcptest.view.menuView.MenuTwo";
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		
		final ViewForm viewForm =new ViewForm(parent, SWT.None);
		viewForm.setLayoutData(new FillLayout());
		
		CoolBar collbar = new CoolBar(viewForm, SWT.NONE);
		{
			ToolBar toolBar = new ToolBar(collbar, SWT.NONE);
			ToolItem getItem = new ToolItem(toolBar,SWT.NONE);
			getItem.setText("getting");
			
			ToolItem clearItem = new ToolItem(toolBar, SWT.NONE);
			clearItem.setText("clearing");
			
			CoolItem coolItem = new CoolItem(collbar, SWT.NONE);
			coolItem.setControl(toolBar);
			
			toolBar.pack();
			Point size = toolBar.getSize();
			coolItem.setSize(size);
			coolItem.setMinimumSize(size);
		}
		{
			
			ToolBar toolBar = new ToolBar(collbar, SWT.FLAT);
			ToolItem item = new ToolItem(toolBar, SWT.NONE);
			item.setText("three item");
			CoolItem coolItem = new CoolItem(collbar, SWT.NONE);
			coolItem.setControl(toolBar);
			toolBar.pack();
			Point size = toolBar.getSize();
			coolItem.setSize(size);
			coolItem.setMinimumSize(size);
		}
		{
			Combo combo = new Combo(collbar, SWT.BORDER);
			combo.add("http://localhost:80809");
			combo.select(0);
			CoolItem item = new CoolItem(collbar, SWT.None);
			item.setControl(combo);
			
			Point size = combo.getSize();
			item.setSize(size);
			item.setMinimumSize(size);
			
		}	
			
		viewForm.setTopLeft(collbar);
		collbar.addControlListener(new ControlListener() {
			
			@Override
			public void controlResized(ControlEvent e) {
				// TODO Auto-generated method stub
				viewForm.layout();
				System.out.println("method in control");
			}
			
			@Override
			public void controlMoved(ControlEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
