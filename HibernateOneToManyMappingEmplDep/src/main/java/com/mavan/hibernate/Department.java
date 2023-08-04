package com.mavan.hibernate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Department 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentid;
	@Column(length = 40, nullable = false, unique = true)
	private String departmentname;
	@Column(length = 40, nullable = false, unique = true)
	private String departmentlocation;
	// Make a references
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name = "departmentid")
	private List<Employee> employee;
	
	public Department() {
		super();
	}
	public Department(String departmentname, String departmentlocation) {
		super();
		this.departmentname = departmentname;
		this.departmentlocation = departmentlocation;
	}
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getDepartmentlocation() {
		return departmentlocation;
	}
	public void setDepartmentlocation(String departmentlocation) {
		this.departmentlocation = departmentlocation;
	}
	
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Department [departmentid=" + departmentid + ", departmentname=" + departmentname
				+ ", departmentlocation=" + departmentlocation + "]";
	}
	
	
}
