package rcptest.view;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import rcptest.view.menuView.MenuOne;
import rcptest.view.menuView.MenuThree;
import rcptest.view.menuView.MenuTwo;
import rcptest.view.menuView.SliderTest;


public class LeftView extends ViewPart{

	public final static String ID = "rcptest.view.LeftView";
	
	@Override
	public void createPartControl(Composite parent) {
		
		List list = new List(parent, SWT.NONE);
		list.add("toolbar test");
		list.add("CoolBar test");
		list.add("pop up menu test");
		list.add("slider  scale progress test");
		list.addSelectionListener(new MenuSelectionListiner());
		// TODO Auto-generated method stub
		/*Button botton = new Button(parent,SWT.BOTTOM);
		
		botton.setBounds(10, 130, 100, 25);
		botton.setToolTipText("点击按钮事件");
		
		Button check = new Button(parent, SWT.CHECK);
		check.setBounds(10, 15, 5, 5);
		check.setText("复选框");
		
		Button raido = new Button(parent, SWT.RADIO);
		raido.setBounds(10, 20, 5, 5);
		raido.setText("radio box");
		raido.setToolTipText("选择");*/
		
		/*Label label = new Label(parent, SWT.NONE);
		label.setBackground(Display.getCurrent().getSystemColor(29));
		label.setBounds(20, 30, 20, 10);
		label.setText("this is test for label");*/
		
		/*Text text  = new Text(parent, SWT.BORDER);
		text.setTextLimit(10);
		text.addVerifyListener(new VerifyListener() {
			
			@Override
			public void verifyText(VerifyEvent e) {
				// TODO Auto-generated method stub
				String code = e.text;//当前输入字符
				System.out.println(code);
			}
		});*/
		
		/*Combo combox = new Combo(parent, SWT.READ_ONLY);
		combox.add("test1");
		combox.add("test2");
		combox.setData("test3", "test3");
		combox.add("test4");
		combox.select(0);
		combox.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				Combo box = (Combo)e.getSource();
				System.out.println(box.getSelectionIndex());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});*/
		/*FillLayout layout = new FillLayout(SWT.VERTICAL);
		
		
		parent.setLayout(layout);
		Button button = new Button(parent,SWT.NONE);
		button.setText("button one");
		
		Button button2 = new Button(parent,SWT.NONE);
		button2.setText("button two");*/
		
	}
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		//FirstJob myJob = new FirstJob("myFirstJob");
		//myJob.schedule();
	}
	
	private class MenuSelectionListiner implements SelectionListener {

		@Override
		public void widgetSelected(SelectionEvent e){
			// TODO Auto-generated method stub
			List list = (List)e.getSource();
			try{
				
			
			switch(list.getSelectionIndex()){
			
			case 0:
				PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getActivePage().showView(MenuOne.id);
				break;
			case 1:
				PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getActivePage().showView(MenuTwo.id);
				break;
			case 2:
				PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getActivePage().showView(MenuThree.id);
				break;
			case 3:
				PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getActivePage().showView(SliderTest.id);
				break;
			}
			}catch(Exception e1){
				
				e1.printStackTrace();
			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

}
