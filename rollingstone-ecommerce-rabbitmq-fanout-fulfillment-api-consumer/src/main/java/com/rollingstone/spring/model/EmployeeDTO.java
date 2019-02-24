package com.rollingstone.spring.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDTO {
	private long id;
	private String employeeNumber;
	private String employeeName;
	private String firstName;
	private String lastName;
	private String sex;
	private String employeeType;
	private Date startDate;
	private Set<AddressDTO> addresses = new HashSet<AddressDTO>();
	private Set<EmployeeContacts> contacts = new HashSet<EmployeeContacts>();
	
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Set<AddressDTO> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<AddressDTO> addresses) {
		this.addresses = addresses;
	}
	
	public Set<EmployeeContacts> getContacts(){
		return this.contacts;
	}
	
	public void setContacts(Set<EmployeeContacts> contacts) {
		this.contacts = contacts;
	}
	
	public EmployeeDTO(long id, String employeeNumber, String firstName, String lastName, 
			String sex, String employeeType, Date startDate, Set<AddressDTO> addresses, Set<EmployeeContacts> contacts)  {
		super();
		this.id = id;
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.employeeType = employeeType;
		this.startDate = startDate;
		this.addresses = addresses;
		this.contacts = contacts;
	}
	
	public EmployeeDTO() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeNumber=" + employeeNumber + ", employeeName=" + this.firstName + " " + this.lastName 
				+ ", Sex : " + this.sex + ", Employee type : " + this.employeeType + ", Stary Date : " + this.startDate + ", addresses=" + addresses
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeNumber == null) ? 0 : employeeNumber.hashCode());
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
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
		EmployeeDTO other = (EmployeeDTO) obj;
		if (employeeNumber == null) {
			if (other.employeeNumber != null)
				return false;
		} else if (!employeeNumber.equals(other.employeeNumber))
			return false;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (id != other.id)
			return false;
		if (this.firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!this.firstName.equals(other.firstName))
			return false;
		return true;
	}


}
