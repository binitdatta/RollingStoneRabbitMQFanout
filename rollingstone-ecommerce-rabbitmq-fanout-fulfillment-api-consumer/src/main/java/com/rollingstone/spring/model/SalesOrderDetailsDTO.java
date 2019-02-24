package com.rollingstone.spring.model;

import java.util.HashSet;
import java.util.Set;

public class SalesOrderDetailsDTO {
	private long id;
	
	private String itemLineNo;
	
	private int itemQuantity;
	
	private float pricePerUnit;
	
	private SalesOrder salesOrder;
	
	private ItemMaster item;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemLineNo() {
		return itemLineNo;
	}

	public void setItemLineNo(String itemLineNo) {
		this.itemLineNo = itemLineNo;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public float getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

	public ItemMaster getItems() {
		return item;
	}

	public void setItems(ItemMaster item) {
		this.item = item;
	}
	

	public SalesOrderDetailsDTO(String itemLineNo, int itemQuantity, float pricePerUnit, SalesOrder salesOrder,
			ItemMaster item) {
		super();
		this.itemLineNo = itemLineNo;
		this.itemQuantity = itemQuantity;
		this.pricePerUnit = pricePerUnit;
		this.salesOrder = salesOrder;
		this.item = item;
	}

	public SalesOrderDetailsDTO() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((itemLineNo == null) ? 0 : itemLineNo.hashCode());
		result = prime * result + Float.floatToIntBits(pricePerUnit);
		result = prime * result + ((salesOrder == null) ? 0 : salesOrder.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesOrderDetailsDTO other = (SalesOrderDetailsDTO) obj;
		if (id != other.id)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (itemLineNo == null) {
			if (other.itemLineNo != null)
				return false;
		} else if (!itemLineNo.equals(other.itemLineNo))
			return false;
		if (itemQuantity == 0) {
			if (other.itemQuantity != 0)
				return false;
		} else if (itemQuantity != other.itemQuantity)
			return false;
		if (Float.floatToIntBits(pricePerUnit) != Float.floatToIntBits(other.pricePerUnit))
			return false;
		if (salesOrder == null) {
			if (other.salesOrder != null)
				return false;
		} else if (!salesOrder.equals(other.salesOrder))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SalesOrderDetailsDTO [id=" + id + ", itemLineNo=" + itemLineNo + ", itemQuantity=" + itemQuantity
				+ ", pricePerUnit=" + pricePerUnit + ", salesOrder=" + salesOrder + ", item=" + item + "]";
	}

	

	
}
