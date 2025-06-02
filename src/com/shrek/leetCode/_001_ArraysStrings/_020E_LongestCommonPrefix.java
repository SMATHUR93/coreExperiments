package com.shrek.leetCode._001_ArraysStrings;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */

public class _020E_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        System.out.println(Arrays.toString(s));
        System.out.println("longestCommonPrefix for "+ Arrays.toString(s)+" = "+longestCommonPrefix(s));
        System.out.println("-------------- BREAK -----------------");
        s = new String[]{"dog","racecar","car"};
        System.out.println("longestCommonPrefix for "+ Arrays.toString(s) +" = "+longestCommonPrefix(s));
        System.out.println("-------------- BREAK -----------------");
        s = new String[]{"a"};
        System.out.println("longestCommonPrefix for "+ Arrays.toString(s) +" = "+longestCommonPrefix(s));
        System.out.println("-------------- BREAK -----------------");
        s = new String[]{"ab", "a"};
        System.out.println("longestCommonPrefix for "+ Arrays.toString(s) +" = "+longestCommonPrefix(s));
        System.out.println("-------------- BREAK -----------------");
    }

    public static String longestCommonPrefix(String[] arr) {
        int n = arr.length;

        if(n==0){
            return "";
        }

        if(n==1){
            return arr[0];
        }

        String minEl = arr[0];
        for(int i=0;i<n;i++){
            if(minEl.length() > arr[i].length()){
                minEl = arr[i];
            }
        }

        StringBuffer sb  = new StringBuffer();

        int minLen = minEl.length();
        int total = minLen * n;
        int j = 1;
        int k = 0;
        // System.out.println("Debugging 1 , minEl = " + minEl + " , minLen = " + minLen + " , total = " + total);
        for(int i = 0;i < total;i++){
            System.out.println("Debugging 2 , i = " + i);
            if(k == minLen){
                break;
            } else if(!(arr[j-1].charAt(k) == arr[j].charAt(k))){
                break;
            } else if(j==n-1){
                sb.append( String.valueOf( arr[j].charAt(k) ) );
                // System.out.println("Debugging 3 , appending s with arr[j].charAt(k) = "+ arr[j].charAt(k));
                j=1;
                k++;
            } else{
                j++;
            }
        }
        // System.out.println("Debugging 4 , sb = " + sb);
        return sb.toString();
    }

}
