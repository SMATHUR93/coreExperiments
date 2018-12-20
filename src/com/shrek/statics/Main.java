package com.shrek.statics;

public class Main {
	
	static{
		System.out.println("Good Morning");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 tester = new Test1();
		Test1.fun();
		tester.moreFun();
		System.out.println(Test1.shredder);
	}

}
