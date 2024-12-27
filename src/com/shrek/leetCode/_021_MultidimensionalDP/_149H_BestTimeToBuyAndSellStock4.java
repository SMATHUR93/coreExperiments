package com.shrek.leetCode._021_MultidimensionalDP;

import java.util.Arrays;

/**
 *
 * You are given an integer array prices where prices[i]
 * is the price of a given stock on the ith day, and an integer k.
 *
 * Find the maximum profit you can achieve.
 * You may complete at most k transactions:
 * i.e. you may buy at most k times and sell at most k times.
 *
 * Note: You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: k = 2,
 * prices = [2,4,1]
 * Output: 2
 * Explanation:
 * Buy on day 1 (price = 2)
 * and sell on day 2 (price = 4),
 * profit = 4-2 = 2.
 *
 * Example 2:
 * Input: k = 2,
 * prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation:
 * Buy on day 2 (price = 2)
 * and sell on day 3 (price = 6),
 * profit = 6-2 = 4.
 * Then buy on day 5 (price = 0)
 * and sell on day 6 (price = 3),
 * profit = 3-0 = 3.
 *
 * Constraints:
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 *
 */

public class _149H_BestTimeToBuyAndSellStock4 {

    public static void main(String[] args) {
        int[] prices;
        int k;

        prices = new int[]{2,4,1};
        k = 2;
        System.out.println("maxProfit for prices = "+ Arrays.toString(prices) +" , equals "+ maxProfit(k, prices));
        // 2
        System.out.println();

        prices = new int[]{3,2,6,5,0,3};
        k = 2;
        System.out.println("maxProfit for prices = "+ Arrays.toString(prices) +" , equals "+ maxProfit(k, prices));
        // 7
        System.out.println();

    }

    // DP with Tabulation best case
    public static int maxProfit(int transactionLimit, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][transactionLimit+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<transactionLimit+1;k++){
                    dp[i][j][k] = 0;
                    // in tabular dp, putting the initi value as zero covers all starting index as we are already mapping base cases and starting from next state indexes.
                    // dp[i][j][k] = -1;
                }
            }
        }

        // Base case can be ignored in tabular if initialization is done using zero for all dp matrix
        /*for(int i=0;i<n+1;i++){
            for(int j=0;j<2;j++){
                dp[i][j][0] = 0;
            }
        }

        for(int j=0;j<2;j++){
            for(int k=0;k<transactionLimit+1;k++){
                dp[n][j][k] = 0;
            }
        }*/

        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<2;buy++){
                // since non buy case idx goes -ve and 0 transaction cap is already put as zero
                for(int transactionNumber=1;transactionNumber<transactionLimit+1;transactionNumber++){
                    //System.out.println("Checking all params, idx = "+idx+", buy = "+buy+" , transactionNumber =  "+transactionNumber);
                    if(buy==1){
                        dp[idx][buy][transactionNumber] = Math.max(
                                -prices[idx] + dp[idx+1][0][transactionNumber],
                                0 + dp[idx+1][1][transactionNumber]
                        );
                    } else{
                        dp[idx][buy][transactionNumber] = Math.max(
                                prices[idx] + dp[idx+1][1][transactionNumber-1],
                                0 + dp[idx+1][0][transactionNumber]
                        );
                    }
                }
            }
        }

        return dp[0][1][transactionLimit];
    }

    // Recursion with Memoization
    /*public static int maxProfit(int transactionLimit, int[] prices) {
        int[][][] dp = new int[prices.length][2][transactionLimit+1];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<transactionLimit+1;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return rec(prices, 0, 1, transactionLimit, dp);
    }

    public static int rec(int[] prices, int idx, int buy, int transactionNumber, int[][][] dp){
        // System.out.println("Checking all params, idx = "+idx+", buy = "+buy+" , transactionNumber =  "+transactionNumber);
        if(idx==prices.length){
            return 0;
        }
        if(transactionNumber==0){
            return 0;
        }
        if(dp[idx][buy][transactionNumber]!=-1){
            return dp[idx][buy][transactionNumber];
        }
        int profit = 0;
        if(buy==1){
            profit = Math.max(
                    -prices[idx] + rec(prices, idx+1, 0, transactionNumber, dp),
                    0 + rec(prices, idx+1, 1, transactionNumber, dp)
            );
        } else{
            profit = Math.max(
                    prices[idx] + rec(prices, idx+1, 1, transactionNumber-1, dp),
                    0 + rec(prices, idx+1, 0, transactionNumber, dp)
            );
        }
        return dp[idx][buy][transactionNumber] = profit;
    }*/

    // Basic Recursive Solution
    /*public static int maxProfit(int k, int[] prices) {
        return rec(prices, 0, 1, k);
    }

    public static int rec(int[] prices, int idx, int buy, int transactionNumber){
        if(idx==prices.length){
            return 0;
        }
        if(transactionNumber==0){
            return 0;
        }
        int profit = 0;
        if(buy==1){
            profit = Math.max(
                    -prices[idx] + rec(prices, idx+1, 0, transactionNumber),
                    0 + rec(prices, idx+1, 1, transactionNumber)
            );
        } else{
            profit = Math.max(
                    prices[idx] + rec(prices, idx+1, 1, transactionNumber-1),
                    0 + rec(prices, idx+1, 0, transactionNumber)
            );
        }
        return profit;
    }*/

}
