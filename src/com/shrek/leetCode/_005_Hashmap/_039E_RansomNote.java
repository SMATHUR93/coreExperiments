package com.shrek.leetCode._005_Hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 *
 */

public class _039E_RansomNote {

    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println("canConstruct for ransomNote = " + ransomNote + " and magazine = " + magazine + " is " + canConstruct(ransomNote, magazine));
        // false
        System.out.println("-------------- BREAK -----------------");
        ransomNote = "aa";
        magazine = "ab";
        System.out.println("canConstruct for ransomNote = " + ransomNote + " and magazine = " + magazine + " is " + canConstruct(ransomNote, magazine));
        // false
        System.out.println("-------------- BREAK -----------------");
        ransomNote = "aa";
        magazine = "aab";
        System.out.println("canConstruct for ransomNote = " + ransomNote + " and magazine = " + magazine + " is " + canConstruct(ransomNote, magazine));
        // true
        System.out.println("-------------- BREAK -----------------");
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 0;
        for(char c: magazine.toCharArray()){
            count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        for(char c: ransomNote.toCharArray()){
            // System.out.println(c + " || " + map);
            if(map.get(c)==null || map.get(c)==0){
                return false;
            } else {
                count = map.get(c).intValue();
                map.put(c, count - 1);
            }
        }
        return true;
    }

}
