package rcptest.view.menuView;



import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.part.ViewPart;

public class MenuThree extends ViewPart{

	//view��ֻ����ӵ����˵���������Ӳ˵���
	public final static String id ="rcptest.view.menuView.MenuThree";
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		
		
		Menu menu  = new Menu(parent.getShell(),SWT.POP_UP);
		menu.setEnabled(true);
		parent.setMenu(menu);
		//parent.getShell().setMenuBar(menu);
		
		MenuItem fileItem = new MenuItem(menu, SWT.CASCADE);
		fileItem.setText("�ļ�(&F)");
		MenuItem helpItem = new MenuItem(menu, SWT.CASCADE);
		helpItem.setText("����(&H)");
		
		Menu fileMenu= new Menu(parent.getShell(), SWT.DROP_DOWN);
		fileItem.setMenu(fileMenu);
		
		MenuItem newFileItem = new MenuItem(fileMenu, SWT.CASCADE);
		newFileItem.setText("�½�");
		
		MenuItem exitFileItem = new MenuItem(fileMenu, SWT.CASCADE);
		exitFileItem.setText("�˳�");
		
		Menu newFileMenu = new Menu(parent.getShell(),SWT.DROP_DOWN);
		newFileItem.setMenu(newFileMenu);
		
		MenuItem newProject = new MenuItem(newFileMenu, SWT.CASCADE);
		newProject.setText("��Ŀ");
		//���ÿ�ݼ�
		//newProject.setAccelerator(accelerator);
		
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
