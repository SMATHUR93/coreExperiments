package com.shrek.abstracts;

public abstract class Test1 {

	int shrekLucky=3;
	
	Test1(){
		System.out.println("abvstract Constructor");
	}
	
	public void fun(int shrekLucky){
		System.out.println("Shrek is fully abstract lucky "+this.shrekLucky);
		System.out.println("Shrek is fully abstract lucky "+shrekLucky);
	};
	
	public void abstractMethod(){
		
	}
	
}
