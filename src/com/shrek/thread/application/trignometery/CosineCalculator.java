package com.shrek.thread.application.trignometery;

public class CosineCalculator implements Runnable {

	double value;
	Thread t;	
	double sol;

	CosineCalculator(double value){
		this.value=value;
		t = new Thread(this,"cosine");
		t.start();
	}

	public void run(){
		try{
			sol = Math.cos(Math.toRadians(value));
			//System.out.println("cos sol is "+sol);
			Thread.sleep(1000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}