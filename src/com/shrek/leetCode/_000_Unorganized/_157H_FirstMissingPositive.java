package com.shrek.leetCode._000_Unorganized;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an unsorted integer array nums.
 * Return the smallest positive integer that is not present in nums.
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 *
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 *
 * Example 2:
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 *
 * Example 3:
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 *
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 *
 * Hint 1
 * Think about how you would solve the problem in non-constant space. Can you apply that logic to the existing space?
 *
 * Hint 2
 * We don't care about duplicates or non-positive integers
 *
 * Hint 3
 * Remember that O(2n) = O(n)
 *
 */

public class _157H_FirstMissingPositive {

    public static void main(String args[] ) throws Exception {
        int[] numbers = {1,2,0};
        System.out.println("firstMissingPositive for numbers = " + Arrays.toString(numbers) + " , = "+ firstMissingPositive(numbers) );
        // 3
        System.out.println("-------------- BREAK -----------------");
        numbers = new int[]{3,4,-1,1};
        System.out.println("firstMissingPositive for numbers = " + Arrays.toString(numbers) + " , = "+ firstMissingPositive(numbers) );
        // 2
        System.out.println("-------------- BREAK -----------------");
        numbers = new int[]{7,8,9,11,12};
        System.out.println("firstMissingPositive for numbers = " + Arrays.toString(numbers) + " , = "+ firstMissingPositive(numbers) );
        // 1

    }

    public static int firstMissingPositive(int[] nums) {
        int op = 1;
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(nums[i]>0 && !map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }
        for(int i=1;i<=n;i++){
            if(map.containsKey(i)){
                op+=1;
            } else{
                break;
            }
        }
        return op;
    }

}
