package org.bfc.inventory.gwt.shared;

public enum NavigationListType {
	ResetInventoryParser("Resent Inventory"),
	AppendInventoryParser("Append Inventory");
	
	private String title;

	private NavigationListType(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
}
