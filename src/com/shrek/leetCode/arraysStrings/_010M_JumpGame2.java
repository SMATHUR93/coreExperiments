package com.shrek.leetCode.arraysStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 */

public class _010M_JumpGame2 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        // int[] nums = {3,2,1,0,4};
        System.out.println(Arrays.toString(nums));
        System.out.println(jump(nums));
        /*for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }*/
    }

    // O(n) best solution using greedy approach
    public static int jump(int[] arr) {
        int n = arr.length;
        if(n<=1){
            return 0;
        }
        if(arr[0]>=n-1){
            return 1;
        }
        if(arr[0]==0){
            return -1;
        }
        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;
        for(int i = 1;i < n;i++){
            if(i==(n - 1)){
                return jumps;
            }
            if( (i + arr[i]) >= (n - 1)){
                return jumps + 1;
            }
            if( (i + arr[i]) > maxReach){
                maxReach = (i + arr[i]);
            }
            steps--;
            if(steps==0){
                jumps++;
                if(i >= maxReach){
                    return -1;
                }
                steps = maxReach - i;
            }
        }
        return -1;
    }

    // Solution of moving goal by recursion, still is space complex of O(n2)
    /*public static int jump(int[] nums) {
        int n = nums.length;
        int goal = n - 1;
        int jump = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
                jump++;
            }
        }

        return goal == 0 ? jump : 0;
    }*/

    // My Solution: couldn't break time complexity
    /*public static boolean jump(int[] nums) {
        int n = nums.length;
        int jump;
        int step;
        Map<Integer, String> map = new HashMap<Integer, String>();
        for(int i=0;i<n;i++){
            jump = nums[i];
            // System.out.println("i = "+i +", jump = "+jump);
            if((jump==0 || i==(n-1)) ){

            } else {
                for(int j=1;j<=jump;j++){
                    step = i+j;
                    // System.out.println("i = "+i +", j = "+j+", step = "+step);
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
        finalPoint = n-1;
        boolean val = recursion( map, finalPoint);
        System.out.println("Value fof recursion is "+ val);
        return val;
    }

    public static int maxJumpCount = 0;
    public static int jumpCount = 0;
    public static int finalPoint = 0;

    public static boolean recursion(Map<Integer, String> map, int point){
        boolean bol = false;
        if(!map.containsKey(point)){
            System.out.println("Reaching nowhere, returning false");
            return false;
        } else if(point==finalPoint){
            jumpCount = 0;
        }
        String jumpPoints = map.get(point);
        String[] jumpPointsArr = jumpPoints.split(",");
        int val = 0;
        System.out.println("finalPoint = "+point +", jumpPoints = "+jumpPoints);
        for(String str: jumpPointsArr){
            val = Integer.parseInt(str);
            if(val==0) {
                // jumpCount++;
                if(jumpCount+1>maxJumpCount){
                    maxJumpCount = jumpCount+1;
                }
                System.out.println("Found starting "+val+" node, successful path found, with length = "+ (jumpCount+1) +" & max Jump Count = "+ maxJumpCount);
                bol = true;
                jumpCount--;
            } else {
                jumpCount++;
                System.out.println("Found "+val+" path node with length = "+jumpCount +" & max Jump Count = "+ maxJumpCount);
                bol = recursion(map, val);
            }
        }
        // System.out.println("finalPoint = "+point +", jumpPoints = "+jumpPoints + ", bol = " + bol);
        return bol;
    }*/

}
