package com.shrek.miscellaneous;

public class Main12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(args[0]);
		boolean assertOn=true;
		assert (assertOn) : assertOn=false;
		if(assertOn!=false){
			System.out.println("HELLO WORLD");
		}
		/* int argCount = args.length;
		 
	        assert argCount == 5 : "The number of arguments must be 5";
	 
	        System.out.println("OK");*/
	}

}
