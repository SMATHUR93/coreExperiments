package com.shrek.miscellaneous;

class Foo{
	
	public int a=420;
	
	public void inc(){
		a+=80;
		System.out.println("INC FOO ");
	}	
}

class Bar extends Foo{
	public int a=840;
	
	public void inc(){
		this.a+=60;
		System.out.println("INC BAR ");
	}
}

public class Main06 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bar obj=new Bar();
		System.out.println(obj.a);
		obj.inc();
		System.out.println(obj.a);
	}
}
