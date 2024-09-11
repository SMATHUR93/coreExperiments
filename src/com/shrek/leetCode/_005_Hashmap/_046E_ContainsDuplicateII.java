package com.shrek.leetCode._005_Hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 *
 */

public class _046E_ContainsDuplicateII {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println("containsNearbyDuplicate for nums = " + Arrays.toString(nums) + " and k = "+ k +" is " + containsNearbyDuplicate(nums, k) );
        // true
        System.out.println("-------------- BREAK -----------------");

        nums = new int[]{1,0,1,1};
        k = 1;
        System.out.println("containsNearbyDuplicate for nums = " + Arrays.toString(nums) + " and k = "+ k +" is " + containsNearbyDuplicate(nums, k) );
        // true
        System.out.println("-------------- BREAK -----------------");

        nums = new int[]{1,2,3,1,2,3};
        k = 2;
        System.out.println("containsNearbyDuplicate for nums = " + Arrays.toString(nums) + " and k = "+ k +" is " + containsNearbyDuplicate(nums, k) );
        // false
        System.out.println("-------------- BREAK -----------------");

        nums = new int[]{99, 99};
        k = 2;
        System.out.println("containsNearbyDuplicate for nums = " + Arrays.toString(nums) + " and k = "+ k +" is " + containsNearbyDuplicate(nums, k) );
        // false
        System.out.println("-------------- BREAK -----------------");
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map =  new HashMap<Integer, Integer>();
        int newValue;
        int oldValue;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                oldValue = map.get(nums[i]);
                newValue = i;
                if(Math.abs(newValue-oldValue)<=k){
                    return true;
                } else if(Math.abs(newValue-oldValue)>k){
                    map.put(nums[i], newValue);
                }
            } else{
                map.put(nums[i], i);
            }
        }
        return false;
    }

}
