package com.dedalus;

public class Day1Assignment {


	static int myStaticVar = 20;
	
	public static void main(String[] args) {
		int myLocalVar=30;
		
		MyDay1AssClass obj = new MyDay1AssClass();
		obj.voidmethod(myLocalVar);
		int rtnValue = obj.returnmethod(myStaticVar,myLocalVar);
		System.out.println("returnmethod returns: " + rtnValue);
		
		System.out.println("myInstVar variable is: " + obj.myInstVar);	
		System.out.println("myStaticVar variable is: " + myStaticVar);
		System.out.println("myLocVar variable is: " + myLocalVar);
	
	}	
}

class MyDay1AssClass
{
	int myInstVar = 10;
	void voidmethod(int x)
	{
		System.out.println("Void method called and parameter passed is: " + x);
	}
	
	int returnmethod(int x, int y)
	{
		return x+y;
	}
	
}
