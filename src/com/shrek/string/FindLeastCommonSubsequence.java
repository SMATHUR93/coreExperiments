package com.shrek.string;

import java.io.IOException;
import java.util.Scanner;

public class FindLeastCommonSubsequence {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String str1 = "abcde";//"shredder";//scanner.next();
		String str2 = "daebc";//"ashrek";//scanner.next();
		System.out.println(getLCSByDP(str1, str2));
		scanner.close();
	}
	
	static String getLCSByDP(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] LCSMatrix = new int[m+1][n+1];
		for(int i = 0; i <= m ; i++) {
			for(int j = 0 ; j <= n ; j++) {
				if(i == 0 || j == 0) {
					LCSMatrix[i][j] = 0;
				} else {
					if(str1.charAt(i-1) == str2.charAt(j-1)) {
						LCSMatrix[i][j] = LCSMatrix[i-1][j-1]+1;
					} else {
						LCSMatrix[i][j] = Math.max(LCSMatrix[i-1][j], LCSMatrix[i][j-1]);
					}
				}
			}
		}
		// PRINT LEAST COMMON SEQUENCE MATRIX
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
		
		int charIndex = LCSMatrix[m][n];
		int temp = charIndex;
		char[] lcs = new char[charIndex+1];
		lcs[charIndex] = ' ';
		int i = m, j = n;
		while(i > 0 && j > 0) {
			if(str1.charAt(i-1) == str2.charAt(j-1)) {
				lcs[charIndex-1] = str1.charAt(i-1);
				i--;
				j--;
				charIndex--;
			} else {
				if(LCSMatrix[i-1][j] > LCSMatrix[i][j-1]) {
					i--;
				} else {
					j--;
				}
			}
		}
		String resultStr = new String();
		for(int k=0;k<=temp;k++) {
			resultStr += lcs[k];
		}
		return resultStr;
	}
	
}
