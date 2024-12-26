package com.shrek.leetCode._021_MultidimensionalDP;

/***
 *
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 *
 * Constraints:
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 *
 */

public class _147M_EditDistance {

    public static void main(String[] args) {
        String word1;
        String word2;

        word1 = "horse"; word2 = "ros";
        System.out.println("minDistance for string word1 = "+ word1 +" , word2 = "+ word2 +" , equals "+minDistance(word1, word2));
        // 3
        System.out.println();

        word1 = "intention"; word2 = "execution";
        System.out.println("minDistance for string word1 = "+ word1 +" , word2 = "+ word2 +" , equals "+minDistance(word1, word2));
        // 5
        System.out.println();

    }

    // Recursion with memoization
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int [][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return rec(word1, word2, m-1, n-1, dp);
    }

    static int rec(String s1, String s2, int i, int j, int[][] dp){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = 0 + rec(s1, s2, i-1, j-1, dp);
        } else{
            return dp[i][j] = 1 + Math.min(
                    rec(s1, s2, i-1, j-1, dp),
                    Math.min(
                            rec(s1, s2, i-1, j, dp),
                            rec(s1, s2, i, j-1, dp)
                    )
            );
        }
    }

    // Basic recursive solution
    /*public int minDistance(String word1, String word2) {
        return rec(word1, word2, word1.length()-1, word2.length()-1);
    }
    int rec(String s1, String s2, int i, int j){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return 0 + rec(s1, s2, i-1, j-1);
        } else{
            return 1 + Math.min(
                    rec(s1, s2, i-1, j-1), // case for replace
                    Math.min(
                            rec(s1, s2, i-1, j),  // case of delete
                            rec(s1, s2, i, j-1)  // case of insert
                    )
            );
        }
    }*/

}
