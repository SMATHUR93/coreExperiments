package com.shrek.mixedInheritance;

abstract class Shape{
	int x;
	int y;
	void center(int x,int y){
		this.x=x;
		this.y=y;
	}
	abstract void area();
	abstract void perimeter();
}

abstract class circle extends Shape{
	int radius;
	void area(){}
}

public class Main06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
