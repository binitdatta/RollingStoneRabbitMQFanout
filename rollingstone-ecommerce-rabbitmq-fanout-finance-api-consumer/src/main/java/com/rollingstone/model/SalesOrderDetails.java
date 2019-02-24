package com.rollingstone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "SALES_ORDER_DETAILS")
public class SalesOrderDetails {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name="item_line_no", nullable = false)
		private String itemLineNo;

		@Column(name="price_per_unit", nullable = false)
		private float pricePerUnit;
		
		@Column(name="item_quantity", nullable = false)
		private int itemQuantity;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name  = "SALES_ORDER_ID", nullable = false)
		private SalesOrder salesOrder;
		
		@OneToOne
		@JoinColumn(name="ITEM_ID")
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

	
		public SalesOrder getSalesOrder() {
			return salesOrder;
		}

		public void setSalesOrder(SalesOrder salesOrder) {
			this.salesOrder = salesOrder;
		}

		public float getPricePerUnit() {
			return pricePerUnit;
		}

		public void setPricePerUnit(float pricePerUnit) {
			this.pricePerUnit = pricePerUnit;
		}
		
		public ItemMaster getItem() {
			return item;
		}

		public void setItem(ItemMaster item) {
			this.item = item;
		}

		public SalesOrderDetails(String itemLineNo, int itemQuantity, float pricePerUnit, 
				SalesOrder salesOrder, ItemMaster item) {
			super();
			this.itemLineNo = itemLineNo;
			this.itemQuantity = itemQuantity;
			this.salesOrder = salesOrder;
			this.pricePerUnit = pricePerUnit;
			this.item = item;
		}
		
		public SalesOrderDetails() {
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
			// result = prime * result + ((salesOrder == null) ? 0 : salesOrder.hashCode());
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
			SalesOrderDetails other = (SalesOrderDetails) obj;
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
			return "SalesOrderDetails [id=" + id + ", itemLineNo=" + itemLineNo + ", pricePerUnit=" + pricePerUnit
					+ ", itemQuantity=" + itemQuantity + ", salesOrder=" + salesOrder + ", item=" + item + "]";
		}
		
}
