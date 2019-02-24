package com.rollingstone.spring.model;

import java.util.Date;

public class AccountReceivableDTO {
	private long id;
	private String transactionNumber;
	private long accountId;
	private long userId;
	private long salesOrderId;
	private Date transactionDate;
	private double transactionAmount;
	private long salesRepId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public long getSalesRepId() {
		return salesRepId;
	}

	public void setSalesRepId(long salesRepId) {
		this.salesRepId = salesRepId;
	}

	public AccountReceivableDTO(String transactionNumber, long accountId, long userId, long salesOrderId,
			Date transactionDate, double transactionAmount, long salesRepId) {
		super();
		this.transactionNumber = transactionNumber;
		this.accountId = accountId;
		this.userId = userId;
		this.salesOrderId = salesOrderId;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.salesRepId = salesRepId;
	}
	public AccountReceivableDTO() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (salesOrderId ^ (salesOrderId >>> 32));
		result = prime * result + (int) (salesRepId ^ (salesRepId >>> 32));
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((transactionNumber == null) ? 0 : transactionNumber.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		AccountReceivableDTO other = (AccountReceivableDTO) obj;
		if (accountId != other.accountId)
			return false;
		if (id != other.id)
			return false;
		if (salesOrderId != other.salesOrderId)
			return false;
		if (salesRepId != other.salesRepId)
			return false;
		if (transactionAmount != other.transactionAmount)
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionNumber == null) {
			if (other.transactionNumber != null)
				return false;
		} else if (!transactionNumber.equals(other.transactionNumber))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountReceivable [id=" + id + ", transactionNumber=" + transactionNumber + ", accountId=" + accountId
				+ ", userId=" + userId + ", salesOrderId=" + salesOrderId + ", transactionDate=" + transactionDate
				+ ", transactionAmount=" + transactionAmount + ", salesRepId=" + salesRepId + "]";
	}
	

}
