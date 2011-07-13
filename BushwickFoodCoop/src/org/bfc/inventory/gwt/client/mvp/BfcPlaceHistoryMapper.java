package org.bfc.inventory.gwt.client.mvp;

import org.bfc.inventory.gwt.client.place.AppendInventoryPlace;
import org.bfc.inventory.gwt.client.place.ResetInventoryPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers( { 
	ResetInventoryPlace.Tokenizer.class,
	AppendInventoryPlace.Tokenizer.class
	})
public interface BfcPlaceHistoryMapper extends PlaceHistoryMapper {}
