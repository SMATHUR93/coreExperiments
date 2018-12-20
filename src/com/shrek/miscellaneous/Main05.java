package com.shrek.miscellaneous;

public class Main05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=5;
		Main05 main=new Main05();
		x = main.inc(5);
		System.out.println("IN MAIN "+x);
	}
	
	public int inc(int x){
		System.out.println("In INC "+ x++ );
		return x;
	}
	
}
