package org.bfc.inventory.gwt.client.factory;

import org.bfc.inventory.gwt.client.service.BfcServiceAsync;
import org.bfc.inventory.gwt.client.view.BfcNavigationView;
import org.bfc.inventory.gwt.client.view.InventoryParserResultsView;
import org.bfc.inventory.gwt.client.view.InventoryParserView;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory {
	BfcServiceAsync getBfcService();
	
	EventBus getEventBus();
	PlaceController getPlaceController();	
		
	BfcNavigationView getBfcNavigationView();
	
	InventoryParserView getResetInventoryView();
	InventoryParserResultsView getResetInventoryResultsView();
	
	InventoryParserView getAppendInventoryView();
	InventoryParserResultsView getAppendInventoryResultsView();
}
