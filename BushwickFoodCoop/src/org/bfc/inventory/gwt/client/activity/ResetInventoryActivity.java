package org.bfc.inventory.gwt.client.activity;

import org.bfc.inventory.gwt.client.factory.ClientFactory;
import org.bfc.inventory.gwt.client.view.InventoryParserResultsView;
import org.bfc.inventory.gwt.client.view.InventoryParserResultsView.InventoryParserResultsPresenter;
import org.bfc.inventory.gwt.client.view.InventoryParserView;
import org.bfc.inventory.gwt.client.view.InventoryParserView.InventoryParserPresenter;
import org.bfc.inventory.gwt.shared.NavigationListType;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

public class ResetInventoryActivity extends AbstractBfcNavigationActivity implements InventoryParserPresenter, InventoryParserResultsPresenter {

	protected InventoryParserView inventoryParserView;
	protected InventoryParserResultsView inventoryParserResultsView;

	public ResetInventoryActivity(ClientFactory clientFactory) {
		super(clientFactory);
		inventoryParserView = clientFactory.getResetInventoryView();
		inventoryParserResultsView = clientFactory.getResetInventoryResultsView();
	}
	
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		inventoryParserView.setPresenter(this);
		inventoryParserResultsView.setPresenter(this);
		populateInitialTableContents();	
		
		super.start(panel, eventBus);
	}

	private void populateInitialTableContents(){
		inventoryParserView.setTextAreaContents("");
	}

	@Override
	public void handleSubmitButtonPressed(String inputText) {
		bfcNavigationView.getContentsTablePanel().setWidget(inventoryParserResultsView);
		inventoryParserResultsView.setOutputTextAreaContents("");

		clientFactory.getBfcService().parseResetInventorySpreadsheet(inputText, new AsyncCallback<String>(){
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
	public void handleReturnButtonPressed() {
		inventoryParserView.setTextAreaContents("");
		bfcNavigationView.getContentsTablePanel().setWidget(inventoryParserView);
	}
	
	
	@Override
	protected IsWidget getContentsPanelViewWidget() {
		return inventoryParserView;
	}

	@Override
	protected NavigationListType getViewAnalysisType() {
		return NavigationListType.ResetInventoryParser;
	}

}
