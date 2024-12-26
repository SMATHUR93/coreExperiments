package com.shrek.leetCode._019_Math;

/**
 *
 * Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 *
 * Follow up: Could you solve it without converting the integer to a string?
 *
 * Hint 1
 * Beware of overflow when you reverse the integer.
 *
 */

public class _131E_PalindromeNumber {

    public boolean isPalindrome(int x) {
        int num = x;
        int op=0;
        while(num>0){
            op = op*10 + num%10;
            num=num/10;
        }
        if(op==x){
            return true;
        } else{
            return false;
        }
    }

}
