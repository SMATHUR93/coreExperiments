package com.shrek.thread.application.vowelcounter;

import java.util.HashMap;
import java.util.Map;

public class CounterClass implements Runnable{

	public static Map<Character,Integer> charMap = new HashMap<Character,Integer>();

	static {
		charMap.put('a', 0);
		charMap.put('e', 0);
		charMap.put('i', 0);
		charMap.put('o', 0);
		charMap.put('u', 0);
	}

	String message;
	Thread thread;	

	CounterClass(String message){
		this.message=message;	
		thread=new Thread(this);
		thread.start();
	}

	public void run(){
		char[] array=message.toCharArray();
		char character;
		try {
			for(int i=0;i<array.length;i++){
				character=array[i];
				switch(character){
				case 'a' :
				case 'A' :
				case 'e' :
				case 'E' :
				case 'i' :
				case 'I' :
				case 'o' :
				case 'O' :
				case 'u' :
				case 'U' : 
					CounterClass.myMethod(character);
					break;			
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void myMethod(char character){	
		int Num = charMap.get(character);
		Num++;
		charMap.put(character, Num);
	}
}