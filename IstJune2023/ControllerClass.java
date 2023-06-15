package com.dal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;


import com.dal.dao.EmployeeDao;
import com.dal.model.Employee;

//import java.util.Scanner;
public class ControllerClass {
    //	Scanner sc = new Scanner();
	List<Employee> list = new ArrayList<>();
	Employee mc;// = new ModelClass();
	//Consumer<ModelClass> mc1 = m -> System.out.println(m);
	//Supplier<ModelClass> gs = ()-> {return mc;}; 
	//Consumer
	EmployeeDao empdao = new EmployeeDao();
	Consumer<List<Employee>> conlst = li->{
		 li.forEach(e ->System.out.println(e));
	 };
	 //Supplier
	 Supplier<List<Employee>> suplst =()->{return list;}; 
	public void addEmployee(int Empno, String Empname)
	{
		//	sc.nextLine();
		//mc.setEmpName("Arya"); 
		//mc.setEmpNo(101);
		 mc = new Employee(Empno,Empname); 
		list.add(mc);
		empdao.insertEmployee(mc);
		
				
	}
	public void LoadEmployeToList() {
		list = empdao.LoadEmployee();
	}
	public void UpdateEmplyee(int Empno,String Empname) {
		mc=new Employee(Empno,Empname);
		
		for(int index=0;index<list.size();index++)
		{
			if(list.get(index).getEmpno() == Empno)
			{
				list.set(index, mc);
				break;
			}
			
		}
		empdao.updateEmployee(mc);
	}
	public void DeleteEmployee(int Empno) {
		
		for(int index=0;index<list.size();index++)
		{
			if(list.get(index).getEmpno() == Empno)
			{
				list.remove(index);
				break;
			}
			
		}
		empdao.deleteEmployee(Empno);
	}
    public void ViewEmployee()
    {
    	conlst.accept(list);
    	//System.out.println("Employe Name:"+mc.getEmpName());
		//System.out.println("Employee No:"+mc.getEmpNo());
    	//mc1.accept(mc);
    	System.out.println("Data from DB");
    	empdao.showEmployee();
    }
    public List<Employee> GetEmployee() {
    	//System.out.println(gs.get());
    	//gs.get().forEach(e->System.out.println(e););
    	return suplst.get();
    }
   
    public void SortEmployee() {
    	Collections.sort(list);
    	System.out.println(list);
    }
    
    public void SortEmployeeNoComparator() {
    	Collections.sort(list, Employee.empnumberComparator);
    	System.out.println(list);
    }
    public void SortEmpNameComparator() {
    	Collections.sort(list, Employee.empnameComparator);
    	System.out.println(list);
    }
}