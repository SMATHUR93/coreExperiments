package com.shrek.puzzles;

import java.util.Scanner;;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		System.out.println("Enter Number of Shipments :");
		//int shipments = input.nextInt();
		Executive.shipmentsToComplete = input.nextInt();
		
		System.out.println("Enter Number of Executives :");
		int numberOfExecutives = input.nextInt();
		
		Executive[] executivesArray = new Executive[numberOfExecutives];
		for(int i=0;i<numberOfExecutives;i++){
			System.out.println("Enter time to execute for Executive "+((i+1))+" :");
			int timeToEexcute = input.nextInt();
			//System.out.println(message);
			executivesArray[i] = new Executive(i+1, timeToEexcute);
		}

		try{	
			for(int i=0;i<numberOfExecutives;i++){
				executivesArray[i].thread.start();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
	}

}
