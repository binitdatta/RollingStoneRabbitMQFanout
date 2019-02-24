package com.rollingstone.spring.model;

public class IncentiveDetailsDTO {
	private long id;
	private String tranactionCode;
	private long salesRepId;
	private long salesOrderId;
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

	public IncentiveDetailsDTO() {
		super();
	}

	public IncentiveDetailsDTO(long id, String tranactionCode, long salesRepId, long salesOrderId,
			float incentiveAmount) {
		super();
		this.id = id;
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
		IncentiveDetailsDTO other = (IncentiveDetailsDTO) obj;
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
		return "IncentiveDetailsDTO [id=" + id + ", tranactionCode=" + tranactionCode + ", salesRepId=" + salesRepId
				+ ", salesOrderId=" + salesOrderId + ", incentiveAmount=" + incentiveAmount + "]";
	}
	
	

}
