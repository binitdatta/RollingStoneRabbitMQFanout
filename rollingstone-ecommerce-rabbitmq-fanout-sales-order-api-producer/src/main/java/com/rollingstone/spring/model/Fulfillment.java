package com.rollingstone.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLLINGSTONE_FULFILLMENT")
public class Fulfillment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="fulfillment_number", nullable=false)
	private String fulfillmentNumber;

	@Column(name="order_number", nullable=false)
	private String orderNumber;

	@Column(name="special_instruction", nullable=true)
	private String specialInstruction;

	@Column(name="shipping_method", nullable=false)
	private String shippingMethod;
	
	@Column(name="estimated_delivery_date", nullable=false)
	private Date estimatedDeliveryDate;
	
	@Column(name ="ITEM_UPC_CODE", nullable = false)
	private String itemUPCCOde;

	@Column(name="item_name", nullable=false)
	private String itemName;
	
	@Column(name="item_quantity", nullable=false)
	private String itemQuantity;
	
	@Column(name ="SIZE", nullable = true)
	private String size;
	
	@Column(name ="COLOR", nullable = true)
	private String color;
	
	@Column(name ="PATTERN", nullable = true)
	private String pattern;

	@Column(name ="SHIPPED_BY", nullable = false)
	private String shippedBy;

	@Column(name ="SHIPPING_ADDRESS", nullable = false)
	private String shippingAddress;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getSpecialInstruction() {
		return specialInstruction;
	}

	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public Date getEstimatedDelivryDate() {
		return estimatedDeliveryDate;
	}

	public void setEstimatedDelivryDate(Date estimatedDeliveryDate) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
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

	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
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

	public String getShippedBy() {
		return shippedBy;
	}

	public void setShippedBy(String shippedBy) {
		this.shippedBy = shippedBy;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Fulfillment(String fulfillmentNo, String orderNumber, String specialInstruction, String shippingMethod, Date estimatedDelivryDate,
			String itemUPCCOde, String itemName, String itemQuantity, String size, String color, String pattern,
			String shippedBy, String shippingAddress) {
		super();
		this.fulfillmentNumber = fulfillmentNo;
		this.orderNumber = orderNumber;
		this.specialInstruction = specialInstruction;
		this.shippingMethod = shippingMethod;
		this.estimatedDeliveryDate = estimatedDelivryDate;
		this.itemUPCCOde = itemUPCCOde;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.size = size;
		this.color = color;
		this.pattern = pattern;
		this.shippedBy = shippedBy;
		this.shippingAddress = shippingAddress;
	}

	public Fulfillment() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((estimatedDeliveryDate == null) ? 0 : estimatedDeliveryDate.hashCode());
		result = prime * result + ((fulfillmentNumber == null) ? 0 : fulfillmentNumber.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemQuantity == null) ? 0 : itemQuantity.hashCode());
		result = prime * result + ((itemUPCCOde == null) ? 0 : itemUPCCOde.hashCode());
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
		result = prime * result + ((shippedBy == null) ? 0 : shippedBy.hashCode());
		result = prime * result + ((shippingMethod == null) ? 0 : shippingMethod.hashCode());
		result = prime * result + ((shippingAddress == null) ? 0 : shippingAddress.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((specialInstruction == null) ? 0 : specialInstruction.hashCode());
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
		Fulfillment other = (Fulfillment) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (estimatedDeliveryDate == null) {
			if (other.estimatedDeliveryDate != null)
				return false;
		} else if (!estimatedDeliveryDate.equals(other.estimatedDeliveryDate))
			return false;
		if (id != other.id)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemQuantity == null) {
			if (other.itemQuantity != null)
				return false;
		} else if (!itemQuantity.equals(other.itemQuantity))
			return false;
		if (itemUPCCOde == null) {
			if (other.itemUPCCOde != null)
				return false;
		} else if (!itemUPCCOde.equals(other.itemUPCCOde))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (pattern == null) {
			if (other.pattern != null)
				return false;
		} else if (!pattern.equals(other.pattern))
			return false;
		if (shippedBy == null) {
			if (other.shippedBy != null)
				return false;
		} else if (!shippedBy.equals(other.shippedBy))
			return false;
		if (shippingMethod == null) {
			if (other.shippingMethod != null)
				return false;
		} else if (!shippingMethod.equals(other.shippingMethod))
			return false;
		if (shippingAddress == null) {
			if (other.shippingAddress != null)
				return false;
		} else if (!shippingAddress.equals(other.shippingAddress))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (specialInstruction == null) {
			if (other.specialInstruction != null)
				return false;
		} else if (!specialInstruction.equals(other.specialInstruction))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fulfillment [id=" + id + ", fulfillmentNumber=" + fulfillmentNumber + ", orderNumber=" + orderNumber
				+ ", specialInstruction=" + specialInstruction + ", shippingMethod=" + shippingMethod
				+ ", estimatedDeliveryDate=" + estimatedDeliveryDate + ", itemUPCCOde=" + itemUPCCOde + ", itemName="
				+ itemName + ", itemQuantity=" + itemQuantity + ", size=" + size + ", color=" + color + ", pattern="
				+ pattern + ", shippedBy=" + shippedBy + ", shippingAddress=" + shippingAddress + "]";
	}


}
