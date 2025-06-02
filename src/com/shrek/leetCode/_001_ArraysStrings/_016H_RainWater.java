package com.shrek.leetCode._001_ArraysStrings;

/**
 * Given n non-negative integers representing an elevation map
 * where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation:
 * The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */

import java.util.Arrays;

public class _016H_RainWater {

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(trap(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{4,2,0,3,2,5};
        System.out.println(Arrays.toString(nums));
        System.out.println(trap(nums));
        System.out.println("-------------- BREAK -----------------");
        /*nums = new int[]{1,3,2,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(trap(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{1,2,3,3,3,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(trap(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{0,0,1,0,0,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(trap(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{3,0,6,1,5};
        System.out.println(Arrays.toString(nums));
        System.out.println(trap(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{9,7,2,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(trap(nums));*/
    }

    // Solution: Calculating left and right high elements to calculate total water accumulated.
    public static int trap(int[] height) {
        int n = height.length;
        int rain = 0;

        int[] leftHigh = new int[n];
        leftHigh[0] = height[0];
        for(int i=1;i<n;i++){
            leftHigh[i] = Math.max(height[i], leftHigh[i-1]);
        }

        int[] rightHigh = new int[n];
        rightHigh[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            rightHigh[i] = Math.max(height[i], rightHigh[i+1]);
        }

        System.out.println(Arrays.toString(leftHigh));

        System.out.println(Arrays.toString(rightHigh));

        for(int i=0;i<n;i++){
            rain += Math.min(leftHigh[i], rightHigh[i]) - height[i];
        }
        return rain;
    }

}
