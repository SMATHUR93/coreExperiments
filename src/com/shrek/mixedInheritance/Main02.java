package com.shrek.mixedInheritance;

class A{
	
	int val1;
	String val2;
	
	A(){
		//this(56);
		System.out.println("Null cons");
		this.val2+="d_beast";
		//System.out.println(this.val2);
	}
	
	A(int val1){
		this();
		//System.out.println("single param cons");
		this.val1=val1;
		this.val2+="Shrek";		
	}
}

public class Main02 {

	public static void main(String[] args) {
		A obj=new A(34);
		System.out.println(obj.val1);
		System.out.println(obj.val2);
	}
	
}
