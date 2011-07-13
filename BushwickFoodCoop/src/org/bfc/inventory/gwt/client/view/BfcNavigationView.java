package org.bfc.inventory.gwt.client.view;

import org.bfc.inventory.gwt.shared.NavigationListType;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.view.client.SingleSelectionModel;

public interface BfcNavigationView  extends IsWidget{
	public SimpleLayoutPanel getContentsTablePanel();
	public void setPresenter(BfcNavigationPresenter presenter);
	public SingleSelectionModel<NavigationListType> getNavigationPanelSelectionModel();
	
	public static interface BfcNavigationPresenter{
		public void handleNavListTypeSelected(NavigationListType navType);
	}
}
