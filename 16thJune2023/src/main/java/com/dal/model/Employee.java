package com.dal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity		//table - mandatory
//@Table(name = "DedaEmp") //table name - This will be the table name, if we use Table annotation 	
@NamedQueries(
		{ 
			@NamedQuery(name = "GET_EMP_BY_ID", query = "from Employee e where e.eid=:id"),
		    @NamedQuery(name = "GET_EMP_BY_DEPTNO", query = "from Employee e where e.did=:did") 
		})
public class Employee {

	@Id		//primary key - mandatory
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_sequence")
	@SequenceGenerator(name = "emp_sequence", allocationSize = 1)
	private int eid;

	@Column
	@Embedded	//@Embedded is used to embed a type into another entity
	private Name ename;
	private String email;
	private String password;
	private String gender;

	@OneToOne	//Employee can have only one department
	@JoinColumn(name = "DEPTID")
	private Department did;

	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)	//Employee can have multiple address - CascadeType.ALL propagates all operations — including Hibernate-specific ones — from a parent to a child entity.
	private List<Address> address;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, Name ename, String email, String password, String gender, Department did) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.did = did;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public Name getEname() {
		return ename;
	}

	public void setEname(Name ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Department getDid() {
		return did;
	}

	public void setDid(Department did) {
		this.did = did;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", did=" + did + ", address=" + address + "]";
	}
}
