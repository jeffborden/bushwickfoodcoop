package org.bfc.inventory.gwt.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BfcServiceAsync {

	void parseAppendInventorySpreadsheet(String inventoryText, AsyncCallback<String> callback);
	void parseResetInventorySpreadsheet(String inventoryText, AsyncCallback<String> callback);


}
