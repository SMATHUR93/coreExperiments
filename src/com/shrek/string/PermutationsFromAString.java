package com.shrek.string;

import java.util.List;
import java.util.ArrayList;

public class PermutationsFromAString {

	static List<String> outputList = new ArrayList<String>();
	
	static void getPermutations(String input, String output) {
		// System.out.println("--getPermutations recurssions --" + " ,input = " + input  + " ,output = " +output);
		if(input.length()==0) {
			// System.out.println("--IPC--"+input + " - " + output);
			outputList.add(output);
			return;
		}
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			String leftStr = input.substring(0, i);
			String rightStr = input.substring(i+1);
			// System.out.println("--Substrings loop --" + " ,i = " + i  + " ,left Str = " +leftStr  + " ,right Str = " + rightStr  + " ,output = "+ output  + " ,ch = " + ch);
			getPermutations(leftStr + rightStr, output + ch);
		}
	}
	
	public static void main(String[] args) {
		String input = "abc";
		// List<String> outputList = new ArrayList<String>();
		getPermutations(input, "");
		System.out.println(outputList);

		/*char[] arr = input.toCharArray();
		System.out.println(arr);
		System.out.println("=============");
		getPermutations2(arr, 0, arr.length-1);*/
	}

	static void getPermutations2(char[] arr, int start, int end){
		if(start==end){
			System.out.println(arr);
		} else{
			for(int i=start;i<=end;i++){
				swap(arr, i, start);
				getPermutations2(arr, start+1, end);
				swap(arr, i, start);
			}
		}

	}

	static void swap(char[] arr, int i, int j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
