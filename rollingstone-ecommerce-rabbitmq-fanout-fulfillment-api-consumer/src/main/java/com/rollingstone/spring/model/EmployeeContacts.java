package com.rollingstone.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_CONTACTS")
public class EmployeeContacts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="contact_number", nullable=false)
	private String contactNumber;
	
	@Column(name="contact_type", nullable=false)
	private String contactType;
	
	@Column(name="contact", nullable=false)
	private String contact;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="is_primary", nullable=true)
	private boolean isPrimary;

	
	@ManyToOne/*(fetch = FetchType.LAZY)*/
	@JoinColumn (name  = "EMPLOYEE_ID")
	private Employee employee;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getContactType() {
		return contactType;
	}


	public void setContactType(String contactType) {
		this.contactType = contactType;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isPrimary() {
		return isPrimary;
	}


	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public EmployeeContacts(long id, String contactType, String contact, String contactNumber, 
			String description, boolean isPrimary) {
		super();
		this.id = id;
		this.contactType = contactType;
		this.contactNumber = contactNumber;
		this.contact = contact;
		this.description = description;
		this.isPrimary = isPrimary;
	}
	
	public EmployeeContacts() {
		super();
	}
	
	@Override
	public String toString() {
		return "Contacts [id=" + id + ", contactNumber=" + contactNumber + ", contact type=" + contactType + ", contact="
				+ contact + ", description =" + description +" ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((contactType == null) ? 0 : contactType.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		EmployeeContacts other = (EmployeeContacts) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
		if (contactType == null) {
			if (other.contactType != null)
				return false;
		} else if (!contactType.equals(other.contactType))
			return false;
		if (id != other.id)
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
}
