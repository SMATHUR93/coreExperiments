package com.shrek.exceptional;

class AA{
	void meth() throws Exception{
		System.out.println("AA");
		throw new Exception();
	}
}
class BB extends AA{
	void meth(){
		System.out.println("BB");
//		if(true)
//		throw new RuntimeException();
//		System.out.println("Blah");
	}
}


public class Main02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AA obj=(AA)new BB();
		try{
			obj.meth();
		}
		catch(Exception e){
			System.out.println("Main Exception");
		}
	}

}
