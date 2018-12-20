package com.shrek.thread.application.trignometery;

public class SineCalculator implements Runnable{
	
	double value;
	Thread t;
	double sol;
	
	SineCalculator(double value){
		this.value=value;
		t = new Thread(this,"sine");
		t.start();
	}
	
	public void run(){
		try{
			sol = Math.sin(Math.toRadians(value));
			//System.out.println("sin sol is "+sol);
			Thread.sleep(1000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}