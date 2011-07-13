package org.bfc.inventory.gwt.client.view.impl;

import org.bfc.inventory.gwt.client.view.InventoryParserView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;

public class InventoryParserViewImpl extends LayoutPanel implements InventoryParserView {

	private TextArea inputTextArea;
	private InventoryParserPresenter presenter;


	
	public InventoryParserViewImpl(String headerText) {
		super();
		SplitLayoutPanel rootPanel = new SplitLayoutPanel();
		
		FlexTable topPanel = new FlexTable();
		Button submitButton = new Button();
		submitButton.setText("Submit");
		
		HTML headerLabel = new HTML(headerText);
		headerLabel.setWidth("800");
		
		Label instructionLabel = new Label("Copy and Paste Spreadsheet Text in Area Below");
		instructionLabel.setWidth("800");
		
		topPanel.setWidget(0, 0, headerLabel);
		topPanel.setWidget(1, 0, instructionLabel);
		topPanel.setWidget(2, 0, submitButton);
		topPanel.getFlexCellFormatter().setColSpan(0, 0, 2);
		topPanel.getFlexCellFormatter().setColSpan(1, 0, 2);
		
		inputTextArea = new TextArea();
		inputTextArea.setSize("99%", "99%");
		
		LayoutPanel lPanel = new LayoutPanel();
		lPanel.add(inputTextArea);
		lPanel.setSize("99%", "99%");
		
		rootPanel.addNorth(topPanel, 75);
		rootPanel.add(lPanel);
		
		submitButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				String inputText = inputTextArea.getText();
				presenter.handleSubmitButtonPressed(inputText);				
			}
		});
		
		this.add(rootPanel);
	}

	/* (non-Javadoc)
	 * @see org.bfc.inventory.gwt.client.view.impl.InventoryParserView#setPresenter(org.bfc.inventory.gwt.client.view.impl.InventoryParserViewImpl.InventoryParserPresenter)
	 */
	@Override
	public void setPresenter(InventoryParserPresenter presenter) {
		this.presenter = presenter;
	}
	
	/* (non-Javadoc)
	 * @see org.bfc.inventory.gwt.client.view.impl.InventoryParserView#setTextAreaContents(java.lang.String)
	 */
	@Override
	public void setTextAreaContents(String inputText){
		this.inputTextArea.setText(inputText);
	}

	
}
