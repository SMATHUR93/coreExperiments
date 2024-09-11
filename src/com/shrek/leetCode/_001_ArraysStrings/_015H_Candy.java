package com.shrek.leetCode._001_ArraysStrings;

import java.util.Arrays;

/**
 *
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 *
 *
 * Example 1:
 *
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 *
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 *
 *
 * Constraints:
 *
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 *
 */

public class _015H_Candy {

    public static void main(String[] args) {
        int[] nums = {1,0,2};
        System.out.println(Arrays.toString(nums));
        System.out.println(candy(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{1,2,2};
        System.out.println(Arrays.toString(nums));
        System.out.println(candy(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{1,3,2,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(candy(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{1,2,3,3,3,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(candy(nums));
        System.out.println("-------------- BREAK -----------------");
        /*nums = new int[]{0,0,1,0,0,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(candy(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{3,0,6,1,5};
        System.out.println(Arrays.toString(nums));
        System.out.println(candy(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{9,7,2,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(candy(nums));*/
    }


    // Greedy Approach : comapring left and right high element
    public static int candy(int[] arr) {
        int n = arr.length;

        int[] temp = new int[n];
        Arrays.fill(temp, 1);

        int sum=0;

        int[] leftHigh = new int[n];
        Arrays.fill(leftHigh, 1);
        for(int i =1;i<n;i++){
            if(arr[i] > arr[i-1]){
                leftHigh[i] += leftHigh[i-1];
            }
        }

        int[] rightHigh = new int[n];
        Arrays.fill(rightHigh, 1);
        for(int i = n-2;i>=0;i--){
            if(arr[i] > arr[i+1]){
                rightHigh[i] += rightHigh[i+1];
            }
        }

        for(int i = 0;i<n;i++){
            temp[i] = Math.max(leftHigh[i], rightHigh[i]);
        }

        System.out.println(Arrays.toString(temp));

        for(int i=0;i<n;i++){
            sum+=temp[i];
        }
        return sum;
    }

}
