package com.shrek.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FindLeastCOmmonSubstring {

	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			int indexOfComma = line.indexOf(", ");
			String str1 =  line.substring(0, indexOfComma);
			String str2 = line.substring(indexOfComma+2, line.length());
			String longStr, smallStr;
			if(str1.length()>=str2.length()) {
				longStr = str1;
				smallStr = str2;
			} else {
				longStr = str2;
				smallStr = str1;
			}
			char[] longca = longStr.toCharArray();
			char[] smallca = smallStr.toCharArray();
			//System.out.println(longca);
			//System.out.println(smallca);
			//System.out.println("--------");
			int longestSuffixLength = 0;
			String longestSuffix = "";
			for(int i=0;i<longca.length;i++) {
				int currentSuffixLength = 0;
				for(int j=longca.length;j>i;j--) {
					String currentSuffix = longStr.substring(i, j);
					currentSuffixLength = currentSuffix.length();
					if(currentSuffixLength>1) {
						boolean isCurrentSuffixInSecondString = (smallStr.indexOf(currentSuffix)!=-1)?(true):(false);
						if(isCurrentSuffixInSecondString==true) {
							if(currentSuffixLength>longestSuffixLength) {
								longestSuffixLength = currentSuffixLength;
								longestSuffix = currentSuffix;
							}
							//System.out.println(currentSuffix + " - " + currentSuffixLength + " - "+ isCurrentSuffixInSecondString + " - " + longestSuffix);
						}
					}
				}
				//System.out.println("---");
			}
			if(longestSuffix.equals("")) {
				longestSuffix = "NULL";
			}
			System.out.println(longestSuffix);
		}
	}
}