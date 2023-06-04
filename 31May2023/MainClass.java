package com.dal.view;

import java.util.Scanner;
import java.io.*;

import com.dal.controller.EmployeeController;
import com.dal.controller.EmployeeInterface;
import com.dal.exception.UserNotFoundException;


public class MainClass implements Serializable {

	public static void main(String[] args) {
		System.out.println("Welcome to EMS :)");
		EmployeeController ec = new EmployeeController();
		Scanner sc = new Scanner(System.in);
		String ch=null;
		try {
			String un = null;
			String pwd = null;

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter Username");
			un = br.readLine();
			System.out.println("Enter Password");
			pwd = br.readLine();

			if (un.equals("Deeps") && pwd.equals("pass")) {
				System.out.println("Welcome " + un);
		
				do {
					System.out.println("Enter your choice");
					System.out.println("1. Add Employee");
					System.out.println("2. View Employee");
					System.out.println("3. Serialize");
			        System.out.println("4. Deserialize");
			        System.out.println("5. Update Employee");
			        System.out.println("6. Delete Employee");
					int choice = sc.nextInt();
					switch (choice) {
						case 1: {							
								try {
									System.out.println("Loading... Please wait.");
						            Thread.sleep(2000);
									ec.addEmployee();
									ec.insertEmployee();
								}
									catch (InterruptedException e) {	
										e.printStackTrace();
								}							
								break;
						}
						case 2: {						
								try {
									System.out.println("Loading... Please wait.");
						            Thread.sleep(2000);
						            ec.viewEmployee();
						            ec.showEmployee();
								}
									catch (InterruptedException e) {
									e.printStackTrace();
									}
								break;
						}
						case 3: {
				            // Serialization
				            try {
				            	FileOutputStream fos = new FileOutputStream("dedalus.txt");
					    		ObjectOutputStream oos = new ObjectOutputStream(fos);
					    		
					    		oos.writeObject(ec);
					    		System.out.println("Serilized to file dedalus.txt");
					    		oos.close();
					    		fos.close();
				                System.out.println("Serialized data is saved in dedalus.txt");
				            } catch (IOException e) {
				                e.printStackTrace();
				            }
				            break;
						}
				        case 4: {
				            // Deserialization
				            try {
				                FileInputStream fis = new FileInputStream("dedalus.txt");
				                ObjectInputStream ois = new ObjectInputStream(fis);
				                EmployeeController deserializedEc = (EmployeeController) ois.readObject(); // Deserialize the EmployeeController object
				                ois.close();
				                fis.close();
				                // Use the deserialized object as needed
				                System.out.println("Loading... Please wait.");
				                Thread.sleep(2000);
				                deserializedEc.viewEmployee(); // Example usage of the deserialized object
				            } catch (IOException e) {
				                e.printStackTrace();
				            } catch (ClassNotFoundException e) {
				                e.printStackTrace();
				            }
				            break;
				        }
				        case 5: {						
							try {
								System.out.println("Loading... Please wait.");
					            Thread.sleep(2000);
					            ec.updateEmployee();
							}
								catch (InterruptedException e) {
								e.printStackTrace();
								}
							break;
				        }
				        case 6: {						
							try {
								System.out.println("Loading... Please wait.");
					            Thread.sleep(2000);
					            ec.deleteEmployee();
							}
								catch (InterruptedException e) {
								e.printStackTrace();
								}
							break;
				        }
				        default: {
				            System.out.println("Enter a valid number");
				            break;
				        }
					}
		
					System.out.println("Do u want to continue Y | y");
					ch = sc.next();
		
				} while (ch.equals("Y") || ch.equals("y"));
			
				System.out.println("Thanks for using our system.");
				System.exit(0);
			} 
			else {
				throw new UserNotFoundException();
			}

		} 
		catch (UserNotFoundException unf) {
			unf.printStackTrace();
		} 
		catch (Exception ae) {
			System.out.println("IO");
		} 
		finally {
			System.out.println("Finally .....");
		}
		System.out.println("Main Ends");
	}
} 
