package com.shrek.puzzles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

	public static Map<Character,Integer> occurMap = new HashMap<Character,Integer>();

	static {
		occurMap.put('Z', 1);
		occurMap.put('0', 2);
		occurMap.put('W', 1);
		occurMap.put('H', 1);
		occurMap.put('U', 1);
		occurMap.put('F', 2);
		occurMap.put('X', 1);
		occurMap.put('S', 2);
		occurMap.put('G', 1);
		occurMap.put('N', 3);
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		/*System.out.println("Enter Number of Counters :");
		int counter = input.nextInt();		
		
		Executive[] counterArray = new Executive[counter];
		for(int i=0;i<counter;i++){
			System.out.println("Enter text for counter "+((i+1))+" :");
			String message = input.next();			
			//System.out.println(message);
			counterArray[i] = new Executive(message);			
		}*/
		
		System.out.println("Enter message");
		String message = input.next();	
		String output = null;
		
		for(int i=0;i<message.length();i++){
			if(occurMap.containsKey(message.charAt(i))){
				output = output+message.charAt(i);
			}
		}
		
	}
	
}
