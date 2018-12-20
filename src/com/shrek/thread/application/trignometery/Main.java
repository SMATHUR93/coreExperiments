package com.shrek.thread.application.trignometery;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double sum=0.0;
		Scanner input =new Scanner(System.in);
		System.out.println("Enter the Degree for Sin :");
		double input1=input.nextDouble();
		SineCalculator sinObj=new SineCalculator(input1);
		System.out.println("Enter the Degree for Cos :");
		double input2=input.nextDouble();
		CosineCalculator cosObj=new CosineCalculator(input2);
		System.out.println("Enter the Degree for Tan :");
		double input3=input.nextDouble();
		TangentCalculator tanObj=new TangentCalculator(input1);
		try{
			sinObj.t.join();
			cosObj.t.join();
			tanObj.t.join();
			sum = sinObj.sol + cosObj.sol + tanObj.sol;
			System.out.println("SUM OF SINE, COSINE AND TANGENT FOR "+input1+" , "+input2+" AND "+input3+" RESPECTIVELY IS "+sum);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}