package com.shrek.leetCode._005_Hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:
 *
 * Each letter in pattern maps to exactly one unique word in s.
 * Each unique word in s maps to exactly one letter in pattern.
 * No two letters map to the same word, and no two words map to the same letter.
 *
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 *
 * Output: true
 *
 * Explanation:
 *
 * The bijection can be established as:
 *
 * 'a' maps to "dog".
 * 'b' maps to "cat".
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 *
 * Output: false
 *
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lowercase English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 *
 */

public class _041E_WordPattern {

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println("wordPattern for pattern = " + pattern + " and s = " + s + " is " + wordPattern(pattern, s));
        // true
        System.out.println("-------------- BREAK -----------------");
        pattern = "abba";
        s = "dog cat cat fish";
        System.out.println("wordPattern for pattern = " + pattern + " and s = " + s + " is " + wordPattern(pattern, s));
        // false
        System.out.println("-------------- BREAK -----------------");
        pattern = "aaaa";
        s = "dog cat cat dog";
        System.out.println("wordPattern for pattern = " + pattern + " and s = " + s + " is " + wordPattern(pattern, s));
        // false
        System.out.println("-------------- BREAK -----------------");
        pattern = "abba";
        s = "dog dog dog dog";
        System.out.println("wordPattern for pattern = " + pattern + " and s = " + s + " is " + wordPattern(pattern, s));
        // false
        System.out.println("-------------- BREAK -----------------");
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] arr = s.split("\\s+");
        if(pattern.length()!=arr.length){
            return false;
        }
        int n = arr.length;
        char[] pArr = pattern.toCharArray();
        Map<Character, String> pToSmap = new HashMap<Character, String>();
        Map<String, Character> sToPmap = new HashMap<String, Character>();
        for(int i=0;i<n;i++){
            if(pToSmap.get(pArr[i])!=null && pToSmap.get(pArr[i]).equals(arr[i])==false){
                return false;
            }
            pToSmap.put(pArr[i], arr[i]);
            if(sToPmap.get(arr[i])!=null && sToPmap.get(arr[i])!=pArr[i]){
                return false;
            }
            sToPmap.put(arr[i], pArr[i]);
        }
        return true;
    }

}
