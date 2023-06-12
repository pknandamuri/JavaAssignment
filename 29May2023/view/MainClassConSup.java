package com.dal.view;

import com.dal.controller.EmpControllerConSup;
import java.util.function.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import com.dal.exception.UserNotFoundException;
import com.dal.model.Employee;
import com.dal.controller.EmployeeController;
import com.dal.controller.EmployeeInterface;

public class MainClassConSup {

	
	public static void main(String[] args) {
		try {
				System.out.println("Welcome to EMS :)");
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader bf = new BufferedReader(isr);
				System.out.println("Enter user name");
				String usr = bf.readLine();
				System.out.println("Enter password");
				String pass = bf.readLine();
				System.out.println("Please wait loading...");
				Thread.sleep(3000);
				//BiPredicate
				BiPredicate<String, String> usrpass = (u,p) ->{
					return (u.equals("kumar") && p.equals("npk"));
				};
			
				if(!usrpass.test(usr,pass))	{
					throw new UserNotFoundException();
				}
				
				EmpControllerConSup cc = new EmpControllerConSup();
				Scanner sc = new Scanner(System.in);
				String co = null;
				do {
					System.out.println("Enter your choice");
					System.out.println("1. Add Employee");
					System.out.println("2. View Employee");
					System.out.println("3. Get Employee");
					int choice = sc.nextInt();
					switch(choice)
					{
						case 1:
							System.out.println("Enter employee number");
							int eno = Integer.parseInt(bf.readLine());
							System.out.println("Enter emplyee name");
							String enam = bf.readLine();
							cc.addEmployee(eno,enam);
							break;
						case 2:
							cc.ViewEmployee();
							break;
						case 3:
							List<Employee> li =cc.GetEmployee();
							li.forEach(e-> System.out.println(e));
							break;
						default:
							System.out.println("Enter valid number");
							break;
					}
					System.out.println("Do you want to continue y/n");
					co = sc.next();
				
				}while(co.equals("y") || co.equals("Y"));
			}
			catch(UserNotFoundException un) {
				un.printStackTrace();
			}
			catch(IOException io) {
				io.printStackTrace();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			System.out.println("Exit Application");
			System.exit(0);
	}
}