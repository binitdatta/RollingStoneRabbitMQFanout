package com.rollingstone.spring.model;

public class ItemMasterDTO {
	private long id;
	private String itemSKUCode;
	private String itemUPCCOde;
	private String itemName;
	private String description;
	private String shortDescription;
	private String itemType;
	private String dimention;
	private String weight;
	private String size;
	private String color;
	private String pattern;
	private String manufacturer;
	private String producer;
	private String productOf;
	private String soldBy;
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
	public String getItemUPCCOde() {
		return itemUPCCOde;
	}
	public void setItemUPCCOde(String itemUPCCOde) {
		this.itemUPCCOde = itemUPCCOde;
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
	public ItemMasterDTO(long id, String itemSKUCode, String itemUPCCOde, String itemName, 
			String shortDescription, String itemType, String weight, String productOf, String soldBy, 
			String shippedBy, String color, String dimention, String description, String manufacturer, 
			String producer, String pattern, String size) {
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

		if (color != null) {
			this.color = color;
		}
		
		if (dimention != null) {
			this.dimention = dimention;
		}

		if (description != null) {
			this.description = description;
		}

		if (manufacturer != null) {
			this.manufacturer = manufacturer;
		}

		if (producer != null) {
			this.producer = producer;
		}
		
		if (pattern != null) {
			this.pattern = pattern;
		}

		if (size != null) {
			this.size = size;
		}

	}
	public ItemMasterDTO() {
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
		ItemMasterDTO other = (ItemMasterDTO) obj;
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

}
