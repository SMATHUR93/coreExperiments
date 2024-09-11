package com.shrek.leetCode._003_SlidingWindow;

import java.util.*;

/**
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 *
 *
 * Hint 1
 * Use two pointers to create a window of letters in s, which would have all the characters from t.
 * Hint 2
 * Expand the right pointer until all the characters of t are covered.
 * Hint 3
 * Once all the characters are covered, move the left pointer and ensure that all the characters are still covered to minimize the subarray size.
 * Hint 4
 * Continue expanding the right and left pointers until you reach the end of s.
 *
 */

public class _033H_MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("minWindow for string s = " + s + " , and t = "+t+" == " + minWindow(s, t) );
        // "BANC"
        System.out.println("-------------- BREAK -----------------");
        s = "a";
        t = "a";
        System.out.println("minWindow for string s = " + s + " , and t = "+t+" == " + minWindow(s, t) );
        // "a"
        System.out.println("-------------- BREAK -----------------");
        s = "a";
        t = "aa";
        System.out.println("minWindow for string s = " + s + " , and t = "+t+" == " + minWindow(s, t) );
        // ""
        System.out.println("-------------- BREAK -----------------");
    }

    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n == 0 || m == 0){
            return "";
        }
        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < m; i++) {
            int count = map.getOrDefault(tArr[i], 0);
            map.put(tArr[i], count + 1);
        }
        int stringEls = map.size();
        int windowEls = 0;
        int l = 0;
        int r = 0;
        int len = 0;
        int strIndx = 0;
        int endIndx = 0;
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> temp = new HashMap<Character, Integer>();
        char c;
        while(r<n){
            c = sArr[r];
            int count = temp.getOrDefault(c, 0);
            temp.put(c, count + 1 );
            if(map.containsKey(c) && temp.get(c).intValue()==map.get(c).intValue()){
                windowEls++;
            }
            while(l<=r && windowEls==stringEls){
                c = sArr[l];
                len = r - l + 1;
                if(len<minLen){
                    minLen = len;
                    strIndx = l;
                    endIndx = r;
                }
                temp.put(c, temp.get(c) - 1);
                if(map.containsKey(c) &&
                        temp.get(c).intValue() < map.get(c).intValue()){
                    windowEls--;
                }
                l++;
            }
            r++;
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(strIndx, endIndx + 1);
    }

}
