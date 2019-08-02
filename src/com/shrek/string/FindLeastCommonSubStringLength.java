package com.shrek.string;

import java.io.IOException;
import java.util.Scanner;

public class FindLeastCommonSubStringLength {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String str1 =  "shredder";//scanner.next();
		String str2 = "ashrek";//scanner.next();
		System.out.println(getLCSLengthByDP(str1, str2));
		scanner.close();
	}
	
	static int getLCSLengthByDP(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] LCSMatrix = new int[m+1][n+1];
		int len = 0;
		for(int i = 0; i <= m ; i++) {
			for(int j = 0 ; j <= n ; j++) {
				if(i == 0 || j == 0) {
					LCSMatrix[i][j] = 0;
				} else {
					if(str1.charAt(i-1) == str2.charAt(j-1)) {
						LCSMatrix[i][j] = LCSMatrix[i-1][j-1]+1;
						if(len < LCSMatrix[i][j]) {
							len = LCSMatrix[i][j];
						}
					} else {
						LCSMatrix[i][j] = 0;
					}
				}
			}
		}
		if(len == 0) {
			System.out.println("No common substring");
			return 0;
		}
//		System.out.print("  ");
//		for(int j = 0 ; j < n ; j++) {
//			System.out.print(str2.charAt(j) + " ");
//		}
//		System.out.println();
		for(int i = 0; i < m+1 ; i++) {
			//System.out.print(str1.charAt(i) + " ");
			for(int j = 0 ; j < n+1 ; j++) {
				System.out.print(LCSMatrix[i][j] + " ");
			}
			System.out.println();
		}
		return len;
	}

}
