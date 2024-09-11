package com.shrek.leetCode._002_TwoPointers;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */

public class _025E_ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("isPalindrome for string s = " + s + " = "+ isPalindrome(s));
        // true
        System.out.println("-------------- BREAK -----------------");
        s = "race a car";
        System.out.println("isPalindrome for string s = " + s + " = "+ isPalindrome(s));
        // false
        System.out.println("-------------- BREAK -----------------");
        s = " ";
        System.out.println("isPalindrome for string s = " + s + " = "+ isPalindrome(s));
        // true
        System.out.println("-------------- BREAK -----------------");
        s = " apG0i4maAs::sA0m4i0Gp0";
        System.out.println("isPalindrome for string s = " + s + " = "+ isPalindrome(s));
        // true
        System.out.println("-------------- BREAK -----------------");
    }

    public static boolean isPalindrome(String s) {
        s = s.trim();
        int n = s.length();
        if(s.equals("")){
            return true;
        }
        if(n<=1){
            return true;
        }
        char[] arr = s.toCharArray();
        char l, r;
        int i=0;
        int j=n-1;
        while(i<j){
            l = Character.toLowerCase(arr[i]);
            r = Character.toLowerCase(arr[j]);
            if( !((l >= 'a' && l <= 'z') || (l >= '0' && l <= '9'))){
                i++;
            } else if( !((r >= 'a' && r <= 'z') || (r >= '0' && r <= '9')) ) {
                j--;
            } else if(l==r){
                i++;
                j--;
            } else{
                return false;
            }
        }
        return true;
    }

}
