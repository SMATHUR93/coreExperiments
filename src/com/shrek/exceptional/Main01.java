package com.shrek.exceptional;

public class Main01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A a=new A();
		/*try{
			System.out.println("Main Trys Exception");
			a.aMethod();
			System.out.println("Without Exceptions");
		}
		catch(Exception e){
			System.out.println("Main catches Exception");
		}*/
		
			System.out.println("Main Trys Exception");
			a.aMethod();
			System.out.println("Without Exceptions");		
	}
}

class A{
	public void aMethod(){
		try{
			B b=new B();
			System.out.println("Trying in A ");
			b.bMethod();
		}
		catch(C e){
			System.out.println("Catching in A ");
			throw new RuntimeException(e);
		}
	}
}

class B{
	public void bMethod() throws C{
		System.out.println("Trying in B ");
		throw new C(); 
	}
}

class C extends Exception{}