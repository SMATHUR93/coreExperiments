package com.shrek.leetCode._021_MultidimensionalDP;

import java.util.Arrays;

/**
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve.
 * You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 *
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later,
 * as you are engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 105
 *
 */

public class _148H_BestTimeToBuyAndSellStock3 {

    public static void main(String[] args) {
        int[] prices;

        prices = new int[]{3,3,5,0,0,3,1,4};
        System.out.println("maxProfit for prices = "+ Arrays.toString(prices) +" , equals "+ maxProfit(prices));
        // 6
        System.out.println();

        prices = new int[]{1,2,3,4,5};
        System.out.println("maxProfit for prices = "+ Arrays.toString(prices) +" , equals "+ maxProfit(prices));
        // 4
        System.out.println();

        prices = new int[]{7,6,4,3,1};
        System.out.println("maxProfit for prices = "+ Arrays.toString(prices) +" , equals "+ maxProfit(prices));
        // 0
        System.out.println();

    }

    // DP with Tabulation best case
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
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
            for(int k=0;k<3;k++){
                dp[n][j][k] = 0;
            }
        }*/

        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<2;buy++){
                // since non buy case idx goes -ve and 0 transaction cap is already put as zero
                for(int transactionNumber=1;transactionNumber<3;transactionNumber++){
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

        return dp[0][1][2];
    }

    // Recursion with Memoization
    /*public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return rec(prices, 0, 1, 2, dp);
    }

    int rec(int[] prices, int idx, int buy, int transactionNumber, int[][][] dp){
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
    /*public int maxProfit(int[] prices) {
        return rec(prices, 0, 1, 2);
    }

    int rec(int[] prices, int idx, int buy, int transactionNumber){
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
