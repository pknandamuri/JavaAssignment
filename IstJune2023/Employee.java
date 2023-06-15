package com.dal.model;

import java.io.Serializable;
import java.util.Comparator;

public class Employee implements Serializable,Comparable<Employee>{
	private int empno;
	private String ename;

	public Employee(int EmpNo, String EmpName) {
		this.empno = EmpNo;
		this.ename = EmpName;
	}
	
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + "]";
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.empno - o.empno;
	}
	
	public static Comparator<Employee> empnumberComparator = new Comparator<Employee>() {		
		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.empno - o2.empno;
		}
	};
	
	public static Comparator<Employee> empnameComparator =(o1, o2) -> o1.getEname().compareTo(o2.getEname()) ;
}
