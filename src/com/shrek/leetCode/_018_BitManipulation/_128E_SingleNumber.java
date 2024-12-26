package com.shrek.leetCode._018_BitManipulation;

/**
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 *
 * Hint 1
 * Think about the XOR (^) operator's property.
 *
 */

public class _128E_SingleNumber {

    /**
     *
     * Bit Manipulation
     * Concept
     *
     * If we take XOR of zero and some bit, it will return that bit
     * a⊕0=a
     * If we take XOR of two same bits, it will return 0
     * a⊕a=0
     * a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     * So we can XOR all bits together to find the unique number.
     *
     */
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

    // Stright forward answer but not gonna satisfy best space time complexity
    /*public int singleNumber(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        for (int i : nums) {
            if (!ll.contains(i)) {
                ll.add(i);
            } else {
                ll.remove(new Integer(i));
            }
        }
        return ll.get(0);
    }*/

}
