package com.shrek.leetCode._020_1D_DP;

/**
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Constraints:
 * 1 <= n <= 45
 *
 * Hint 1
 * To reach nth step, what could have been your previous steps? (Think about the step sizes)
 *
 */

public class _137E_ClimbingStairs {

    public static void main(String[] args) {
        int n;

        n = 2;
        System.out.println("climbStairs for n = "+n+" , equals "+climbStairs(n));
        // 2
        System.out.println();

        n = 3;
        System.out.println("climbStairs for n = "+n+" , equals "+climbStairs(n));
        // 3
        System.out.println();

    }

    // memoization using 1-D table
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 2;
        for(int i=3;i<=n;i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

    // memoization using recursion
    /*public static int climbStairs(int n) {
        int[] memo = new int[n+1];
        return climbStairsRec(0, n, memo);
    }

    public static int climbStairsRec(int start, int total, int[] memo){
        if(start>total){
            return 0;
        }
        if(start==total){
            return 1;
        }
        if (memo[start] > 0) {
            return memo[start];
        }
        memo[start] = climbStairsRec(start+1, total, memo)+climbStairsRec(start+2, total, memo);
        return memo[start];
    }*/

    // Naive approach
    /*public static int climbStairs(int n) {
        return climbStairsRec(0, n);
    }

    public static int climbStairsRec(int start, int total){
        if(start>total){
            return 0;
        }
        if(start==total){
            return 1;
        }
        return climbStairsRec(start+1, total)+climbStairsRec(start+2, total);
    }*/

}
