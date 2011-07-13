package org.bfc.inventory.gwt.client;

import org.bfc.inventory.gwt.client.factory.ClientFactory;
import org.bfc.inventory.gwt.client.factory.impl.ClientFactoryImpl;
import org.bfc.inventory.gwt.client.mvp.BfcActivityMapper;
import org.bfc.inventory.gwt.client.mvp.BfcPlaceHistoryMapper;
import org.bfc.inventory.gwt.client.place.ResetInventoryPlace;
import org.bfc.inventory.gwt.client.view.SimpleLayoutPanel;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BushwickFoodCoop implements EntryPoint {
	private Place defaultPlace = new ResetInventoryPlace();
	private SimpleLayoutPanel appWidget = new SimpleLayoutPanel();
	
	@Override
	public void onModuleLoad() {
		ClientFactory clientFactory = new ClientFactoryImpl();
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();
		
		ActivityMapper bfcActivityMapper = new BfcActivityMapper(clientFactory);
		ActivityManager contentsTableManager = new ActivityManager(bfcActivityMapper, eventBus);
		contentsTableManager.setDisplay(appWidget);
		
		BfcPlaceHistoryMapper historyMapper= GWT.create(BfcPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);
		
		RootLayoutPanel.get().add(appWidget);
		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();
	}
}
