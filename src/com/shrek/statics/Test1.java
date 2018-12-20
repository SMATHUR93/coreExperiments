package com.shrek.statics;

public class Test1 {

	static String shredder="Shredder";
	
	static{
		System.out.println("Hello Shrek");
	}
	
	public static void fun(){
		System.out.println("I M HAVING FUN");
	}
	
	public void moreFun(){
		System.out.println("I M HAVING MORE FUN "+Test1.shredder);
	}
	
}
