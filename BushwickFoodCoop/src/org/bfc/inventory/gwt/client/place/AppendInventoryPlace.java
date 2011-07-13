package org.bfc.inventory.gwt.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AppendInventoryPlace  extends Place {

	public AppendInventoryPlace() {
		super();
	}

	public static class Tokenizer implements PlaceTokenizer<AppendInventoryPlace>
	{
		@Override
		public String getToken(AppendInventoryPlace place)
		{
			return "AppendInventory";
		}

		@Override
		public AppendInventoryPlace getPlace(String token)
		{
			return new AppendInventoryPlace();
		}
	}
	
}