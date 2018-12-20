package com.shrek.thread.application.trignometery;

public class TangentCalculator implements Runnable {
	
	double value;
	Thread t;	
	double sol;
	
	TangentCalculator(double value){
		this.value=value;
		t = new Thread(this,"tangent");
		t.start();
	}
	
	public void run(){
		try{
			sol = Math.tan(Math.toRadians(value));
			//System.out.println("tan sol is "+sol);
			Thread.sleep(1000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}