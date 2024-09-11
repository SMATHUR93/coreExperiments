package com.shrek.leetCode._002_TwoPointers;

/**
 * Given two strings s and t,
 * return true if s is a subsequence of t,
 * or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string
 * by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 *
 *
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */

public class _026E_IsSubsequence {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println("isSubsequence for s = " + s + " , t = " + t + " , = "+ isSubsequence(s, t));
        // true
        System.out.println("-------------- BREAK -----------------");
        s = "axc";
        t = "ahbgdc";
        System.out.println("isSubsequence for s = " + s + " , t = " + t + " , = "+ isSubsequence(s, t));
        // false
        System.out.println("-------------- BREAK -----------------");
        s = "ace";
        t = "abcde";
        System.out.println("isSubsequence for s = " + s + " , t = " + t + " , = "+ isSubsequence(s, t));
        // false
        System.out.println("-------------- BREAK -----------------");
        s = "aec";
        t = "abcde";
        System.out.println("isSubsequence for s = " + s + " , t = " + t + " , = "+ isSubsequence(s, t));
        // false
        System.out.println("-------------- BREAK -----------------");
    }

    public static boolean isSubsequence(String s, String t) {
        s = s.trim();
        t = t.trim();
        if(s.equals("")==true){
            return true;
        }
        if(t.equals("")==true){
            return false;
        }
        int m = s.length();
        int n = t.length();
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int i=0;
        for(int j=0;j<n;j++){
            if(sarr[i]==tarr[j]){
                System.out.println("Debuging in loop , sarr[i] = "+sarr[i]+", tarr[j] = "+tarr[j]);
                i++;
            }
            if(i==m){
                return true;
            }
        }
        return false;
    }

}
