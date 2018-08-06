package rcptest.view.menuView;



import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.part.ViewPart;

public class MenuThree extends ViewPart{

	//view里只能添加弹出菜单，不能添加菜单栏
	public final static String id ="rcptest.view.menuView.MenuThree";
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		
		
		Menu menu  = new Menu(parent.getShell(),SWT.POP_UP);
		menu.setEnabled(true);
		parent.setMenu(menu);
		//parent.getShell().setMenuBar(menu);
		
		MenuItem fileItem = new MenuItem(menu, SWT.CASCADE);
		fileItem.setText("文件(&F)");
		MenuItem helpItem = new MenuItem(menu, SWT.CASCADE);
		helpItem.setText("帮助(&H)");
		
		Menu fileMenu= new Menu(parent.getShell(), SWT.DROP_DOWN);
		fileItem.setMenu(fileMenu);
		
		MenuItem newFileItem = new MenuItem(fileMenu, SWT.CASCADE);
		newFileItem.setText("新建");
		
		MenuItem exitFileItem = new MenuItem(fileMenu, SWT.CASCADE);
		exitFileItem.setText("退出");
		
		Menu newFileMenu = new Menu(parent.getShell(),SWT.DROP_DOWN);
		newFileItem.setMenu(newFileMenu);
		
		MenuItem newProject = new MenuItem(newFileMenu, SWT.CASCADE);
		newProject.setText("项目");
		//设置快捷键
		//newProject.setAccelerator(accelerator);
		
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
