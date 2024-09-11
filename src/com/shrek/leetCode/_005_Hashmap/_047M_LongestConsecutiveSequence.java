package com.shrek.leetCode._005_Hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 */

public class _047M_LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println("longestConsecutive for nums = " + Arrays.toString(nums) + " is " + longestConsecutive(nums) );
        // 4
        System.out.println("-------------- BREAK -----------------");

        nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println("longestConsecutive for nums = " + Arrays.toString(nums) + " is " + longestConsecutive(nums) );
        // 9
        System.out.println("-------------- BREAK -----------------");
    }

    public static int longestConsecutive(int[] nums) {
        int n =  nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            map.put(nums[i], nums[i]+1);
        }
        int maxLen = 0;
        int len = 0;
        int el;
        int p=0;
        while(p<n){
            el=nums[p];
            if(!map.containsKey(el-1)){
                len=0;
                while(map.containsKey(el)){
                    el = map.get(el);
                    len++;
                    maxLen = Math.max(len, maxLen);
                }
            }
            p++;
        }
        return maxLen;
    }

}
