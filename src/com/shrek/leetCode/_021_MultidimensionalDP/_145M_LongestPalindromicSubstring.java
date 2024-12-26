package com.shrek.leetCode._021_MultidimensionalDP;

/**
 *
 * Given a string s, return the longest palindromic substring in s.
 * A string is palindromic if it reads the same forward and backward.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 *
 * Hint 1
 * How can we reuse a previously computed palindrome to compute a larger palindrome?
 *
 * Hint 2
 * If “aba” is a palindrome, is “xabax” a palindrome? Similarly is “xabay” a palindrome?
 *
 * Hint 3
 * Complexity based hint:
 * If we use brute-force and check whether for every start and end position a substring is a palindrome we have O(n^2) start - end pairs and O(n) palindromic checks.
 * Can we reduce the time for palindromic checks to O(1) by reusing some previous computation.
 *
 */

public class _145M_LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s;

        s = "babad";
        System.out.println("longestPalindrome for string = "+ s +" , equals "+longestPalindrome(s));
        // "bab"
        System.out.println();

        s = "cbbd";
        System.out.println("longestPalindrome for string = "+ s +" , equals "+longestPalindrome(s));
        // "bb"
        System.out.println();

        s = "ac";
        System.out.println("longestPalindrome for string = "+ s +" , equals "+longestPalindrome(s));
        // "a"
        System.out.println();

        s = "aacabdkacaa";
        System.out.println("longestPalindrome for string = "+ s +" , equals "+longestPalindrome(s));
        // "aca"
        System.out.println();

    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[]{0, 0};

        for (int i=0;i<n;i++) {
            dp[i][i] = true;
        }

        for (int i=0;i<n-1;i++) {
            if (s.charAt(i)==s.charAt(i+1)) {
                dp[i][i+1] = true;
                ans[0] = i;
                ans[1] = i + 1;
            }
        }

        for (int diff=2;diff<n;diff++) {
            for (int i=0;i<n-diff;i++) {
                int j = i + diff;
                if (s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        int i = ans[0];
        int j = ans[1];
        return s.substring(i, j + 1);
    }

    // Full brute force
    /*public static String longestPalindrome(String s) {
        return rec(s);
    }

    public static String rec(String s){
        System.out.println("Checking recursion for string  = "+s);
        if(s.length()==2){
            System.out.println("Size is 2 for string  = "+s);
            return s.charAt(0)==s.charAt(1) ? s: s.substring(0, s.length()-1);
        }
        if(checkPalindrome(s.toCharArray())){
            System.out.println("Found Palidrome for string  = "+s);
            return s;
        }
        String start = rec(s.substring(1));
        String end = rec(s.substring(0, s.length()-1));
        return start.length() > end.length() ? start : end;
    }

    public static boolean checkPalindrome(char[] arr){
        int l=0, n=arr.length;
        if(n%2==0) {
            l = n/2 - 1;
        } else {
            l = n/2;
        }
        for(int i=0;i<=l;i++){
            if(arr[i]!=arr[n-i-1]){
                return false;
            }
        }
        return true;
    }*/

}
