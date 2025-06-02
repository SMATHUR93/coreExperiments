package com.shrek.leetCode._001_ArraysStrings;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 *
 */

public class _005E_MajorityElement {

    public static void main(String[] args) {
        int[] nums = {9,2,3,4,3,2,1};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {

        // Using main assumption of majority element to get result in o(n) complexity
        int n = nums.length;
        if(n>1){
            int maxEl=nums[0];
            int maxCount=1;
            int temp;
            for(int i=1;i<n;i++){
                if(maxCount==0){
                    maxEl = nums[i];
                }
                if(nums[i]!=maxEl){
                    maxCount--;
                } else{
                    maxCount++;
                }
            }
            return maxEl;
        } else if(n==1){
            return nums[0];
        } else{
            return 0;
        }

        /* //Using Hashmap
        int n = nums.length;
        if(n>1){
            int maxEl=nums[0];
            int maxCount=1;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(nums[0], 1);
            int temp;
            for(int i=1;i<n;i++){
                if(map.containsKey(nums[i])){
                    temp = map.get(nums[i])+1;
                } else{
                    temp = 1;
                }
                map.put(nums[i], temp);
                if(temp>maxCount){
                    maxEl = nums[i];
                    maxCount = temp;
                }
            }
            return maxEl;
        } else if(n==1){
            return nums[0];
        } else{
            return 0;
        }*/

    }
}
