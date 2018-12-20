package com.shrek.mixedInheritance;

class A1{
	public String val;
	public String meth(){
		val="HELL";
		return val;
	}
}
class B1{
	public A1 a1;
	public String method(){
		return a1.meth();
	}
}
class C1{
	public void methodology(){
		B1 b1=new B1();
		System.out.println(b1.method());
	}
}

public class Main03 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C1 c1=new C1();
		c1.methodology();
	}
}
