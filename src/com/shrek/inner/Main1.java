package com.shrek.inner;

interface shrek<T>{
	public T myFun(T t);
}

public class Main1 {

	class Shredder implements shrek<Main1>{
		@Override
		public Main1 myFun(Main1 t) {
			// TODO Auto-generated method stub
			System.out.println("IN  MY FUN ");
			return t;
		}		
	}
	
	Main1 myMethod(){
		System.out.println("IN MY METHOD");
		return( new Shredder().myFun(this) );
	}
	
	Main1(){
		System.out.println("NULL CONSTRUCTOR");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Main1 mainObj=new Main1();
		System.out.println(mainObj.myMethod());
		
	}

}
