package com.shrek.leetCode._020_1D_DP;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 */

public class _137M_HouseRobber {

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{1,2,3,1};
        System.out.println("rob for nums = "+ Arrays.toString(nums)+" , equals "+rob(nums));
        // 4
        System.out.println();

        nums = new int[]{2,7,9,3,1};
        System.out.println("rob for nums = "+ Arrays.toString(nums)+" , equals "+rob(nums));
        // 12
        System.out.println();

        nums = new int[]{1,2,1,1};
        System.out.println("rob for nums = "+ Arrays.toString(nums)+" , equals "+rob(nums));
        // 3
        System.out.println();

        nums = new int[]{2,1,1,2};
        System.out.println("rob for nums = "+ Arrays.toString(nums)+" , equals "+rob(nums));
        // 4
        System.out.println();

    }

    // Best Solution by Dynamic Programming using 2 variables to imitate tabulation
    public static int rob(int[] nums) {
        int n = nums.length;
        int take, notTake;
        int prev2=0;
        int prev = nums[0];
        int curr = 0;
        for(int i=1;i<n;i++){
            take = nums[i];
            if(i>1){
                take+=prev2;
            }
            notTake = 0 + prev;
            curr = Math.max(take, notTake);

            prev2 = prev;
            prev = curr;
            //System.out.println("dp = "+ Arrays.toString(dp)+" , take = "+take+" , notTake = "+notTake);
        }
        return prev;
    }

    // Better Solution by Dynamic Programming using Tabulation
    /*public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        int take, notTake;
        for(int i=1;i<n;i++){
            take = nums[i];
            if(i>1){
                take+=dp[i-2];
            }
            notTake = 0 + dp[i-1];
            dp[i] = Math.max(take, notTake);
            System.out.println("dp = "+ Arrays.toString(dp)+" , take = "+take+" , notTake = "+notTake);
        }
        return dp[n-1];
    }*/

    // Good Solution by Recursion using Memoization
    /*public static int count=0;
    public static int rob(int[] nums) {
        int[] dp =  new int[nums.length + 1];
        Arrays.fill(dp, -1);
        // count = 0;
        int op = rec(0, nums, dp);
        // System.out.println("Debugging, count = "+count);
        return op;
    }

    static int rec(int idx, int[] nums, int[] dp){
        // count++;
        if(idx>nums.length-1){
            return 0;
        }
        if(idx==nums.length-1){
            return nums[idx];
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int pick = nums[idx] + rec(idx+2, nums, dp);
        int notPick = 0 + rec(idx+1, nums, dp);
        dp[idx] = Integer.max(pick, notPick);
        System.out.println("Debugging, idx = "+idx+" , dp = "+Arrays.toString(dp));
        return dp[idx];
    }*/

    // Pure Brute Force using Recursion
    /*public static int rob(int[] nums) {
        count = 0;
        int op = rec(0, nums);
        System.out.println("Debugging, count = "+count);
        return op;
    }

    static int rec(int idx, int[] nums){
        count++;
        if(idx>nums.length-1){
            return 0;
        }
        if(idx==nums.length-1){
            return nums[idx];
        }
        int pick = nums[idx] + rec(idx+2, nums);
        int notPick = 0 + rec(idx+1, nums);
        return Integer.max(pick, notPick);
    }*/

}
