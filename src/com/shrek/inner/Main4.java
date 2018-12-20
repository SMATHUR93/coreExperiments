package com.shrek.inner;

interface ShrekInterface{
	int myMethod();
}

public class Main4 {

	public int shredder(ShrekInterface shrekInterface){
		return shrekInterface.myMethod();
	}
	
	public int realShredder(){
		return shredder(
				new ShrekInterface(){
					public int myMethod(){
						return 420;
					}
				}
		);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 mainObj=new Main4();
		System.out.println(mainObj.realShredder());
		System.out.println("IN MAIN");
	}

}
