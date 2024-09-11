package com.shrek.leetCode._006_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges,
 * and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * Example 2:
 *
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * All the values of nums are unique.
 * nums is sorted in ascending order.
 *
 */

public class _048E_SummaryRanges {

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println("summaryRanges for nums = " + Arrays.toString(nums) + " is " + summaryRanges(nums) );
        // ["0->2","4->5","7"]
        System.out.println("-------------- BREAK -----------------");

        nums = new int[]{0,2,3,4,6,8,9};
        System.out.println("summaryRanges for nums = " + Arrays.toString(nums) + " is " + summaryRanges(nums) );
        // ["0","2->4","6","8->9"]
        System.out.println("-------------- BREAK -----------------");
    }

    public static List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ll = new ArrayList<String>();
        int i=0;
        int start=0;
        int end=0;
        while(i<n){
            start = i;
            end = i;
            while(i+1<=n-1 && nums[i]+1==nums[i+1]){
                end = i+1;
                i++;
            }
            if(start!=end){
                ll.add(nums[start]+"->"+nums[end]);
            } else{
                ll.add(nums[start]+"");
            }
            i++;
        }
        return ll;
    }

}
