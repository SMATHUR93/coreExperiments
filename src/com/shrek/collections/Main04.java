package com.shrek.collections;

public class Main04 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Age<String> e1=new Age<String>("25-02-1993");
		System.out.println(e1.getDob());
		e1.setDob("25/02/1993");
		System.out.println(e1.getDob());
	}
}
class Age<T>{
	T dob;
	public T getDob() {
		return dob;
	}
	public void setDob(T dob) {
		this.dob = dob;
	}
	public Age(T dob) {
		super();
		this.dob = dob;
	}	
}