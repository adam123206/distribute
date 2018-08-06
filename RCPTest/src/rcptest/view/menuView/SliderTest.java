package rcptest.view.menuView;

import org.eclipse.swt.widgets.*;

import java.util.concurrent.TimeUnit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class SliderTest extends ViewPart{

	public final static String id = "rcptest.view.menuView.SliderTest";
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		
		parent.setLayout(new RowLayout());
		final Text text = new Text(parent, SWT.BORDER);
		
		final Slider slider = new Slider(parent, SWT.NONE);
		slider.setMinimum(0);
		slider.setMaximum(100);
		slider.setIncrement(5);
		slider.setPageIncrement(10);
		slider.setSelection(25);
		
		slider.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				int value = slider.getSelection();
				text.setText(value+"");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		final Scale scale = new Scale(parent, SWT.HORIZONTAL);
		scale.setMaximum(100);
		scale.setIncrement(5);
		scale.setSelection(10);
		scale.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(scale.getSelection());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		final ProgressBar bar = new ProgressBar(parent, SWT.SMOOTH);
		bar.setMinimum(0);
		bar.setMaximum(100);
		Button button = new Button(parent, SWT.BUTTON1);
		button.setText("start");
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				for(int i=1;i<11 ;i++){
					
					bar.setSelection(i*10);
					try{
						TimeUnit.SECONDS.sleep(1);
					}catch(InterruptedException e2){
						e2.printStackTrace();
					}
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
