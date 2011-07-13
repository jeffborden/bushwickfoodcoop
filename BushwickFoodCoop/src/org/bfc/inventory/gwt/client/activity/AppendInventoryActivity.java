package org.bfc.inventory.gwt.client.activity;

import org.bfc.inventory.gwt.client.factory.ClientFactory;
import org.bfc.inventory.gwt.shared.NavigationListType;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class AppendInventoryActivity extends ResetInventoryActivity{

	public AppendInventoryActivity(ClientFactory clientFactory) {
		super(clientFactory);
		inventoryParserView = clientFactory.getAppendInventoryView();
		inventoryParserResultsView = clientFactory.getAppendInventoryResultsView();
	}

	@Override
	public void handleSubmitButtonPressed(String inputText) {
		bfcNavigationView.getContentsTablePanel().setWidget(inventoryParserResultsView);
		inventoryParserResultsView.setOutputTextAreaContents("");

		clientFactory.getBfcService().parseAppendInventorySpreadsheet(inputText, new AsyncCallback<String>(){
			@Override
			public void onFailure(Throwable caught) {
				inventoryParserResultsView.setOutputTextAreaContents("ERROR: "+caught.getMessage());
			}

			@Override
			public void onSuccess(String result) {
				inventoryParserResultsView.setOutputTextAreaContents(result);				
			}
		});
	}

	
	
	@Override
	protected NavigationListType getViewAnalysisType() {
		return NavigationListType.AppendInventoryParser;
	}

}
