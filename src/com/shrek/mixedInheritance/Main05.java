package com.shrek.mixedInheritance;

abstract class C11{
	C11(){
		System.out.println("11");
	}
	C11(int a,int b){
		System.out.println("54 ,45");
	}
	public C11 foo(){
		System.out.println("foo in C11");
		return this;
	}
}

class C22 extends C11{
	C22(){
		System.out.println("22");
	}
	public C11 foo(){
		System.out.println("foo in C22");
		return this;
	}
}

class C33 extends C22{
	C33(){
		System.out.println("33");
	}
	public C11 foo(){
		System.out.println("foo in C33");
		return this;
	}
}

public class Main05 {

	public static void main(String[] args) {
		
		new C33();
		
	}
	
}
