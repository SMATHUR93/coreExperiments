package com.shrek.leetCode.arraysStrings;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 *
 * Follow up:
 *
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 * Hint 1
 * The easiest solution would use additional memory and that is perfectly fine.
 * Hint 2
 * The actual trick comes when trying to solve this problem without using any additional memory. This means you need to use the original array somehow to move the elements around. Now, we can place each element in its original location and shift all the elements around it to adjust as that would be too costly and most likely will time out on larger input arrays.
 * Hint 3
 * One line of thought is based on reversing the array (or parts of it) to obtain the desired result. Think about how reversal might potentially help us out by using an example.
 * Hint 4
 * The other line of thought is a tad bit complicated but essentially it builds on the idea of placing each element in its original position while keeping track of the element originally in that position. Basically, at every step, we place an element in its rightful position and keep track of the element already there or the one being overwritten in an additional variable. We can't do this in one linear pass and the idea here is based on cyclic-dependencies between elements.
 */

public class _006M_RotateArray {

    public static void main(String[] args) {
        int[] nums = {9,2,3,4,3,2,1};
        rotate(nums, 2);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    // Approach 3 : space optimized despite additional array, less time optimization 191 ms, 55.09 MB
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k%n!=0){
            k = k%n;
            int[] temp = new int[n];
            int j=0;
            // System.out.println("Loop 1");
            for(int i=n-k;i<n;i++){
                System.out.println(nums[i]);
                temp[j] = nums[i];
                j++;
            }
            // System.out.println("Loop 2");
            for(int i=0;i<n-k;i++){
                System.out.println(nums[i]);
                temp[j] = nums[i];
                j++;
            }
            for(int l=0;l<n;l++){
                nums[l] = temp[l];
            }
        }
    }

    // Approach 2: using reversal based on rotation count, time optimized but less space optimized, 2ms, 57.25 MB
    /*public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k%n!=0){
            k = k%n;
            reverse(nums, 0, n-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, n-1);
        }
    }

    public void reverse(int[] nums, int start, int end){
        int temp;
        while(start<end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }*/


    // Approach 1: brute force with additional space
    /*
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp;
        for(int i=0;i<k;i++){
            temp = new int[n];
            temp[0] = nums[n-1];
            for(int j=1;j<n;j++){
                temp[j] = nums[j-1];
            }
            for(int l=0;l<n;l++){
                nums[l] = temp[l];
            }
        }
    }*/
}
