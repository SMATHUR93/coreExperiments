package com.shrek.mixedInheritance;

class A2{
	private String msg;
	
	A2(){
		this("blah");
	}
	
	A2(String msg){
		this.msg=msg;
	}
	
	String getMsg(){return msg;}
}

class B2 extends A2{
	void meth1(){}
	void meth2(){}
}

public class Main01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test11 tester1 = new Test13();
		
	}

}
