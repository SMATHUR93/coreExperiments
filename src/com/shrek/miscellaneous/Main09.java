package com.shrek.miscellaneous;

import java.io.IOException;

class Superman{
	static String str="Shrek";
	static{
		assert(str!=null);		
	}
	public void myMeth() throws IOException{
		System.out.println("OLA AMIOGOS");
	}
}

class Subman extends Superman{
	public void myMeth() throws IOException{
		super.myMeth();
		System.out.println("ASTA LE VISTA AMIGOs");
		throw new IOException();
	}
}

public class Main09 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Superman obj=new Subman();
		try{
			obj.myMeth();
		}
		catch(Exception e){
			System.out.println("Error has occured");
		}
		
		//assert(obj.str==null);	
	}
}
