package com.shrek.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfItemsTakenAtATime {

	static List<String> outputList = new ArrayList<String>();
	
	static void getPermutations(String input, String output, int permutationSize) {
		if(input.length()==0) {
			//System.out.println("--IPC--"+input + " - " + output);
			outputList.add(output);
			output= "";
			return;
		}
		if(output.length()>=permutationSize) {
			//System.out.println("--PSC--"+input + " - " + output);
			outputList.add(output);
			output= "";
			return;
		}
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			String leftStr = input.substring(0, i);
			String rightStr = input.substring(i+1);
			getPermutations(leftStr + rightStr, output + ch, permutationSize);
		}
	}
	
	public static void main(String[] args) {
		String input = "abc";
		//List<String> outputList = new ArrayList<String>();
		getPermutations(input, "", 2);
		System.out.println(outputList);
	}
	
}
