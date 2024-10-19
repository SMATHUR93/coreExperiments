package com.shrek.string;

import java.util.ArrayList;
import java.util.List;

public class CombinationsFromAString {

	static List<String> outputList = new ArrayList<String>();
	
	static void getCombinations(String input, String output, int permutationSize) {
		if(output.length()==permutationSize) {
			//System.out.println("--PSC--"+input + " - " + output);
			outputList.add(output);
			return;
		}
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			//String leftStr = input.substring(0, i);
			String rightStr = input.substring(i+1);
			//System.out.println(rightStr + " + " + (output + ch) );
			getCombinations( rightStr, output + ch, permutationSize);
		}
	}
	
	public static void main(String[] args) {
		String input = "abcde";
		//List<String> outputList = new ArrayList<String>();
		getCombinations(input, "", 2);
		System.out.println(outputList);
	}
	
}