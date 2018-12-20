package com.shrek.thread.application.vowelcounter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		System.out.println("Enter Number of Counters :");
		int counter = input.nextInt();		
		
		CounterClass[] counterArray = new CounterClass[counter];
		for(int i=0;i<counter;i++){
			System.out.println("Enter text for counter "+(i+1)+" :");
			String message = input.next();			
			//System.out.println(message);
			counterArray[i] = new CounterClass(message);			
		}
		
		try{
			for(int i=0;i<counter;i++){
				counterArray[i].thread.join();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
		Set<Character> keySet = CounterClass.charMap.keySet();
		char[] charArray = new char[keySet.size()];
		int j=0;
		Iterator<Character> charCounter = keySet.iterator();
		while(charCounter.hasNext()){
			char character=charCounter.next();
			charArray[j]=character;
			j++;
		}
		Arrays.sort(charArray);
		System.out.println("Vowels count in given text are :");
		for(int i=0;i<charArray.length;i++){
			System.out.print(charArray[i]+":"+CounterClass.charMap.get(charArray[i])+" ");
		}
	}
}
