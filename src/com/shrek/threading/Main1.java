package com.shrek.threading;

public class Main1 extends Thread{

	char threadName;
	int count=0;
	
	Main1(char threadName, int count){
		this.threadName = threadName;
		this.count = count;
	}
	
	public void run() {
		for(int i=0;i<this.count;i++) {
			System.out.println("I am printing "+this.threadName+i);
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		int noOfThreads = (int) Math.abs((Math.random()*10));
		char[] threadCodes = {'a','b','c','d','e','f','g','h','i','j'};
		
		Main1[] main1ObjArray = new Main1[ noOfThreads ];
		
		/*main1ObjArray[0] = new Main1( 'a', (int) Math.abs((Math.random()*10)) );
		main1ObjArray[1] = new Main1( 'b', (int) Math.abs((Math.random()*10)) );
		main1ObjArray[2] = new Main1( 'c', (int) Math.abs((Math.random()*10)) );
		main1ObjArray[3] = new Main1( 'd', (int) Math.abs((Math.random()*10)) );*/
		
		// Running the threads without Join() lets threads run without waiting for each other
		System.out.println("---------------------------------------------------");
		System.out.println(noOfThreads);
		System.out.println("---------------------------------------------------");
		
		for(int i=0;i<noOfThreads;i++) {
			main1ObjArray[i] = new Main1( threadCodes[i], (int) Math.abs((Math.random()*10)) );
			main1ObjArray[i].start();
			main1ObjArray[i].join();
		}
		
	}
	
}
