package org.bfc.orderingSystem.dataModel;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class InventoryItem {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String name;
	
	@Persistent
	private String type;
	
	@Persistent
	private Double retailPrice;
	
	@Persistent
	private Double wholesalePrice;
	
	@Persistent
	private Boolean isBulk;

	public InventoryItem(String name, String type, Double retailPrice,
			Double wholesalePrice, Boolean isBulk) {
		super();
		this.name = name;
		this.type = type;
		this.retailPrice = retailPrice;
		this.wholesalePrice = wholesalePrice;
		this.isBulk = isBulk;
	}

	public Key getKey() {
		return key;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Double getWholesalePrice() {
		return wholesalePrice;
	}

	public void setWholesalePrice(Double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}

	public Boolean getIsBulk() {
		return isBulk;
	}

	public void setIsBulk(Boolean isBulk) {
		this.isBulk = isBulk;
	}

	
}
