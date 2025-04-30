package com.shrek.leetCode._000_Unorganized;

import java.util.*;

/**
 *
 * Given an array of integers nums and an integer k,
 * return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * Topics
 * Array
 * Hash Table
 * Prefix Sum
 *
 * Hint 1
 * Will Brute force work here? Try to optimize it.
 *
 * Hint 2
 * Can we optimize it by using some extra space?
 *
 * Hint 3
 * What about storing sum frequencies in a hash table? Will it be useful?
 *
 * Hint 4
 * sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1. Can we use this property to optimize it.
 *
 */

public class _156M_SubarraySumEqualsK {

    public static void main(String args[] ) throws Exception {
        int[] numbers = {1,1,1};
        int target = 2;
        System.out.println("subarraySum for numbers = " + Arrays.toString(numbers) + " , target = " + target + " , = "+ subarraySum(target, numbers) );
        // 2
        System.out.println("-------------- BREAK -----------------");
        numbers = new int[]{1,2,3};
        target = 3;
        System.out.println("subarraySum for numbers = " + Arrays.toString(numbers) + " , target = " + target + " , = "+ subarraySum(target, numbers) );
        // 2
        System.out.println("-------------- BREAK -----------------");
        numbers = new int[]{-2,1,2,-2,5,-2,1};
        target = 3;
        System.out.println("subarraySum for numbers = " + Arrays.toString(numbers) + " , target = " + target + " , = "+ subarraySum(target, numbers) );
        // 5

    }

    public static int subarraySum(int k, int[] nums) {
        int n = nums.length;
        int op=0;
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum=0;
        map.put(0, 1);
        for(int i=0;i<n;i++){
            prefixSum += nums[i];
            op += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        System.out.println(map.toString());
        return op;
    }

    /*
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // int l=0;
        // int r=0;
        int op=0;
        for(int l=0;l<n;l++){
            int currSum = 0;
            for(int r=l;r<n;r++){
                currSum+=nums[r];
                if(currSum==k){
                    op++;
                    continue;
                }
            }
        }
        return op;
    }
    */

}
