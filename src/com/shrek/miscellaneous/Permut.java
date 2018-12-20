package com.shrek.miscellaneous;

import java.util.Scanner;

public class Permut {

	public static void permut(char[] c){
		if(c.length>0){
			permut(c);
			for(int i=0;i<c.length;i++){
				System.out.print(c[i]);
			}
			System.out.println();
		}
		else{
			permut(c);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a String");
		String inputString=input.next();
		char[] inputArr = inputString.toCharArray();
		Permut.permut(inputArr);
		input.close();
		
	}
	
}
