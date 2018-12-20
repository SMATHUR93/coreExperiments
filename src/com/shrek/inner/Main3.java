package com.shrek.inner;

interface MyInterface1{
	public Object Execute();
}

class MyClass1 implements MyInterface1{
	int var;
	public Object Execute(){  // String
		System.out.println("Parent");
		return new Object();  //return "hello";
	}
}

class MyClass2 extends MyClass1{
	int var;
	public String Execute(){   // Object
		System.out.println("Child");
		return  "HELLO";  // return new Object();
	}
}

public class Main3 {
	int var;
	public Main3 Execute(){
		return new Main3();
	}	
	public static void main(String[] args) {
		Main3 mainObj=new Main3();
		System.out.println(mainObj.Execute());
		//mainObj.var=90;
		//System.out.println(mainObj.var);
		MyClass1 myClass1Obj=new MyClass1();
		System.out.println(myClass1Obj.Execute());
		//MyClass2 myClass2Obj1=new MyClass2();
		//System.out.println(myClass2Obj1.Execute());	
		MyClass1 myClass2Obj2=new MyClass2();
		System.out.println(myClass2Obj2.Execute());	
	}	
}