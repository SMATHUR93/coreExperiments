package com.shrek.leetCode._018_BitManipulation;

/**
 *
 * Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
 *
 *
 *
 * Example 1:
 *
 * Input: left = 5, right = 7
 * Output: 4
 * Example 2:
 *
 * Input: left = 0, right = 0
 * Output: 0
 * Example 3:
 *
 * Input: left = 1, right = 2147483647
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= left <= right <= 231 - 1
 *
 */

public class _129M_BitwiseANDOfNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // find the common 1-bits
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

}
