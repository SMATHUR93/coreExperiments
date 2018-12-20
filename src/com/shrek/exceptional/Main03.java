package com.shrek.exceptional;

class A3 extends Exception{}
class B3 {
	public String meth(String name) throws A3{
		if(name==null)
			throw new A3();
		return "hello "+name;
	}	
}

public class Main03 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B3 b3=new B3();
		try {
			System.out.println(b3.meth("Shrek"));
		} catch (A3 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
