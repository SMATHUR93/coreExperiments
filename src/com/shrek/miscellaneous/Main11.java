package com.shrek.miscellaneous;

interface A{
	int x=1;
	void meth1(int a);
	int meth2(int a);
};
interface B{
	int x=2;
	void meth1(int a,int b);
	int meth2(int a,int b);
};
interface C extends A,B{
	int x=3;
	void meth1(int a,int b,int c);
	int meth2(int a,int b,int c);
};
class D implements C{

	@Override
	public void meth1(int a) {
		// TODO Auto-generated method stub
		System.out.println("meth1  and a = "+a);
	}

	@Override
	public int meth2(int a) {
		// TODO Auto-generated method stub
		System.out.println("meth2  and a = "+a);
		return a;
	}

	@Override
	public void meth1(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("meth1  and a = "+a+" , b = "+b);
	}

	@Override
	public int meth2(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("meth2  and a = "+a+" , b = "+b);
		return a+b;
	}

	@Override
	public void meth1(int a, int b, int c) {
		// TODO Auto-generated method stub
		System.out.println("meth1  and a = "+a+" , b = "+b+" , c = "+c);
		
	}

	@Override
	public int meth2(int a, int b, int c) {
		// TODO Auto-generated method stub
		System.out.println("meth2  and a = "+a+" , b = "+b+" , c = "+c);
		return a+b+c;
	}
	
};

public class Main11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D d=new D();
		System.out.println("HELLO "+ d.meth2(2, 5, 3) +" WORLD ");
		System.out.println(C.x);
	}

}
