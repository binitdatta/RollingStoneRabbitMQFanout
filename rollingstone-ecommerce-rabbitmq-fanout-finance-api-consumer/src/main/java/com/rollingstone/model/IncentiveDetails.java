package com.rollingstone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INCENTIVE_DETAILS")
public class IncentiveDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="transaction_code", nullable=false)
	private String tranactionCode;
	
	@Column(name="sales_rep_id", nullable=false)
	private long salesRepId;

	@Column(name="sales_order_id", nullable=false)
	private long salesOrderId;

	@Column(name="incentive_amount", nullable=false)
	private float incentiveAmount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTranactionCode() {
		return tranactionCode;
	}

	public void setTranactionCode(String tranactionCode) {
		this.tranactionCode = tranactionCode;
	}

	public long getSalesRepId() {
		return salesRepId;
	}

	public void setSalesRepId(long salesRepId) {
		this.salesRepId = salesRepId;
	}

	public long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public float getIncentiveAmount() {
		return incentiveAmount;
	}

	public void setIncentiveAmount(float incentiveAmount) {
		this.incentiveAmount = incentiveAmount;
	}

	public IncentiveDetails() {
		super();
	}

	public IncentiveDetails(String tranactionCode, long salesRepId, long salesOrderId, float incentiveAmount) {
		super();
		this.tranactionCode = tranactionCode;
		this.salesRepId = salesRepId;
		this.salesOrderId = salesOrderId;
		this.incentiveAmount = incentiveAmount;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + Float.floatToIntBits(incentiveAmount);
		result = prime * result + (int) (salesOrderId ^ (salesOrderId >>> 32));
		result = prime * result + (int) (salesRepId ^ (salesRepId >>> 32));
		result = prime * result + ((tranactionCode == null) ? 0 : tranactionCode.hashCode());
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
		IncentiveDetails other = (IncentiveDetails) obj;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(incentiveAmount) != Float.floatToIntBits(other.incentiveAmount))
			return false;
		if (salesOrderId != other.salesOrderId)
			return false;
		if (salesRepId != other.salesRepId)
			return false;
		if (tranactionCode == null) {
			if (other.tranactionCode != null)
				return false;
		} else if (!tranactionCode.equals(other.tranactionCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IncentiveDetails [id=" + id + ", tranactionCode=" + tranactionCode + ", salesRepId=" + salesRepId
				+ ", salesOrderId=" + salesOrderId + ", incentiveAmount=" + incentiveAmount + "]";
	}
	
}
