package rcptest;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import rcptest.view.BottomView;
import rcptest.view.LeftView;
import rcptest.view.TopView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);
		String editorArea = layout.getEditorArea();
		layout.addStandaloneView(LeftView.ID, true, IPageLayout.LEFT, 0.25f, editorArea);
		layout.getViewLayout(LeftView.ID).setCloseable(false);
		
		layout.addStandaloneView(BottomView.id, true, IPageLayout.BOTTOM, 0.45f, editorArea);
		layout.getViewLayout(BottomView.id).setCloseable(false);
		
		layout.addStandaloneView(TopView.ID, true, IPageLayout.TOP, 0.5f, editorArea);
		layout.getViewLayout(TopView.ID).setCloseable(false);
	}

}
