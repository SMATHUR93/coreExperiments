package com.shrek.leetCode._001_ArraysStrings;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */

public class _023E_FindIndexOfFirstOccurrenceInString {

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println("convert for haystack = "+haystack+" , and needle = "+needle+" = "+strStr(haystack, needle));
        // 0
        System.out.println("-------------- BREAK -----------------");
        haystack = "leetcode";
        needle = "leeto";
        System.out.println("convert for haystack = "+haystack+" , and needle = "+needle+" = "+strStr(haystack, needle));
        // -1
        System.out.println("-------------- BREAK -----------------");
        haystack = "leetcode";
        needle = "leeto";
        System.out.println("convert for haystack = "+haystack+" , and needle = "+needle+" = "+strStr(haystack, needle));
        // -1
        System.out.println("-------------- BREAK -----------------");
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

}
