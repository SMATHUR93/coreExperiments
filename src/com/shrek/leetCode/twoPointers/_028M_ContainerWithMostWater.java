package com.shrek.leetCode.twoPointers;

import java.util.Arrays;

/**
 *
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container,
 * such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 *
 */

public class _028M_ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("maxArea for height = " + Arrays.toString(height) + " , = "+ maxArea(height) );
        // 49
        System.out.println("-------------- BREAK -----------------");
        height = new int[]{1, 1};
        System.out.println("maxArea for height = " + Arrays.toString(height) + " , = "+ maxArea(height) );
        // 1
        System.out.println("-------------- BREAK -----------------");
        height = new int[]{1, 7, 7, 2, 1};
        System.out.println("maxArea for height = " + Arrays.toString(height) + " , = "+ maxArea(height) );
        // 1
        System.out.println("-------------- BREAK -----------------");
    }

    public static int maxArea(int[] arr) {

        int n = arr.length;
        int water = 0;
        int l = 0;
        int r = n-1;
        int lh, rh, range;
        if(n<=1){
            return arr[0];
        }
        if(n<=2){
            return Math.min(arr[0], arr[1]);
        }

        while(l<r){
            lh = arr[l];
            rh = arr[r];
            range = r-l;

            if(water < range * Math.min(lh, rh)){
                water = range * Math.min(lh, rh);
            }

            // System.out.println("Debugging in loop, l = " + l +" , r = " + r + " , lh = " + lh + " , rh = " + rh + " , range = " + range + " , water = " + water);
            if(lh>rh){
                r--;
            } else{
                l++;
            }
        }
        return water;
    }

}
