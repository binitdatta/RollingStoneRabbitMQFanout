package com.rollingstone.model;

public class DepartmentDTO {
	private long id;
	private String deptNumber;
	private String deptName;
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeptNumber() {
		return deptNumber;
	}

	public void setDeptNumber(String deptNumber) {
		this.deptNumber = deptNumber;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public DepartmentDTO(long id, String deptNumber, String deptName, String description) {
		super();
		this.id = id;
		this.deptNumber = deptNumber;
		this.deptName = deptName;
		this.description = description;
	}
	
	public DepartmentDTO() {
		super();
	}

	
	@Override
	public String toString() {
		return "Department [id=" + id + ", deptNumber=" + deptNumber + ", deptName=" + deptName + ", description =" + description +" ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptNumber == null) ? 0 : deptNumber.hashCode());
		result = prime * result + ((deptName == null) ? 0 : deptName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		DepartmentDTO other = (DepartmentDTO) obj;
		if (deptNumber == null) {
			if (other.deptNumber != null)
				return false;
		} else if (!deptNumber.equals(other.deptNumber))
			return false;
		if (deptName == null) {
			if (other.deptName != null)
				return false;
		} else if (!deptName.equals(other.deptName))
			return false;
		if (id != other.id)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
}
