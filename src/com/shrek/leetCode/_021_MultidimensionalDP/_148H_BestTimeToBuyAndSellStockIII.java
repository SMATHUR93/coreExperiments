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

public class _148H_BestTimeToBuyAndSellStockIII {

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

    public static int maxProfit(int[] prices) {
        return 0;
    }

}