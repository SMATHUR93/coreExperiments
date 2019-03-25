package com.shrek.miscellaneous;

import java.util.Scanner;

public class LCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter how many numbers : ");
		int n = input.nextInt();
		int[] numbersArray = new int[n];
		for(int i=0;i<n;i++) {
			System.out.println("Enter "+(i+1)+" number");
			numbersArray[i] = input.nextInt();
		}
		int lcm = 1;
		boolean isDivisible = false;
		do {
			lcm++;
			int j;
			isDivisible = true;
			for(j = 0;j<n;j++) {
				if(lcm%numbersArray[j]!=0) {
					isDivisible = false;
					break;
				}
			}
			if(isDivisible) {
				break;
			}
		} while(true);
		System.out.println();
		System.out.print("LCM of ");
		for(int i=0;i<n;i++) {
			if(i==n-1) {
				System.out.print(numbersArray[i]+" ");
			} else {
				System.out.print(numbersArray[i]+", ");
			}
		}
		System.out.println("is "+lcm);
	}

}
