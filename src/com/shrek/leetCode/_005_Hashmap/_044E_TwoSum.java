package com.shrek.leetCode._005_Hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 *
 * Hint 1
 * A really brute force way would be to search for all possible pairs of numbers but that would be too slow.
 * Again, it's best to try out brute force solutions for just for completeness.
 * It is from these brute force solutions that you can come up with optimizations.
 *
 * Hint 2
 * So, if we fix one of the numbers, say x,
 * we have to scan the entire array to find the next number y which is value - x where value is the input parameter.
 * Can we change our array somehow so that this search becomes faster?
 *
 * Hint 3
 * The second train of thought is, without changing the array, can we use additional space somehow?
 * Like maybe a hash map to speed up the search?
 *
 */

public class _044E_TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println("twoSum for nums = " + Arrays.toString(nums) + " and target = "+ target +" is " + Arrays.toString( twoSum(nums, target) ));
        // [0, 1]
        System.out.println("-------------- BREAK -----------------");

        nums = new int[]{3,2,4};
        target = 6;
        System.out.println("twoSum for nums = " + Arrays.toString(nums) + " and target = "+ target +" is " + Arrays.toString( twoSum(nums, target) ));
        // [1, 2]
        System.out.println("-------------- BREAK -----------------");

        nums = new int[]{3,3};
        target = 6;
        System.out.println("twoSum for nums = " + Arrays.toString(nums) + " and target = "+ target +" is " + Arrays.toString( twoSum(nums, target) ));
        // [0, 1]
        System.out.println("-------------- BREAK -----------------");
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if(n<=1){
            return null;
        }
        if(n==2){
            return nums[0] + nums[1] == target ? new int[]{0, 1} : null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int complement = 0;
        for(int i=0;i<n;i++){
            complement = target - nums[i];
            if(map.get(complement)!=null){
                return new int[]{map.get(complement), i};
            } else{
                map.put(nums[i], i);
                System.out.println("map in loop = " + map);
            }
        }
        System.out.println("map after loop = " + map);
        return null;
    }

}
