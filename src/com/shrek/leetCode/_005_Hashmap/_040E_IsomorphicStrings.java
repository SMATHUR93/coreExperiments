package com.shrek.leetCode._005_Hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 *
 * Output: true
 *
 * Explanation:
 *
 * The strings s and t can be made identical by:
 *
 * Mapping 'e' to 'a'.
 * Mapping 'g' to 'd'.
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 *
 * Output: false
 *
 * Explanation:
 *
 * The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.
 *
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 *
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 *
 */

public class _040E_IsomorphicStrings {

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println("isIsomorphic for s = " + s + " and t = " + t + " is " + isIsomorphic(s, t));
        // true
        System.out.println("-------------- BREAK -----------------");
        s = "foo";
        t = "bar";
        System.out.println("isIsomorphic for s = " + s + " and t = " + t + " is " + isIsomorphic(s, t));
        // false
        System.out.println("-------------- BREAK -----------------");
        s = "paper";
        t = "title";
        System.out.println("isIsomorphic for s = " + s + " and t = " + t + " is " + isIsomorphic(s, t));
        // true
        System.out.println("-------------- BREAK -----------------");
        s = "badc";
        t = "baba";
        System.out.println("isIsomorphic for s = " + s + " and t = " + t + " is " + isIsomorphic(s, t));
        // false
        System.out.println("-------------- BREAK -----------------");
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int n = s.length();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Map<Character, Character> sTotmap = new HashMap<Character, Character>();
        Map<Character, Character> tTosmap = new HashMap<Character, Character>();
        for(int i=0;i<n;i++){
            if(sTotmap.get(sArr[i])!=null && sTotmap.get(sArr[i])!=tArr[i]){
                return false;
            }
            sTotmap.put(sArr[i], tArr[i]);
            if(tTosmap.get(tArr[i])!=null && tTosmap.get(tArr[i])!=sArr[i]){
                return false;
            }
            tTosmap.put(tArr[i], sArr[i]);
        }
        // System.out.println(map);
        return true;
    }

}
