package com.shrek.miscellaneous;

class Super{
	
	public int num;
	
	protected Super(int num){
		this.num=num;
	}
}

class Sub extends Super{
	
	public Sub(int num){
		super(num);
	}
	
	public Sub(){
		super(67);
	}
}

public class Main08 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Super obj=new Sub(56);
		System.out.println(obj.num);
	}
}
