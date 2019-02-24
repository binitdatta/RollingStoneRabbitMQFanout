package com.rollingstone.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ACCOUNT_RECEIVABLE")
public class AccountReceivable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="transaction_number", nullable = false)
	private String transactionNumber;
	
	@Column(name="account_id", nullable = false)
	private long accountId;
	
	@Column(name="user_id", nullable = false)
	private long userId;
	
	@Column(name="sales_order_id", nullable = false)
	private long salesOrderId;

	@Column(name="transaction_date", nullable = false)
	private Date transactionDate;

	@Column(name="transaction_amount", nullable = false)
	private double transactionAmount;

	@Column(name="sales_rep_id", nullable = false)
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

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public long getSalesRepId() {
		return salesRepId;
	}

	public void setSalesRepId(long salesRepId) {
		this.salesRepId = salesRepId;
	}

	public AccountReceivable(String transactionNumber, long accountId, long userId, long salesOrderId,
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
	public AccountReceivable() {
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
		AccountReceivable other = (AccountReceivable) obj;
		if (accountId != other.accountId)
			return false;
		if (id != other.id)
			return false;
		if (salesOrderId != other.salesOrderId)
			return false;
		if (salesRepId != other.salesRepId)
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
