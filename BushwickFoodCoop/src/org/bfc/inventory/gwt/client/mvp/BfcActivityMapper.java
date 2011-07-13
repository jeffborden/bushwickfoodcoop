package org.bfc.inventory.gwt.client.mvp;

import org.bfc.inventory.gwt.client.activity.AppendInventoryActivity;
import org.bfc.inventory.gwt.client.activity.ResetInventoryActivity;
import org.bfc.inventory.gwt.client.factory.ClientFactory;
import org.bfc.inventory.gwt.client.place.AppendInventoryPlace;
import org.bfc.inventory.gwt.client.place.ResetInventoryPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class BfcActivityMapper implements ActivityMapper {
	private ClientFactory clientFactory;
	
	
	
	public BfcActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}



	@Override
	public Activity getActivity(Place place) {
		// This is begging for GIN
		if (place instanceof ResetInventoryPlace){
			return new ResetInventoryActivity(clientFactory);
		}if (place instanceof AppendInventoryPlace){
			return new AppendInventoryActivity(clientFactory);
		}
		
		return null;
	}

}
