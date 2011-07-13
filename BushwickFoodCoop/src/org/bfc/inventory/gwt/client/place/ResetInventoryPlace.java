package org.bfc.inventory.gwt.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ResetInventoryPlace  extends Place {

	public ResetInventoryPlace() {
		super();
	}

	public static class Tokenizer implements PlaceTokenizer<ResetInventoryPlace>
	{
		@Override
		public String getToken(ResetInventoryPlace place)
		{
			return "ResetInventory";
		}

		@Override
		public ResetInventoryPlace getPlace(String token)
		{
			return new ResetInventoryPlace();
		}
	}
	
}