package com.shrek.leetCode._000_Unorganized;

/**
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence
 * by deleting some or no elements without changing the order of the remaining elements.
 *
 * Example 1:
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 *
 */

public class _154M_LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s;

        s = "bbbab";
        System.out.println("longestPalindromeSubseq for String = "+ s +" , equals "+longestPalindromeSubseq(s));
        // 4
        System.out.println();

        s = "cbbd";
        System.out.println("longestPalindromeSubseq for String = "+ s +" , equals "+longestPalindromeSubseq(s));
        // 2
        System.out.println();
    }

    // More optimal solution by not rev ersing the string but using substring reduction
    /*public static int longestPalindromeSubseq(String s) {
        int l = s.length();
        int[][] dp = new int[l][l];
        for(int i=l-1;i>=0;i--){
            dp[i][i] = 1;
            for(int j=i+1;j<l;j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1]+2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][l-1];
    }*/

    // Trick is to reverse the main string and perform LCS(longest common subsequence) over both, which will give the correct result.
    public static int longestPalindromeSubseq(String s) {
        int l = s.length();
        String r = "";
        char ch;

        for (int i = 0;i<l;i++) {
            ch = s.charAt(i);
            r = ch + r;
        }

        System.out.println(r);

        int[][] dp = new int[l+1][l+1];
        for(int i=0;i<l+1;i++){
            for(int j=0;j<l+1;j++){
                dp[i][j] = 0;
            }
        }

        for(int i=1;i<l+1;i++){
            for(int j=1;j<l+1;j++){
                if(s.charAt(i-1)==r.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        /*for(int i=0;i<l+1;i++){
            for(int j=0;j<l+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/

        return dp[l][l];
    }

}
