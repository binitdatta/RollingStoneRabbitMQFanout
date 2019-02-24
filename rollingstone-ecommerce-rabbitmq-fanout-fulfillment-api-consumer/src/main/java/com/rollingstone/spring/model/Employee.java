package com.rollingstone.spring.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SqlResultSetMapping(name = "EmployeeMapping", classes = {
		@ConstructorResult(targetClass = EmployeeDTO.class, columns  = {
				@ColumnResult(name = "id", type = Long.class),
				@ColumnResult(name = "employee_number"),
				@ColumnResult(name = "employee_name"),
				@ColumnResult(name = "first_name"),
				@ColumnResult(name = "last_name"),
				@ColumnResult(name = "sex"),
				@ColumnResult(name = "employee_type"),
				@ColumnResult(name = "start_date"),
				
		})
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "EmployeeDaoRepository.getEmployeeByID",
			query = "select emp.id, emp.employee_name, emp.employee_number, , "
					+ "emp.first_name,emp.last_name,emp.sex,emp.employee_type,emp.start_date "
					+ "from employee emp" + 
					"where emp.id = :id", resultSetMapping = "EmployeeMapping" )
})

@Entity
@Table(name = "ROLLINGSTONE_EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="employee_number", nullable=false)
	private String employeeNumber;
	
	@Column(name="employee_name", nullable=false)
	private String employeeName;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="sex", nullable=true)
	private String sex;

	@Column(name="employee_type", nullable=false)
	private String employeeType;
	
	@Column(name="startdate", nullable=false)
	private Date startDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	@JsonIgnore 
	private Set<Address> addresses = new HashSet<Address>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	@JsonIgnore 
	private Set<EmployeeContacts> contacts = new HashSet<EmployeeContacts>();

	/*@ManyToMany(fetch = FetchType.LAZY, mappedBy = "department")
	@JsonIgnore 
	private Set<Department> addresses = new HashSet<Department>();*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Set<EmployeeContacts> getContacts() {
		return contacts;
	}

	public void setContacts(Set<EmployeeContacts> contacts) {
		this.contacts = contacts;
	}

	public Employee(long id, String employeeNumber, String firstName, String lastName, 
			String sex, String employeeType, Date startDate, Set<Address> addresses, Set<EmployeeContacts> contacts)  {
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
	
	public Employee() {
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
		Employee other = (Employee) obj;
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
