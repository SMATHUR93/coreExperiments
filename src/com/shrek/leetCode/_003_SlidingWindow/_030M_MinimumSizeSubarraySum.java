package com.shrek.leetCode._003_SlidingWindow;

import java.util.Arrays;

/**
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 *
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 *
 */

public class _030M_MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] numbers = {2,3,1,2,4,3};
        int target = 7;
        System.out.println("minSubArrayLen for numbers = " + Arrays.toString(numbers) + " , target = " + target + " , = "+ minSubArrayLen(target, numbers) );
        // 2
        System.out.println("-------------- BREAK -----------------");
        numbers = new int[]{1,4,4};
        target = 4;
        System.out.println("minSubArrayLen for numbers = " + Arrays.toString(numbers) + " , target = " + target + " , = "+ minSubArrayLen(target, numbers) );
        // 1
        System.out.println("-------------- BREAK -----------------");
        numbers = new int[]{1,1,1,1,1,1,1,1};
        target = 11;
        System.out.println("minSubArrayLen for numbers = " + Arrays.toString(numbers) + " , target = " + target + " , = "+ minSubArrayLen(target, numbers) );
        // 0
        System.out.println("-------------- BREAK -----------------");
        numbers = new int[]{1,2,3,4,5};
        target = 11;
        System.out.println("minSubArrayLen for numbers = " + Arrays.toString(numbers) + " , target = " + target + " , = "+ minSubArrayLen(target, numbers) );
        // 3
        System.out.println("-------------- BREAK -----------------");
        numbers = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        target = 213;
        System.out.println("minSubArrayLen for numbers = " + Arrays.toString(numbers) + " , target = " + target + " , = "+ minSubArrayLen(target, numbers) );
        // 8
        System.out.println("-------------- BREAK -----------------");
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l=0;
        int r=0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int currLen = 0;
        while(r<n){
            sum += nums[r];
            while(sum>=target){
                currLen = r - l + 1;
                minLen = Math.min(currLen, minLen);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        if(minLen==Integer.MAX_VALUE){
            return 0;
        } else{
            return minLen;
        }
    }

}
