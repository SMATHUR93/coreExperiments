package com.shrek.miscellaneous;


public class Main10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main10 obj=new Main10();
		//int[] df={44,343,34,43,434,4343};
		System.out.println(obj.meth1(3,3));
	}
	
	public String meth1(int a , int b){
		return "a";
	}
	
	public String meth1(int... vals){
		return "b";
	}
}
