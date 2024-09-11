package com.shrek.leetCode._001_ArraysStrings;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */

public class _007E_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
        /*for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }*/
    }


    public static int maxProfit(int[] prices) {
        int n = prices.length;

        if(n<2){
            return 0;
        }

        int i=0;
        int diff;
        int maxProfit = 0;

        for(int j=1;j<n;j++){
            if(prices[i] < prices[j]){
                diff = prices[j] - prices[i];
                if(diff>maxProfit){
                    maxProfit = diff;
                }
            } else{
                i = j;
            }
        }

        /*int[] leftArr = new int[n];
        int[] rightArr = new int[n];
        int maxProfit = 0;

        leftArr[0] = prices[0];
        for(int i=1;i<n;i++){
            if(prices[i]<leftArr[i-1]){
                leftArr[i] = prices[i];
            } else{
                leftArr[i] = leftArr[i-1];
            }
        }
        System.out.println("leftArr = "+ Arrays.toString(leftArr));

        rightArr[n-1] = prices[n-1];
        for(int i=n-2;i>=0;i--){
            if(prices[i]>rightArr[i+1]){
                rightArr[i] = prices[i];
            } else{
                rightArr[i] = rightArr[i+1];
            }
        }
        System.out.println("rightArr = "+Arrays.toString(rightArr));

        for(int k=0;k<n;k++){
            if( (rightArr[k]-leftArr[k]) > maxProfit){
                maxProfit = (rightArr[k]-leftArr[k]);
            }
        }*/
        return maxProfit;
    }

}
