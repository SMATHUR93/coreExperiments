package com.shrek.string;

import java.util.Scanner;

public class MakeACommaSeperatedNameString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuffer output = new StringBuffer();
		String temp = "";
		while(input.hasNextLine()) {
			temp = input.nextLine();
			if(temp.equals("exit")) {
		        break;
		    }
			output.append("\"");
			output.append(temp);
			output.append("\"");
			output.append(",");
		}
		System.out.println("=========================");
		System.out.println(output);
	}

}
