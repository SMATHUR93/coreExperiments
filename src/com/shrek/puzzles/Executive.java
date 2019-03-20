package com.shrek.puzzles;

import java.util.HashMap;
import java.util.Map;

public class Executive implements Runnable{

	static int executionTime = 0;
	static int totalShipmentsCompleted = 0;
	static int shipmentsToComplete;
	int executiveNumber;
	int timeToExecute;
	int shipmentsCompleted = 0;
	Thread thread;	

	Executive(int executiveNumber, int timeToExecute){
		this.executiveNumber = executiveNumber;
		this.timeToExecute=timeToExecute;	
		thread=new Thread(this);
	}
	
	public void run(){
		try {
			while(true){
				if(Executive.shipmentsToComplete==Executive.totalShipmentsCompleted){
					System.out.println("ALL SHIPMENTS COMPLETED IN "+ Executive.executionTime);
					break;
				}
				Executive.executionTime = Executive.executionTime + this.timeToExecute;
				/*if((Executive.executionTime - this.timeToExecute) < 0){
				} else{
					Executive.executionTime = Executive.executionTime + (Executive.executionTime - this.timeToExecute);
				}*/
				Executive.totalShipmentsCompleted++;
				this.shipmentsCompleted++;
				System.out.println("Executive "+this.executiveNumber+" who takes time "+this.timeToExecute+" has done "+this.shipmentsCompleted+" shipments out of total "+Executive.totalShipmentsCompleted+" shipments and increased ovewrall time by "+Executive.executionTime);
				System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}