package com.dal.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.dal.model.Employee;



public class EmpControllerConSup {

	private transient Scanner sc = new Scanner(System.in);
	List<Employee> emplist = new ArrayList<>();
	//Consumer
	Consumer<List<Employee>> conlst = li->{
		 li.forEach(e ->System.out.println(e));
	 };
	 //Supplier
	 Supplier<List<Employee>> suplst =()->{return emplist;}; 
	 
	 public void addEmployee(int eno, String ename)	{
		 emplist.add(new Employee(eno,ename));
	 }
	 
	 public void ViewEmployee() {
	    conlst.accept(emplist);		
	 }
	 
	 public List<Employee> GetEmployee() {
	  	return suplst.get();
	 }
	
}
