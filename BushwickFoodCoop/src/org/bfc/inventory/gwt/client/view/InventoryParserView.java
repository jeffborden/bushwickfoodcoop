package org.bfc.inventory.gwt.client.view;

import com.google.gwt.user.client.ui.IsWidget;


public interface InventoryParserView extends IsWidget{

	public abstract void setPresenter(InventoryParserPresenter presenter);
	public abstract void setTextAreaContents(String inputText);
	
	public static interface InventoryParserPresenter{
		public void handleSubmitButtonPressed(String inputText);
	}

}