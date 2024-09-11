package com.shrek.leetCode._005_Hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given two strings s and t, return true if t is an
 * anagram
 *  of s, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 *
 */

public class _042E_ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("isAnagram for s = " + s + " and t = " + t + " is " + isAnagram(s, t));
        // true
        System.out.println("-------------- BREAK -----------------");
        s = "rat";
        t = "car";
        System.out.println("isAnagram for s = " + s + " and t = " + t + " is " + isAnagram(s, t));
        // false
        System.out.println("-------------- BREAK -----------------");
        s = "paper";
        t = "title";
        System.out.println("isAnagram for s = " + s + " and t = " + t + " is " + isAnagram(s, t));
        // true
        System.out.println("-------------- BREAK -----------------");
        s = "badc";
        t = "baba";
        System.out.println("isAnagram for s = " + s + " and t = " + t + " is " + isAnagram(s, t));
        // false
        System.out.println("-------------- BREAK -----------------");
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int n = s.length();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        for(int i=0;i<n;i++){
            sMap.put(sArr[i], sMap.getOrDefault(sArr[i], 0) + 1);
            sMap.put(tArr[i], sMap.getOrDefault(tArr[i], 0) - 1);
        }
        // System.out.println("sMap = "+sMap);
        for(char c:sMap.keySet()){
            if(sMap.get(c)!=0){
                return false;
            }
        }
        return true;
    }

}
