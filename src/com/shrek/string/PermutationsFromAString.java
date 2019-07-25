package com.shrek.string;

import java.util.List;
import java.util.ArrayList;

public class PermutationsFromAString {

	static List<String> outputList = new ArrayList<String>();
	
	static void getPermutations(String input, String output) {
		if(input.length()==0) {
			//System.out.println("--IPC--"+input + " - " + output);
			outputList.add(output);
			output= "";
			return;
		}
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			String leftStr = input.substring(0, i);
			String rightStr = input.substring(i+1);
			getPermutations(leftStr + rightStr, output + ch);
		}
	}
	
	public static void main(String[] args) {
		String input = "abc";
		//List<String> outputList = new ArrayList<String>();
		getPermutations(input, "");
		System.out.println(outputList);
	}
	
}
