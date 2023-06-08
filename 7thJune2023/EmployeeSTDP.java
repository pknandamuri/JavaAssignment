package designpattern;

class EmployeeST{
	
	private static EmployeeST EmployeeSTInst = null;
	
	
	private EmployeeST(){
		// Private constructor to prevent instantiation from outside the class		
	}
	
	public static EmployeeST getInstance()
	{
		if(EmployeeSTInst == null){
			EmployeeSTInst = new EmployeeST();
		}
		return EmployeeSTInst;
	}
	
	private int empno;
	private String ename;

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

}

public class EmployeeSTDP {
	
	public static void main(String[] args) {
		
		EmployeeST stObj = EmployeeST.getInstance();
		stObj.setEmpno(101);
		stObj.setEname("Kumar");		
		System.out.println(stObj.getEmpno());
		System.out.println(stObj.getEname());
        System.out.println(stObj);
        System.out.println(stObj.hashCode());
        
        
        EmployeeST stObj1 = EmployeeST.getInstance();
		stObj1.setEmpno(102);
		stObj1.setEname("Raja");		
		System.out.println(stObj1.getEmpno());
		System.out.println(stObj1.getEname());
        System.out.println(stObj1);
        System.out.println(stObj1.hashCode());
	}
}