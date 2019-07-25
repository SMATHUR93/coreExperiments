package com.shrek.puzzles;

import java.util.Arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {
		int[] arr1 = {0, 1, 3, 4, 7, 9};
		int[] arr2 = {2, 6, 8, 10};
		System.out.println(Arrays.toString(mergeArr( arr1, arr2)));
	}
	
	static int[] mergeArr(int[] arr1, int[] arr2) {
		int m = arr1.length;
		int n = arr2.length;
		int[] out = new int[n+m];
		int startm = 0;
		int startn = 0;
		for(int i=0;i<(n+m);i++) {
			if((startm==m || startn==n)) {
				if(startm==m) {
					out[i] = arr2[startn];
					startn++;
				} else {
					out[i] = arr1[startm];
					startm++;
				}
			} else{
				if(arr1[startm]<arr2[startn]) {
					out[i] = arr1[startm];
					startm++;
				} else {
					out[i] = arr2[startn];
					startn++;
				}
			}
		}
		return out;
	}
	
}
