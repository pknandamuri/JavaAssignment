package mypack;

class Employee {

	int empno;
	String ename = "Asha";

	Salary sal = new Salary(); //HAS_A - Employee has salary
	
	public Employee() {
	  System.out.println("From Employee Constructor");
	}
	
	public Employee(int x) {
		  this("Mani");
		  this.empno=x;
		  System.out.println("From Employee Constructor: " + x);
	}
	
	public Employee(String str) {
		  
		  System.out.println("From Employee Constructor: " + str);
	}
	public String getDetails() {
		sal.setBasic(10000);
		return (empno + " -- " + ename + " --- " + sal);
	}
	
	public void getSal(double basic) {
		sal.setBasic(basic);
		sal.setDa(basic * 0.8);
		sal.setPf(basic * 0.12);
		sal.setGross(sal.getBasic() + sal.getPf() + sal.getDa());
		sal.setNet(sal.getGross() - sal.getPf());
	}

}

class Manager extends Employee { //IS_A - Manage is employee
	String dept = "IT";
	

	public Manager() {
		super(101);  // used to invoke base clas constructor
		System.out.println("From Mgr Constructor");
		
	}
	
	public String getDetails() {
		 return super.getDetails()+ "--  " + dept;
	}
	
	

}

public class MainClass {

	public static void main(String[] args) {
		Employee emp = new Employee(102);
		emp.getSal(89000);
		System.out.println(emp.getDetails());

		Manager mgr = new Manager();
		System.out.println(mgr.getDetails());

	}

}
