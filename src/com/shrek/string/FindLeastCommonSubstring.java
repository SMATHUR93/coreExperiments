package com.shrek.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FindLeastCommonSubstring {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String str1 =  "shredder";//scanner.next();
		String str2 = "ashrek";//scanner.next();
		//System.out.println(getLCSBRuteForce(str1, str2));
		System.out.println(getLCSByDP(str1, str2));
		scanner.close();
//		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//		BufferedReader in = new BufferedReader(reader);
//		String line;
//		while ((line = in.readLine()) != null) {
//			int indexOfComma = line.indexOf(", ");
//			String str1 =  line.substring(0, indexOfComma);
//			String str2 = line.substring(indexOfComma+2, line.length());
//		}
	}
	
	static String getLCSByDP(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] LCSMatrix = new int[m+1][n+1];
		int len = 0;
		int row = 0, col = 0;
		for(int i = 0; i <= m ; i++) {
			for(int j = 0 ; j <= n ; j++) {
				if(i == 0 || j == 0) {
					LCSMatrix[i][j] = 0;
				} else {
					if(str1.charAt(i-1) == str2.charAt(j-1)) {
						LCSMatrix[i][j] = LCSMatrix[i-1][j-1]+1;
						if(len < LCSMatrix[i][j]) {
							len = LCSMatrix[i][j];
							row = i;
							col = j;
						}
					} else {
						LCSMatrix[i][j] = 0;
					}
				}
			}
		}
		if(len == 0) {
			System.out.println("No common substring");
			return null;
		}
		System.out.print("    ");
		for(int j = 0 ; j < n ; j++) {
			System.out.print(str2.charAt(j) + " ");
		}
		System.out.println();
		for(int i = 0; i < m+1 ; i++) {
			if(i!=0) {
				System.out.print(str1.charAt(i-1) + " ");
			} else {
				System.out.print("  ");
			}
			for(int j = 0 ; j < n+1 ; j++) {
				System.out.print(LCSMatrix[i][j] + " ");
			}
			System.out.println();
		}
		String resultStr = new String();
		while(LCSMatrix[row][col] != 0) {
			resultStr = str1.charAt(row-1) + resultStr;
			//resultStr = str2.charAt(col-1) + resultStr;
			len--;
			row--;
			col--;
		}
		return resultStr;
	}

	static String getLCSBRuteForce(String str1, String str2) {
		String longStr, smallStr;
		if(str1.length()>=str2.length()) {
			longStr = str1;
			smallStr = str2;
		} else {
			longStr = str2;
			smallStr = str1;
		}
		char[] longca = longStr.toCharArray();
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
					}
				}
			}
		}
		if(longestSuffix.equals("")) {
			longestSuffix = "NULL";
		}
		return longestSuffix;
	}
}