package com.shrek.abstracts;

public abstract class Test2 extends Test1{
	
	int shrekLucky=5;
	
	Test2(){
		super();
		System.out.println("abstract sub class Constructor");		
	}
	
	public void fun(int shrekLucky){		
		System.out.println("This is theeeeeee subclass abstract Shreks Lucky "+this.shrekLucky);
		System.out.println("This is theeeeeee subclass abstract Shreks Lucky "+shrekLucky);
	}

}
