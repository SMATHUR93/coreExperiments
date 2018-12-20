package com.shrek.interfaces;

interface King{
	public void myMeth();
}

class Shrek implements King{
	public void myMeth(){
		System.out.println("Hello king Shrek");
	}
	protected void meth(){
		System.out.println("Hello Shrek & Heisenburg");
	}
}

class Beast extends Shrek{
	public void myMeth(){
		System.out.println("Hello King SHREK_d_BEAST");
	}
	public void meth(){
		System.out.println("Hello Shrek_d_beast & Heisenburg");
	}
}

class North extends Beast implements King{
	King king;
	public void meth(){
		System.out.println("Hello King in the North & Heisenburg");
	}
}

abstract class Batman implements King{
	public void meth(){
		System.out.println("Hello Dark Knight & Heisenburg");
	}
}

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shrek shrek=new Shrek();shrek.myMeth();
		Beast beast=new Beast();beast.myMeth();
		North north=new North();
		north.myMeth();
		King king=new King(){
			public void myMeth(){
				System.out.println("Hello King in the north");
			}
		};
		north.king=king;
		north.king.myMeth();		
		
		System.out.println("DARK KNIGHT RETURNS");
		
		Batman batman=new Batman(){
			public void myMeth(){
				System.out.println("Hello King Batman");
			}
		};
		batman.meth();
		batman.myMeth();
		
	}

}