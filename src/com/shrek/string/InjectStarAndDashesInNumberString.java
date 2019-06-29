package com.shrek.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InjectStarAndDashesInNumberString {
	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			char[] numCharLine = line.toCharArray();
			StringBuffer output = new StringBuffer();
			//char[] op;
			for(int i=0;i<numCharLine.length-1;i++) {
				int num = Character.getNumericValue(numCharLine[i]);
				int nextNum = Character.getNumericValue(numCharLine[i+1]);
				//System.out.println(num + " - " + nextNum);
				output.append(numCharLine[i]);
				if(num!=0&&nextNum!=0) {
					//System.out.println("In non zero");
					if(num%2==0&&nextNum%2==0) {
						//System.out.println("Append star");
						output.append("*");
					}
					if(num%2!=0&&nextNum%2!=0) {
						//System.out.println("Append dash");
						output.append("-");
					}
				}
				//System.out.println(num);
			}
			output.append(numCharLine[numCharLine.length-1]);
			//System.out.println(line);
			System.out.println(output);
		}
	}
}
