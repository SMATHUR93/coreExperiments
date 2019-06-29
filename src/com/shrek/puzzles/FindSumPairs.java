package com.shrek.puzzles;

import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 4, 4, 5, 7, 9, -1, -1, 9};
		int sum = 8;
		int sumPairs = 0;
		Map<Integer, Integer> occurMap = new HashMap<Integer, Integer>();
		for(int i=0;i<input.length;i++) {
			Integer num = (Integer)input[i];
			if(occurMap.containsKey(num)) {
				occurMap.put(num, occurMap.get(num)+1);
			} else {
				occurMap.put(num, 1);
			}
		}
		for(int i=0;i<input.length;i++) {
			//Integer num = (Integer)input[i];
			int diff = sum - input[i];
			//System.out.println(input[i]+"==="+diff+"==="+occurMap);
			if(occurMap.containsKey(diff)) {
				if(diff==input[i] && occurMap.get(input[i])>1 ) {
					sumPairs++;
					if(occurMap.get(input[i])!=null && occurMap.get(input[i])>1) {
						occurMap.put(input[i], occurMap.get(input[i])-1);
					} else {
						occurMap.remove(input[i]);
					}
					if(occurMap.get(diff)!=null && occurMap.get(diff)>1) {
						occurMap.put(diff, occurMap.get(diff)-1);
					} else {
						occurMap.remove(diff);
					}
				}
				if(diff!=input[i]) {
					sumPairs++;
					if(occurMap.get(input[i])!=null && occurMap.get(input[i])>1) {
						occurMap.put(input[i], occurMap.get(input[i])-1);
					} else {
						occurMap.remove(input[i]);
					}
					if(occurMap.get(diff)!=null && occurMap.get(diff)>1) {
						occurMap.put(diff, occurMap.get(diff)-1);
					} else {
						occurMap.remove(diff);
					}
				}
			}
		}
		System.out.println(sumPairs);
	}
	
}
