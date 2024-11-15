package com.shrek.leetCode._018_BitManipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each element in nums appears exactly three times except for one element which appears once.
 *
 */

public class _128M_SingleNumberII {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        long sum=0, setSum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            set.add(nums[i]);
        }
        for(int i:set){
            setSum+=i;
        }
        return (int) ( ( setSum*3 - sum ) /2 );
    }

}
