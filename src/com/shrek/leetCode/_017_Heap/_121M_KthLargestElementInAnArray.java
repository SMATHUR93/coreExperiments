package com.shrek.leetCode._017_Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.PriorityQueue;

/**
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 */

public class _121M_KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums;
        int k;

        nums = new int[]{3,2,1,5,6,4};
        k = 2;
        System.out.println("searchRange for nums = "+ Arrays.toString(nums) +" , k = "+k+" , equals "+findKthLargest(nums, k));
        // 5
        System.out.println();

        nums = new int[]{3,2,3,1,2,4,5,5,6};
        k = 4;
        System.out.println("searchRange for nums = "+ Arrays.toString(nums) +" , k = "+k+" , equals "+findKthLargest(nums, k));
        // 4
        System.out.println();

    }

    // Using Heaps
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        return heap.peek();
    }

    // Using quick select extremely initutive approach
    /*public static int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num: nums) {
            list.add(num);
        }
        return quickSelect(list, k);
    }

    public static int quickSelect(List<Integer> nums, int k) {
        int pivotIndex = new Random().nextInt(nums.size());
        int pivot = nums.get(pivotIndex);

        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int num: nums) {
            if (num > pivot) {
                left.add(num);
            } else if (num < pivot) {
                right.add(num);
            } else {
                mid.add(num);
            }
        }
        if (k <= left.size()) {
            return quickSelect(left, k);
        }
        if (left.size() + mid.size() < k) {
            return quickSelect(right, k - left.size() - mid.size());
        }
        return pivot;
    }*/

    // Naive way of sorting the array o(nlogn) is time complexity
    /*public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }*/

}
