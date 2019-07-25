package com.shrek.string;

import java.util.Scanner;
import java.util.Stack;

public class ReverseWordsInSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String delimiter = "\\.";
		String Sentence = input.next();
		String output = reverseWordsInSentence(Sentence, delimiter);
		System.out.println(output);
		input.close();
	}

	private static String reverseWordsInSentence(String sentence, String delimiter) {
		// TODO Auto-generated method stub
		String out = new String();
		Stack<String> stack = new Stack<String>();
		String[] stringsArray = sentence.split(delimiter);
		for(int i=0;i<stringsArray.length;i++) {
			stack.push(stringsArray[i]);
		}
		while(!stack.isEmpty()) {
			out += stack.pop();
		}
		return out;
	}

}
