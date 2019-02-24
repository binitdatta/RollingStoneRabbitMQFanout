package com.rollingstone.spring.model;

import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLLINGSTONE_ITEM")
public class ItemMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name ="ITEM_SKU_CODE", nullable = false)
	private String itemSKUCode;

	@Column(name ="ITEM_UPC_CODE", nullable = false)
	private String itemUPCCOde;

	@Column(name ="ITEM_NAME", nullable = false)
	private String itemName;
	
	@Column(name ="DESCRIPTION", nullable = true)
	private String description;
	
	@Column(name ="SHORT_DESCRIPTION", nullable = false)
	private String shortDescription;
	
	@Column(name ="ITEM_TYPE", nullable = false)
	private String itemType;
	
	@Column(name ="DIMENTION", nullable = true)
	private String dimention;
	
	@Column(name ="WEIGHT", nullable = false)
	private String weight;

	@Column(name ="SIZE", nullable = true)
	private String size;
	
	@Column(name ="COLOR", nullable = true)
	private String color;
	
	@Column(name ="PATTERN", nullable = true)
	private String pattern;

	@Column(name ="MANUFACTURER", nullable = true)
	private String manufacturer;
	
	@Column(name ="PRODUCER", nullable = true)
	private String producer;
	
	@Column(name ="PRODUCT_OF", nullable = false)
	private String productOf;
	
	@Column(name ="SOLD_BY", nullable = false)
	private String soldBy;

	@Column(name ="SHIPPED_BY", nullable = false)
	private String shippedBy;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemSKUCode() {
		return itemSKUCode;
	}

	public void setItemSKUCode(String itemSKUCode) {
		this.itemSKUCode = itemSKUCode;
	}

	public String getItemUPCCode() {
		return itemUPCCOde;
	}

	public void setItemUPCCode(String itemUPCCode) {
		this.itemUPCCOde = itemUPCCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getDimention() {
		return dimention;
	}

	public void setDimention(String dimention) {
		this.dimention = dimention;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getProductOf() {
		return productOf;
	}

	public void setProductOf(String productOf) {
		this.productOf = productOf;
	}

	public String getSoldBy() {
		return soldBy;
	}

	public void setSoldBy(String soldBy) {
		this.soldBy = soldBy;
	}

	public String getShippedBy() {
		return shippedBy;
	}

	public void setShippedBy(String shippedBy) {
		this.shippedBy = shippedBy;
	}

	

	public ItemMaster(long id, String itemSKUCode, String itemUPCCOde, String itemName, String shortDescription, 
			String itemType, String weight, String productOf, String soldBy, String shippedBy) {
		super();
		this.id = id;
		this.itemSKUCode = itemSKUCode;
		this.itemUPCCOde = itemUPCCOde;
		this.itemName = itemName;
		this.shortDescription = shortDescription;
		this.itemType = itemType;
		this.weight = weight;
		this.productOf = productOf;
		this.soldBy = soldBy;
		this.shippedBy = shippedBy;
	}

	public ItemMaster() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", itemSKUCode=" + itemSKUCode + ", itemUPCCOde=" + itemUPCCOde 
				+ ", itemName=" + itemName 	+ ", shortDescription=" + shortDescription 
				+ ", itemType=" + itemType + ", weight=" + weight + ", productOf=" + productOf 
				+ ", soldBy=" + soldBy + ", shippedBy=" + shippedBy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemSKUCode == null) ? 0 : itemSKUCode.hashCode());
		result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
		result = prime * result + ((itemUPCCOde == null) ? 0 : itemUPCCOde.hashCode());
		result = prime * result + ((productOf == null) ? 0 : productOf.hashCode());
		result = prime * result + ((shippedBy == null) ? 0 : shippedBy.hashCode());
		result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
		result = prime * result + ((soldBy == null) ? 0 : soldBy.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		ItemMaster other = (ItemMaster) obj;
		if (id != other.id)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemSKUCode == null) {
			if (other.itemSKUCode != null)
				return false;
		} else if (!itemSKUCode.equals(other.itemSKUCode))
			return false;
		if (itemType == null) {
			if (other.itemType != null)
				return false;
		} else if (!itemType.equals(other.itemType))
			return false;
		if (itemUPCCOde == null) {
			if (other.itemUPCCOde != null)
				return false;
		} else if (!itemUPCCOde.equals(other.itemUPCCOde))
			return false;
		if (productOf == null) {
			if (other.productOf != null)
				return false;
		} else if (!productOf.equals(other.productOf))
			return false;
		if (shippedBy == null) {
			if (other.shippedBy != null)
				return false;
		} else if (!shippedBy.equals(other.shippedBy))
			return false;
		if (shortDescription == null) {
			if (other.shortDescription != null)
				return false;
		} else if (!shortDescription.equals(other.shortDescription))
			return false;
		if (soldBy == null) {
			if (other.soldBy != null)
				return false;
		} else if (!soldBy.equals(other.soldBy))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	 public static class ItemMasterBuilder {
		 private ItemMaster itemMaster;
		 
		public ItemMaster getItemMaster() {
			return itemMaster;
		}

		public ItemMasterBuilder(ItemMaster itemMaster) {
			super();
			this.itemMaster = itemMaster;
		}

		public ItemMaster addOtherFeatureToItem(Map<PartialItemAttributes, String> feature) {
			Set<PartialItemAttributes> keys = feature.keySet();
			for(PartialItemAttributes key : keys) {
				if (key.toString().equals(PartialItemAttributes.COLOR.toString())){
					this.itemMaster.setColor(feature.get(key));
				}else if (key.toString().equals(PartialItemAttributes.DECRIPTION.toString())) {
					this.itemMaster.setDescription(feature.get(key));
				} else if (key.toString().equals(PartialItemAttributes.DIMENTION.toString())) {
					this.itemMaster.setDimention(feature.get(key));
				} else if (key.toString().equals(PartialItemAttributes.MANUFACTURER.toString())){
					this.itemMaster.setManufacturer(feature.get(key));
				} else if (key.toString().equals(PartialItemAttributes.PATTERN.toString())){
					this.itemMaster.setPattern(feature.get(key));
				} else if (key.toString().equals(PartialItemAttributes.PRODUCER.toString())) {
					this.itemMaster.setProducer(feature.get(key));
				} else if (key.toString().equals(PartialItemAttributes.SIZE.toString())) {
					this.itemMaster.setSize(feature.get(key));
				}
			}
			return this.itemMaster;
		}
		
	 }
	
	public static enum PartialItemAttributes{
		DIMENTION,
		COLOR,
		SIZE,
		DECRIPTION,
		PATTERN,
		MANUFACTURER,
		PRODUCER;
		
		public String toString(PartialItemAttributes att) {
			return att.name();
		}
	}
}
