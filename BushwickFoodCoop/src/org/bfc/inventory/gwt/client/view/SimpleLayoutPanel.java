package org.bfc.inventory.gwt.client.view;


import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;

/*  Workaround to issue w/ adding LayoutPanels to SimplePanels, 
 *  need an implementation of AcceptsOneWidget for ActivtyManager implementations
 *  http://www.tempura.org/rants/2010/10/using-layoutpanels-with-gwt-2-1s-activitymanager/
 * 
 */

public class SimpleLayoutPanel extends LayoutPanel implements AcceptsOneWidget {

	private IsWidget widget = null; 
	
	/*
	 * Since Javascript UI operates on a single thread, this does not need to be mutexed:
	 * http://groups.google.com/group/google-web-toolkit/browse_thread/thread/757fd8eb8b2a54c7
	 */
	private int childCount = 0;	
	

	@Override
	public void setWidget(IsWidget w) {
		if (widget != null) {
			if(widget.equals(w)){
				return;
			}			
			super.remove(widget);
		}
		widget = w;
		if(w != null){
			super.add(w);
		}
	}
	
	@Override
	public void insert(Widget w, int beforeIndex) {
		if(childCount >= 1){
			/**
			 * TODO: ADD LOGGING TO INDICATE THAT THE METHOD FAILED
			 */
		}else{
			super.insert(w, beforeIndex);
			childCount++;
		}
	}

	@Override
	public boolean remove(Widget w) {
		if(childCount > 0){
			childCount--;
		}
		return super.remove(w);
	}

	@Override
	public boolean remove(int index) {
		if(childCount > 0){
			childCount--;
		}
		return super.remove(index);
	}

}