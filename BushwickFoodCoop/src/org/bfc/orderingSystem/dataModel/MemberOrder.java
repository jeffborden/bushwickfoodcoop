package org.bfc.orderingSystem.dataModel;

import java.util.Date;
import java.util.Map;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

public class MemberOrder {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private Date orderDate;
	
	@Persistent
	private Map<InventoryItem, Double> itemMap;

	public MemberOrder(Date orderDate, Map<InventoryItem, Double> itemMap) {
		super();
		this.orderDate = orderDate;
		this.itemMap = itemMap;
	}

	public Key getKey() {
		return key;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Map<InventoryItem, Double> getItemMap() {
		return itemMap;
	}
	
	
}
