package org.bfc.inventory.gwt.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("bfcService")
public interface BfcService extends RemoteService {
	public String parseAppendInventorySpreadsheet(String inventoryText) throws Exception;
	public String parseResetInventorySpreadsheet(String inventoryText) throws Exception;
}
