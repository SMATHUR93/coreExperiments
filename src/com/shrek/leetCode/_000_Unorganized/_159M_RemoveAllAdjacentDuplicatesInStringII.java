package com.shrek.leetCode._000_Unorganized;

import java.util.*;
// import javafx.util.Pair;

/**
 *
 * You are given a string s and an integer k,
 * a k duplicate removal consists of choosing k adjacent
 * and equal letters from s and removing them,
 * causing the left and the right side of the deleted substring to concatenate together.
 * We repeatedly make k duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made.
 * It is guaranteed that the answer is unique.
 *
 * Example 1:
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 *
 * Example 2:
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 *
 * Example 3:
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 *
 * Constraints:
 * 1 <= s.length <= 105
 * 2 <= k <= 104
 * s only contains lowercase English letters.
 *
 * Hint 1
 * Use a stack to store the characters, when there are k same characters, delete them.
 *
 * Hint 2
 * To make it more efficient, use a pair to store the value and the count of each character.
 *
 */

public class _159M_RemoveAllAdjacentDuplicatesInStringII {

    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;
        System.out.println("removeDuplicates for string s = " + s + " , k = " + k + " , = "+ removeDuplicates(s, k) );
        // "abcd"
        System.out.println("-------------- BREAK -----------------");
        s = "deeedbbcccbdaa";
        k = 3;
        System.out.println("removeDuplicates for string s = " + s + " , k = " + k + " , = "+ removeDuplicates(s, k) );
        // "aa"
        System.out.println("-------------- BREAK -----------------");
        s = "pbbcggttciiippooaais";
        k = 2;
        System.out.println("removeDuplicates for string s = " + s + " , k = " + k + " , = "+ removeDuplicates(s, k) );
        // "ps"
    }

    public static class Pair {
        int cnt;
        char ch;
        public Pair(int cnt, char ch) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Pair> counts = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (counts.empty() || s.charAt(i) != counts.peek().ch) {
                counts.push(new Pair(1, s.charAt(i)));
            } else {
                if (++counts.peek().cnt == k) {
                    counts.pop();
                }
            }
        }
        StringBuilder b = new StringBuilder();
        while (!counts.empty()) {
            Pair p = counts.pop();
            for (int i = 0; i < p.cnt; i++) {
                b.append(p.ch);
            }
        }
        return b.reverse().toString();
    }

    // Can't use the Pair class since its  deprecated
    /* public static String removeDuplicates(String s, int k) {
        int n= s.length();
        Deque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!stack.isEmpty()){
                if(stack.peek().getKey()==s.charAt(i) && stack.peek().getValue()==k-1){
                    stack.pop();
                } else if(stack.peek().getKey()==s.charAt(i) && stack.peek().getValue()<k){
                    int count = stack.peek().getValue();
                    stack.pop();
                    stack.push(new Pair(s.charAt(i), count+1));
                } else {
                    stack.push(new Pair(s.charAt(i), 1));
                }
            } else {
                stack.push(new Pair(s.charAt(i), 1));
            }
        }
        StringBuilder op = new StringBuilder();
        while(!stack.isEmpty()){
            Pair<Character, Integer> pair = stack.pop();
            int c = pair.getValue();
            for (int i = 0; i < c; i++) {
                op.append(pair.getKey());
            }
        }
        return op.reverse().toString();
    } */
}
