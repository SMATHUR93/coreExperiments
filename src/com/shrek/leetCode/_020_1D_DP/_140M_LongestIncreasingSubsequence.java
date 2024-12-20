package com.shrek.leetCode._020_1D_DP;

import java.util.Arrays;

/**
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 * Constraints:
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 *
 */

public class _140M_LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println("lengthOfLIS for nums = "+ Arrays.toString(nums)+" , equals "+lengthOfLIS(nums));
        // 4
        System.out.println();

        nums = new int[]{0,1,0,3,2,3};
        System.out.println("lengthOfLIS for nums = "+ Arrays.toString(nums)+" , equals "+lengthOfLIS(nums));
        // 4
        System.out.println();

        nums = new int[]{7,7,7,7,7,7,7};
        System.out.println("lengthOfLIS for nums = "+ Arrays.toString(nums)+" , equals "+lengthOfLIS(nums));
        // 1
        System.out.println();

        nums = new int[]{1,2,3};
        System.out.println("lengthOfLIS for nums = "+ Arrays.toString(nums)+" , equals "+lengthOfLIS(nums));
        // 1
        System.out.println();

    }

    // Straight forward Tabulation Method
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    // System.out.println(Arrays.toString(dp));
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        int op=0;
        for(int i=0;i<n;i++){
            op = Math.max(op, dp[i]);
        }
        return op;
    }

}
