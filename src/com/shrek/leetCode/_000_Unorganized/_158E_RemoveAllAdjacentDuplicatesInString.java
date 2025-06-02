package com.shrek.leetCode._000_Unorganized;
import java.util.*;

import java.util.Arrays;

/**
 *
 * You are given a string s consisting of lowercase English letters.
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * We repeatedly make duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made.
 * It can be proven that the answer is unique.
 *
 * Example 1:
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 *
 * Example 2:
 * Input: s = "azxxzy"
 * Output: "ay"
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 *
 * Hint 1
 * Use a stack to process everything greedily.
 *
 */

public class _158E_RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println("removeDuplicates for string s = " + s + " , = "+ removeDuplicates(s) );
        // "ca"
        System.out.println("-------------- BREAK -----------------");
        s = "azxxzy";
        System.out.println("removeDuplicates for string s = " + s + " , = "+ removeDuplicates(s) );
        // ay
    }

    public static String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(!stack.isEmpty() && stack.peek()==s.charAt(i)){
                stack.pop();
            } else{
                stack.push(s.charAt(i));
            }
        }
        int len = stack.size();
        char[] arr = new char[len];
        int i=len-1;
        while(!stack.isEmpty()){
            arr[i] = stack.pop();
            i--;
        }
        return new String(arr);
    }

}
