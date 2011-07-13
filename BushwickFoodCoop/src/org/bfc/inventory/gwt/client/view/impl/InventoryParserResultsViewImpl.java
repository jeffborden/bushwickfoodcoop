package org.bfc.inventory.gwt.client.view.impl;

import org.bfc.inventory.gwt.client.view.InventoryParserResultsView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;

public class InventoryParserResultsViewImpl extends LayoutPanel implements InventoryParserResultsView {
	

	private TextArea outputTextArea;
	private InventoryParserResultsPresenter presenter;

	

	public InventoryParserResultsViewImpl() {
		super();
		
		SplitLayoutPanel rootPanel = new SplitLayoutPanel();
		
		FlexTable bottomPanel = new FlexTable();
		Button returnToInputButton = new Button();
		returnToInputButton.setText("Import New Spreadsheet");
		
		bottomPanel.setWidget(0, 0, returnToInputButton);
		
		outputTextArea = new TextArea();
		outputTextArea.setSize("99%", "99%");
		outputTextArea.setReadOnly(true);
		
		LayoutPanel lPanel = new LayoutPanel();
		lPanel.add(outputTextArea);
		lPanel.setSize("99%", "99%");
		
		rootPanel.addSouth(bottomPanel, 40);
		rootPanel.add(lPanel);
		
		returnToInputButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				presenter.handleReturnButtonPressed();				
			}
		});
		
		this.add(rootPanel);
	}

	/* (non-Javadoc)
	 * @see org.bfc.inventory.gwt.client.view.impl.InventoryParserResultsView#setPresenter(org.bfc.inventory.gwt.client.view.impl.InventoryParserResultsViewImpl.InventoryParserResultsPresenter)
	 */
	@Override
	public void setPresenter(InventoryParserResultsPresenter presenter) {
		this.presenter = presenter;
	}
	
	/* (non-Javadoc)
	 * @see org.bfc.inventory.gwt.client.view.impl.InventoryParserResultsView#setOutputTextAreaContents(java.lang.String)
	 */
	@Override
	public void setOutputTextAreaContents(String text){
		this.outputTextArea.setText(text);
	}
}
