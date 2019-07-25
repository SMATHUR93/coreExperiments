package com.shrek.puzzles;

import java.util.HashMap;
import java.util.Map;

public class ChangesNeededForAnagram {

	public static void main(String[] args) {
		String str1 = "shrey";
		String str2 = "syreh";
		int charsToModify = -1;
		if(str1.length() == str2.length()) {
			charsToModify = 0;
			Map<Character, Integer> str1OccurMap = new HashMap<Character, Integer>();
			char[] str1CharArray = str1.toCharArray();
			char[] str2CharArray = str2.toCharArray();
			//Set<Character> str1KeySet = str1OccurMap.keySet();
			for(int i=0;i<str1CharArray.length;i++) {
				Character c = (Character)str1CharArray[i];
				if(str1OccurMap.containsKey(c)) {
					str1OccurMap.put(c, str1OccurMap.get(c)+1);
				} else {
					str1OccurMap.put(c, 1);
				}
			}
			for(int i=0;i<str2CharArray.length;i++) {
				Character c = (Character)str2CharArray[i];
				if(!str1OccurMap.containsKey(c)) {
					charsToModify++;
				}
			}
		}
		System.out.println(charsToModify);
	}
	
}
