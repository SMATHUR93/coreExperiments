package com.shrek.leetCode.arraysStrings;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 * Hint: move goal to the left of array if we meet a simple condition
 *
 * Solution:
 * Step by Step Algorithm
 * Initialization:
 *
 * goal = len(nums) - 1
 * goal = len(nums) - 1: Initialize the variable goal to the last index of the array nums. This represents the goal position we want to reach.
 * Main Loop:
 *
 * for i in range(len(nums) - 2, -1, -1):
 * for i in range(len(nums) - 2, -1, -1): Iterate backward through the array nums, starting from the second to last element down to the first element.
 * Checking Jumpability:
 *
 * if i + nums[i] >= goal:
 * if i + nums[i] >= goal: Check if the current index i plus the maximum jump length at that position (nums[i]) is greater than or equal to the goal. If it is, it means we can jump from index i to the goal or beyond.
 * Updating Goal:
 *
 * goal = i
 * goal = i: If the condition in step 3 is met, update the goal to the current index i. This means we have found a new closer position from which we can reach the previous goal position.
 * Return Result:
 *
 * return True if goal == 0 else False
 * return True if goal == 0 else False: If we successfully reach the first index (i.e., goal == 0), return True, indicating that it's possible to reach the last index from the first index. Otherwise, return False.
 *
 */

public class _009M_JumpGame {

    public static void main(String[] args) {
        // int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
        System.out.println(Arrays.toString(nums));
        System.out.println(canJump(nums));
        /*for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }*/
    }

    // Most optimal solution of moving goal
    public static boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }

    // My Solution: couldn't break time complexity
    /*public static boolean canJump(int[] nums) {
        int n = nums.length;
        int jump;
        int step;
        Map<Integer, String> map = new HashMap<Integer, String>();
        for(int i=0;i<n;i++){
            jump = nums[i];
            System.out.println("i = "+i +", jump = "+jump);
            if((jump==0 || i==(n-1)) ){

            } else {
                for(int j=1;j<=jump;j++){
                    step = i+j;
                    System.out.println("i = "+i +", j = "+j+", step = "+step);
                    if(map.containsKey((Integer)step)){
                        map.put((Integer) step,  map.get(step) + "," + Integer.toString(i) );
                    } else{
                        map.put((Integer) step, Integer.toString(i));
                    }
                }
            }
        }
        System.out.println("target: sources map");
        for(Integer itr: map.keySet()){
            System.out.println(itr + " - " + map.get(itr));
        }
        System.out.println("-------------------");
        int finalPoint = n-1;
        boolean val = recursion( map, finalPoint);
        System.out.println("Value fof recursion is "+ val);
        return val;
    }

    public static boolean recursion(Map<Integer, String> map, int finalPoint){
        boolean bol = false;
        if(!map.containsKey(finalPoint)){
            System.out.println("Reaching nowhere, returning false");
            return false;
        }
        String jumpPoints = map.get(finalPoint);
        String[] jumpPointsArr = jumpPoints.split(",");
        int val = 0;
        for(String str: jumpPointsArr){
            val = Integer.parseInt(str);
            if(val==0){
                System.out.println("Found starting, successful path found, returning true for val = "+val);
                bol = true;
            } else{
                bol = recursion(map, val);
            }
        }
        System.out.println("finalPoint = "+finalPoint +", jumpPoints = "+jumpPoints + ", bol = " + bol);
        return bol;
    }*/

}
