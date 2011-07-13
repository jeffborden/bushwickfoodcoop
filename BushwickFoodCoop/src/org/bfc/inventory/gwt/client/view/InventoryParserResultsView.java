package org.bfc.inventory.gwt.client.view;

import com.google.gwt.user.client.ui.IsWidget;


public interface InventoryParserResultsView extends IsWidget{

	public abstract void setPresenter(InventoryParserResultsPresenter presenter);
	public abstract void setOutputTextAreaContents(String text);
	
	public static interface InventoryParserResultsPresenter{
		public void handleReturnButtonPressed();
	}

}