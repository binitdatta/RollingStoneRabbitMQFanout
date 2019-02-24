package com.rollingstone.spring.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ColumnResult;

public class SalesOrderDTO {
	private long id;
	private String orderNumber;
	private double totalOrderAmount;
	private String specialInstruction;
	private String shippingMethod;
	private Date estimatedDelivaryDate;
	private int itemQuantity;
	private Employee employee;
	private Date salesDate; 
	private Account account;
	private Address address;
	private User user;
	private ItemMaster itemMaster;
	private Set<SalesOrderDetails> salesOrderDetails = new HashSet<>();

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

	public double getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(double totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
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

	public Date getEstimatedDelivaryDate() {
		return estimatedDelivaryDate;
	}

	public void setEstimatedDelivaryDate(Date estimatedDelivaryDate) {
		this.estimatedDelivaryDate = estimatedDelivaryDate;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public Set<SalesOrderDetails> getSalesOrderDetails() {
		return salesOrderDetails;
	}

	public void setSalesOrderDetails(Set<SalesOrderDetails> salesOrderDetails) {
		this.salesOrderDetails = salesOrderDetails;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ItemMaster getItemMaster() {
		return itemMaster;
	}

	public void setItemMaster(ItemMaster itemMaster) {
		this.itemMaster = itemMaster;
	}

	public SalesOrderDTO(long id, String orderNumber, double total, String specialInstruction,
			Account account, Employee employee, Date salesDate,  Set<SalesOrderDetails> salesOrderDetails) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.totalOrderAmount = total;
		this.specialInstruction = specialInstruction;
		this.employee = employee;
		this.salesDate = salesDate;
		this.account = account;
		this.salesOrderDetails = salesOrderDetails;
		
	}
	
	public SalesOrderDTO(long id, String orderNumber, long accountId, 
			long userProfileId, Date salesDate, double totalSalesAmount,
			String accountNumber, String accountName, String employeeNumber, 
			long employeeId, String employeeName, String firstName, 
			String lastName) {
		this.id = id;
		Account account = new Account();
		account.setId(accountId);
		account.setAccountName(accountName);
		account.setAccountNumber(accountNumber);
		
		User user = new User();
		user.setId(userProfileId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		account.setUser(user);
		
		Employee employee  = new Employee();
		employee.setEmployeeName(employeeName);
		employee.setEmployeeNumber(employeeNumber);
		employee.setId(employeeId);
		
		this.orderNumber = orderNumber;
		this.totalOrderAmount = totalSalesAmount;
		this.salesDate = salesDate;
		
		this.account = account;
		this.employee = employee;
	}
	public SalesOrderDTO(long id, String orderNumber, String shippingMethod, Date estimatedDelivaryDate, 
			String specialInstruction, int itemQuantity, String itemUpcCode, String itemName, 
			String color, String pattern, String size, String shippedBy, String houseNumber, String street,
			String city, String state, String zipCode, long accountId, long userProfileId, 
			Date salesDate, double totalSalesAmount, String accountNumber, String accountName, 
			String employeeNumber, long employeeId, String employeeName, String firstName, 
			String lastName) {

		this.id = id;
		this.itemMaster = new ItemMaster();
		itemMaster.setColor(color);
		itemMaster.setItemName(itemName);
		itemMaster.setItemUPCCode(itemUpcCode);
		itemMaster.setPattern(pattern);
		itemMaster.setSize(size);
		itemMaster.setShippedBy(shippedBy);
		
		this.address = new Address();
		address.setHouseNumber(houseNumber);
		address.setStreetAddress(street);
		address.setCity(city);
		address.setState(state);
		address.setZipCode(zipCode);
		
		this.account = new Account();
		account.setId(accountId);
		account.setAccountName(accountName);
		account.setAccountNumber(accountNumber);
		
		this.user = new User();
		user.setId(userProfileId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		account.setUser(user);

		this.employee  = new Employee();
		employee.setEmployeeName(employeeName);
		employee.setEmployeeNumber(employeeNumber);
		employee.setId(employeeId);
		
		this.orderNumber = orderNumber;
		this.totalOrderAmount = totalSalesAmount;
		this.salesDate = salesDate;
		this.shippingMethod = shippingMethod;
		this.estimatedDelivaryDate = estimatedDelivaryDate;
		this.specialInstruction = specialInstruction;
		this.itemQuantity = itemQuantity;
		
	}
	
	public SalesOrderDTO() {
		super();
	}
	

	@Override
	public String toString() {
		return "SalesOrderDTO [id=" + id + ", orderNumber=" + orderNumber + ", totalOrderAmount=" + totalOrderAmount
				+ ", specialInstruction=" + specialInstruction + ", shippingMethod=" + shippingMethod
				+ ", estimatedDelivaryDate=" + estimatedDelivaryDate + ", itemQuantity=" + itemQuantity + ", employee="
				+ employee + ", salesDate=" + salesDate + ",\n account=" + account.toString() 
				+ ",\n address=" + address.toString() + ",\n user=" + user.toString() 
				+ ",\n itemMaster=" + itemMaster.toString() + ",\n salesOrderDetails=" + salesOrderDetails.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((salesDate == null) ? 0 : salesDate.hashCode());
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((salesOrderDetails == null) ? 0 : salesOrderDetails.hashCode());
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
		SalesOrderDTO other = (SalesOrderDTO) obj;
		if (salesOrderDetails == null) {
			if (other.salesOrderDetails != null)
				return false;
		} else if (!salesOrderDetails.equals(other.salesOrderDetails))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (salesDate == null) {
			if (other.salesDate != null)
				return false;
		} else if (!salesDate.equals(other.salesDate))
			return false;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
	
		if (id != other.id)
			return false;
	
		return true;
	}
}
