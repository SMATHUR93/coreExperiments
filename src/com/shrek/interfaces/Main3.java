package com.shrek.interfaces;

public class Main3 {

	String var;
	
	public Main3(String var){
		this.var=var;
	}
	
	public String get(){
		return var;
	}
	
}

class Sub extends Main3{
	public Sub(){		
		super("");
	}
	public void doThuis(){};
	public void doThese(){};
}