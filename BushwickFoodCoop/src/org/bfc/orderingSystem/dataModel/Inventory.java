package org.bfc.orderingSystem.dataModel;

import java.util.Date;
import java.util.Map;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Inventory {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private Date inventoryDate;
	
	@Persistent
	private Map<InventoryItem, Double> inventoryMap;

	public Inventory(Date inventoryDate, Map<InventoryItem, Double> inventoryMap) {
		super();
		this.inventoryDate = inventoryDate;
		this.inventoryMap = inventoryMap;
	}

	public Key getKey() {
		return key;
	}

	public Date getInventoryDate() {
		return inventoryDate;
	}

	public Map<InventoryItem, Double> getInventoryMap() {
		return inventoryMap;
	}
	
	
}
