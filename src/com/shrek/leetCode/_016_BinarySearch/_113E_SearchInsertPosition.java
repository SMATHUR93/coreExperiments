package com.shrek.leetCode._016_BinarySearch;

import java.util.Arrays;

/**
 *
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 *
 */

public class _113E_SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums;
        int target;

        nums = new int[]{1,3,5,6};
        target = 5;
        System.out.println("searchInsert for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+searchInsert(nums, target));
        // 2
        System.out.println();


        nums = new int[]{1,3,5,6};
        target = 2;
        System.out.println("searchInsert for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+searchInsert(nums, target));
        // 1
        System.out.println();

        nums = new int[]{1,3,5,6};
        target = 7;
        System.out.println("searchInsert for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+searchInsert(nums, target));
        // 4
        System.out.println();

        nums = new int[]{1,3,5,6};
        target = 0;
        System.out.println("searchInsert for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+searchInsert(nums, target));
        // 0
        System.out.println();

        nums = new int[]{1,3};
        target = 4;
        System.out.println("searchInsert for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+searchInsert(nums, target));
        // 2
        System.out.println();
    }

    public static int searchInsert(int[] nums, int target) {
        /*int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivt] == target) {
                return pivot;
            }
            if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return left;*/
        return 0;
    }

}
