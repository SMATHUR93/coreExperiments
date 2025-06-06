package com.shrek.leetCode._016_BinarySearch;

import java.util.Arrays;

/**
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function,
 * nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array
 * is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 *
 * Constraints:
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 *
 */

public class _117M_SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums;
        int target;

        nums = new int[]{4,5,6,7,0,1,2};
        target = 0;
        System.out.println("search for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+search(nums, target));
        // 4
        System.out.println();

        nums = new int[]{4,5,6,7,0,1,2};
        target = 3;
        System.out.println("search for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+search(nums, target));
        // -1
        System.out.println();

        nums = new int[]{1};
        target = 0;
        System.out.println("search for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+search(nums, target));
        // -1
        System.out.println();

    }

    // Using Binary search, though it is nearly useless in this
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /*public static int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }*/

}
