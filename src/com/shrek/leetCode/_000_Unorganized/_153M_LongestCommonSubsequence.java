package com.shrek.leetCode._000_Unorganized;

/**
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 *
 * Hint 1
 * Try dynamic programming. DP[i][j] represents the longest common subsequence of text1[0 ... i] & text2[0 ... j].
 *
 * Hint 2
 * DP[i][j] = DP[i - 1][j - 1] + 1 , if text1[i] == text2[j] DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]) , otherwise
 *
 */

public class _153M_LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1, text2;

        text1 = "abcde"; text2 = "ace";
        System.out.println("longestCommonSubsequence for text1 = "+ text1 +" , text2 = "+text2+" , equals "+longestCommonSubsequence(text1, text2));
        // 3
        System.out.println();

        text1 = "abc"; text2 = "abc";
        System.out.println("longestCommonSubsequence for text1 = "+ text1 +" , text2 = "+text2+" , equals "+longestCommonSubsequence(text1, text2));
        // 3
        System.out.println();

        text1 = "abc"; text2 = "def";
        System.out.println("longestCommonSubsequence for text1 = "+ text1 +" , text2 = "+text2+" , equals "+longestCommonSubsequence(text1, text2));
        // 0
        System.out.println();
    }

    // Optimal DP tabulation
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j] = 0;
            }
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int op = dp[m][n];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                System.out.print(" " + dp[i][j]);
            }
            System.out.println();
        }
        return op;
    }

    // Recursion with Memoization
    /*public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        int op = rec(text1, text2, dp, text1.length()-1, text2.length()-1);
        *//*for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.println("Checking, i = "+i+" , j = "+j+" , dp[i][j] = " + dp[i][j]);
            }
        }*//*
        return op;
    }
    public static int rec(String text1, String text2, int[][] dp, int i, int j){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(text1.charAt(i)==text2.charAt(j)){
            // System.out.println("Checking, text1.charAt(i)==text2.charAt(j) by text1.charAt(i) = " + text1.charAt(i) + " , text2.charAt(j) = " + text2.charAt(j));
            return dp[i][j] = 1 + rec(text1, text2, dp, i-1, j-1);
        }
        return dp[i][j] = Math.max(rec(text1, text2, dp, i-1, j), rec(text1, text2, dp, i, j-1));
    }*/

    // Pure Recusrion
    /*public static int longestCommonSubsequence(String text1, String text2) {
        return rec(text1, text2, text1.length()-1, text2.length()-1);
    }
    public static int rec(String text1, String text2, int i, int j){
        if(i<0 || j<0){
            return 0;
        }
        if(text1.charAt(i)==text2.charAt(j)){
            return 1 + rec(text1, text2, i-1, j-1);
        }
        return Math.max(rec(text1, text2, i-1, j), rec(text1, text2, i, j-1));
    }*/

}
