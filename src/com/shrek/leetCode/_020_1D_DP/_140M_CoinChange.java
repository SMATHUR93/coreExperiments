package com.shrek.leetCode._020_1D_DP;

/**
 *
 * You are given an integer array coins representing
 * coins of different denominations and an
 * integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 * Constraints:
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 */

import java.util.Arrays;

public class _140M_CoinChange {

    public static void main(String[] args) {
        int[] coins;
        int amount;

        coins = new int[]{1,2,5};
        amount = 11;
        System.out.println("coinChange for coins = "+Arrays.toString(coins)+" , amount = "+ amount+" , equals "+coinChange(coins, amount));
        // 3
        System.out.println();

        coins = new int[]{2};
        amount = 3;
        System.out.println("coinChange for coins = "+Arrays.toString(coins)+" , amount = "+ amount+" , equals "+coinChange(coins, amount));
        // -1
        System.out.println();

        coins = new int[]{1};
        amount = 0;
        System.out.println("coinChange for coins = "+Arrays.toString(coins)+" , amount = "+ amount+" , equals "+coinChange(coins, amount));
        // 0
        System.out.println();

        coins = new int[]{9,6,5,1};
        amount = 11;
        System.out.println("coinChange for coins = "+Arrays.toString(coins)+" , amount = "+ amount+" , equals "+coinChange(coins, amount));
        // 2
        System.out.println();

    }

    // Finally Tabulation approach
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp =  new int[n][amount+1];

        for(int t=0;t<=amount;t++){
            if(t%coins[0] == 0){
                dp[0][t] = t/coins[0];
            } else{
                dp[0][t] = 999999;
            }
        }

        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int notTake = 0 + dp[i-1][t];
                int take = Integer.MAX_VALUE ;
                if(coins[i] <= t){
                    take = 1 + dp[i][t - coins[i]];
                }
                dp[i][t] = Integer.min(take, notTake);
            }
        }

        int op = dp[n-1][amount];
        return op>=999999? -1: op;
    }

    // DP approach 1 : Memoization
    /*public static int[] coinsArr;
    public static int recCount;
    public static int[][] dp;
    public static int coinChange(int[] coins, int amount) {
        coinsArr =  coins;
        recCount = 0;
        dp =  new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        int op = fun(coins.length-1, amount);
        System.out.println("recCount = " + recCount);
        return op>=99999999? -1: op;
    }
    public static int fun(int idx, int T){
        recCount++;
        if(idx==0){
            if(T % coinsArr[idx]==0){
                return T / coinsArr[idx];
            } else{
                return 99999999;
            }
        }
        if(dp[idx][T]!=-1){
            return dp[idx][T];
        }
        int notTake = 0 + fun(idx-1, T);
        int take = Integer.MAX_VALUE ;
        if(coinsArr[idx] <= T){
            take = 1 + fun(idx, T - coinsArr[idx]);
        }
        dp[idx][T] = Integer.min(take, notTake);
        return dp[idx][T];
    }*/

    // Brute force recursive approach
    /*public static int[] coinsArr;
    public static int recCount;
    public static int coinChange(int[] coins, int amount) {
        coinsArr =  coins;
        recCount = 0;
        int op = fun(coins.length-1, amount);
        System.out.println("recCount = " + recCount);
        return op>=99999999? -1: op;
    }
    public static int fun(int idx, int T){
        recCount++;
        if(idx==0){
            if(T % coinsArr[idx]==0){
                return T / coinsArr[idx];
            } else{
                return 999999;
            }
        }
        int notTake = 0 + fun(idx-1, T);
        int take = Integer.MAX_VALUE ;
        if(coinsArr[idx] <= T){
            take = 1 + fun(idx, T - coinsArr[idx]);
        }
        return Integer.min(take, notTake);
    }*/

}
