package mypack;

abstract class AbstClass{
	public abstract void AbstMethod();
}

class MyOuter
{
	int x =7;
	int instanceVar = 10; 
	
	class MyInner extends AbstClass
	{
		public void InnerMethod()
		{
			int localVar = 20; 
			System.out.println("x == " + x);
			System.out.println("My instance variable == " + instanceVar); 
			System.out.println("My local variable == " + localVar); 
		}
		
        public void AbstMethod() {
            System.out.println("Abstract method called"); 
        }
	}
	
	public void OuterMethod()
	{
		System.out.println("From outer method = " + x);
		MyInner inn = new MyInner();
		inn.InnerMethod();
	}
	
	class MyInnerChild extends MyInner
	{
		
	}
	
	public static void main(String[] a)
	{
		MyOuter mo = new MyOuter();
		//MyInner inn = new MyInner(); //invalid
		//inn.InnerMethod();
		//<outerclassname>.<innerclassname> objname = <outerclass instancename>.new <innerclassname>();
		MyOuter.MyInner mi = mo.new MyInner(); //instantiate inner class
		mi.InnerMethod();
		mi.AbstMethod();
		
		mo.OuterMethod();
		//mi.OuterMethod();  illegal
		//mo.InnerMethod();   illegal 
	}

}

// Check whether the inner class can be abstract - No
// can it be inherited? - Yes
// scope of instance variable within the inner class - Able to access
// scope of local variable within the inner class - Able to access







