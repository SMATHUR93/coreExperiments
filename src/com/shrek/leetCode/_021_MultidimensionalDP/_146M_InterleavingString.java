package com.shrek.leetCode._021_MultidimensionalDP;

/**
 *
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * An interleaving of two strings s and t is a configuration
 * where s and t are divided into n and m substrings respectively,
 * such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 *
 * Example 1:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Explanation: One way to obtain s3 is:
 * Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
 * Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
 * Since s3 can be obtained by interleaving s1 and s2, we return true.
 *
 * Example 2:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
 *
 * Example 3:
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 *
 * Constraints:
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1, s2, and s3 consist of lowercase English letters.
 *
 * Follow up: Could you solve it using only O(s2.length) additional memory space?
 *
 */

public class _146M_InterleavingString {

    public static void main(String[] args) {
        String s1;
        String s2;
        String s3;

        s1 = "aabcc"; s2 = "dbbca"; s3 = "aadbbcbcac";
        System.out.println("isInterleave for string s1 = "+ s1 +" , s2 = "+ s2 +" , s3 = "+ s3 +" , equals "+isInterleave(s1, s2, s3));
        // true
        System.out.println();

        s1 = "aabcc"; s2 = "dbbca"; s3 = "aadbbbaccc";
        System.out.println("isInterleave for string s1 = "+ s1 +" , s2 = "+ s2 +" , s3 = "+ s3 +" , equals "+isInterleave(s1, s2, s3));
        // false
        System.out.println();

        s1 = ""; s2 = ""; s3 = "";
        System.out.println("isInterleave for string s1 = "+ s1 +" , s2 = "+ s2 +" , s3 = "+ s3 +" , equals "+isInterleave(s1, s2, s3));
        // true
        System.out.println();

    }

    // Best solution by Tabular DP
    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int p = s3.length();
        if (p != m+n) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for(int i=0;i<=m;i++){
            for (int j=0;j<=n;j++) {
                if (i==0 && j==0) {
                    dp[i][j]=true;
                } else if (i==0) {
                    dp[i][j]=dp[i][j-1] &&
                            s2.charAt(j-1) == s3.charAt(i+j-1);
                } else if (j==0) {
                    dp[i][j]=dp[i-1][j] &&
                            s1.charAt(i-1)==s3.charAt(i+j-1);
                } else {
                    dp[i][j]=(dp[i-1][j] &&
                            s1.charAt(i-1)==s3.charAt(i+j-1)) ||
                            (dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
                }
            }
        }
        return dp[m][n];
    }

    // Recursion with Memoization
    /*public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }
        int[][] memo = new int[s1.length()][s2.length()];
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                memo[i][j] = -1;
            }
        }
        return rec(
                s1,
                0,
                s2,
                0,
                s3,
                0,
                memo
        );
    }

    public static boolean rec(
            String s1,
            int i,
            String s2,
            int j,
            String s3,
            int k,
            int[][] memo
    ){
        if(i==s1.length()){
            return s2.substring(j).equals(s3.substring(k));
        }
        if(j==s2.length()){
            return s1.substring(i).equals(s3.substring(k));
        }
        if(memo[i][j]>=0){
            return memo[i][j]==1?true:false;
        }

        boolean op = false;
        if ((
                s3.charAt(k)==s1.charAt(i) &&
                rec(
                        s1,
                        i+1,
                        s2,
                        j,
                        s3,
                        k+1,
                        memo
                )
        ) || (
                s3.charAt(k) == s2.charAt(j) &&
                rec(
                        s1,
                        i,
                        s2,
                        j+1,
                        s3,
                        k+1,
                        memo
                )
        )) {
            op = true;
        }
        memo[i][j] = op ? 1 : 0;
        return op;
    }*/


    // Pure Brute force
    /*public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }
        return rec(
                s1,
                0,
                s2,
                0,
                s3,
                ""
        );
    }

    public static boolean rec(
            String s1,
            int i,
            String s2,
            int j,
            String s3,
            String res
    ){
        if(res.equals(s3) && i == s1.length() && j==s2.length()){
            return true;
        }
        boolean op = false;
        if(i<s1.length()){
            op |= rec(
                    s1,
                    i+1,
                    s2,
                    j,
                    s3,
                    res+s1.charAt(i)
            );
        }
        if(j<s2.length()){
            op |= rec(
                    s1,
                    i,
                    s2,
                    j+1,
                    s3,
                    res+s2.charAt(j)
            );
        }
        return op;
    }*/

}
