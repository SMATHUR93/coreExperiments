package com.shrek.leetCode._003_SlidingWindow;

import java.util.*;

/**
 *
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 *
 * Hint 1
 * Generate all possible substrings & check for each substring if it's valid and keep updating maxLen accordingly.
 *
 */

public class _031M_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("lengthOfLongestSubstring for string s = " + s + " == " + lengthOfLongestSubstring(s) );
        // 3
        System.out.println("-------------- BREAK -----------------");
        s = "bbbbb";
        System.out.println("lengthOfLongestSubstring for string s = " + s + " == " +  + lengthOfLongestSubstring(s) );
        // 1
        System.out.println("-------------- BREAK -----------------");
        s = "pwwkew";
        System.out.println("lengthOfLongestSubstring for string s = " + s + " == " +  + lengthOfLongestSubstring(s) );
        // 3
        System.out.println("-------------- BREAK -----------------");
        s = "dvdf";
        System.out.println("lengthOfLongestSubstring for string s = " + s + " == " +  + lengthOfLongestSubstring(s) );
        // 3
        System.out.println("-------------- BREAK -----------------");
        s = "abcabcdaebb";
        System.out.println("lengthOfLongestSubstring for string s = " + s + " == " +  + lengthOfLongestSubstring(s) );
        // 3
        System.out.println("-------------- BREAK -----------------");
        s = " ";
        System.out.println("lengthOfLongestSubstring for string s = " + s + " == " +  + lengthOfLongestSubstring(s) );
        // 1
        System.out.println("-------------- BREAK -----------------");
        s = "c";
        System.out.println("lengthOfLongestSubstring for string s = " + s + " == " +  + lengthOfLongestSubstring(s) );
        // 1
        System.out.println("-------------- BREAK -----------------");
        s = "au";
        System.out.println("lengthOfLongestSubstring for string s = " + s + " == " +  + lengthOfLongestSubstring(s) );
        // 2
        System.out.println("-------------- BREAK -----------------");
    }

    // Approach 1 : Using set and exhaustion of elements by using nested loops for adjusting length of sliding window
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> cs = new HashSet<>();

        int l = 0;
        int r = 0;
        int len = 0;
        int maxLen = 0;

        for(r=0;r<n;r++){
            while(cs.contains(s.charAt(r))){
                cs.remove(s.charAt(l));
                l++;
            }
            cs.add(s.charAt(r));
            len = r - l + 1;
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }

    // Approach 2 : Using Map object to keep count of occurrence and updating sliding window pointes
    /*public static int lengthOfLongestSubstring(String s) {
        if(s.equals("")){
            return 0;
        }
        if(s.length()<=1){
            return 1;
        }
        char[] arr = s.toCharArray();
        int n = arr.length;
        Map<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int len = 0;
        int maxLen = Integer.MIN_VALUE;

        while(r < n){
            if(map.containsKey(arr[r]) && map.get(arr[r])>=l){
                l = map.get(arr[r]) + 1;
            }
            len = r - l + 1;
            maxLen = Math.max(len, maxLen);
            map.put(arr[r], r);
            System.out.println("Debugging IN,  l = "+l+" , arr[l] = "+arr[l]+" , r = "+r+" , arr[r] = "+arr[r]+" , map = "+map+" , len = "+len+" , maxLen = "+maxLen);
            r++;
        }
        return maxLen;
    }*/

}
