package com.shrek.experiments;

public class Main2 {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 22, 25, 6, -1, 8, 10 };
		int[] sub = { 8 };
		int n = arr.length;
		int m = sub.length;
		System.out.println(n + " :: " + m);
		int seq = 0;
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (!(j >= m) && (arr[i] == sub[j])) {
				System.out.println("In catch block");
				seq++;
				j++;
			}
		}
		if (seq == m - 1) {
			System.out.println("sub i apart of main");
		}
	}

}
