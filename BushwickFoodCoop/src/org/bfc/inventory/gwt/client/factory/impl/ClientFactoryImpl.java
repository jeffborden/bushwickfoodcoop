package org.bfc.inventory.gwt.client.factory.impl;

import org.bfc.inventory.gwt.client.factory.ClientFactory;
import org.bfc.inventory.gwt.client.service.BfcService;
import org.bfc.inventory.gwt.client.service.BfcServiceAsync;
import org.bfc.inventory.gwt.client.view.BfcNavigationView;
import org.bfc.inventory.gwt.client.view.InventoryParserResultsView;
import org.bfc.inventory.gwt.client.view.InventoryParserView;
import org.bfc.inventory.gwt.client.view.impl.BfcNavigationViewImpl;
import org.bfc.inventory.gwt.client.view.impl.InventoryParserResultsViewImpl;
import org.bfc.inventory.gwt.client.view.impl.InventoryParserViewImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory {
	private static final BfcServiceAsync bfcService = GWT.create(BfcService.class);
	
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
		
	private static final BfcNavigationView bfcNavigationView = new BfcNavigationViewImpl();
	private static final InventoryParserView resetInventoryView = new InventoryParserViewImpl("<b>RESET INVENTORY</b>");
	private static final InventoryParserResultsView resetInventoryResultsView = new InventoryParserResultsViewImpl();
	
	private static final InventoryParserView appendInventoryView = new InventoryParserViewImpl("<b>APPEND INVENTORY</b>");
	private static final InventoryParserResultsView appendInventoryResultsView = new InventoryParserResultsViewImpl();
	
	@Override
	public BfcServiceAsync getBfcService() {
		return bfcService;
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public BfcNavigationView getBfcNavigationView() {
		return bfcNavigationView;
	}

	@Override
	public InventoryParserView getResetInventoryView() {
		return resetInventoryView;
	}

	@Override
	public InventoryParserResultsView getResetInventoryResultsView() {
		return resetInventoryResultsView;
	}

	@Override
	public InventoryParserView getAppendInventoryView() {
		return appendInventoryView;
	}

	@Override
	public InventoryParserResultsView getAppendInventoryResultsView() {
		return appendInventoryResultsView;
	}
	
	
}
