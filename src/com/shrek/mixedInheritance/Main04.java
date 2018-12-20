package com.shrek.mixedInheritance;

class A3{
	String name;//="A3"
	String getName(){
		return this.name;
	}
	String getMess(){
		return "Class A3";
	}
}

class B3 extends A3{
	String name="B3";

	String getMess(){
		System.out.println("b3 "+this.name);
		return "Class B3";
	}
}

public class Main04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A3 a3=new A3();
		B3 b3=new B3();
		a3.name="SHRERK";
		b3.name="NIPKOL";
		System.out.println(a3.getName()+"   "+a3.getMess());
		System.out.println(b3.getName()+"   "+b3.getMess());
	}

}
