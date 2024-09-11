package com.shrek.leetCode._001_ArraysStrings;

import java.util.Arrays;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 */

public class _008M_BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        int[] nums1 = {7,1,5,3,6,4};
        System.out.println("-------- TESTING FOR "+Arrays.toString(nums1)+" ---------");
        int expectedOutputForNum1 = 7;
        int actualOutputForNum1= maxProfit(nums1);
        if(expectedOutputForNum1 == actualOutputForNum1){
            System.out.println();
            System.out.println("--------- CORRECT test case 1 for "+ Arrays.toString(nums1) +" -----------");
            System.out.println();
        } else{
            System.out.println();
            System.out.println("--------- Incorrect test case 1 for "+ Arrays.toString(nums1) +" , expectedOutputForNum1 = "+expectedOutputForNum1 +" , actualOutputForNum1 "+ actualOutputForNum1+"-----------");
            System.out.println();
        }

        int[] nums2 = {1,2,3,4,5};
        System.out.println("-------- TESTING FOR "+Arrays.toString(nums2)+" ---------");
        int expectedOutputForNum2 = 4;
        int actualOutputForNum2= maxProfit(nums2);
        if(expectedOutputForNum2 == actualOutputForNum2){
            System.out.println();
            System.out.println("--------- CORRECT test case 2 for "+ Arrays.toString(nums2) +" -----------");
            System.out.println();
        } else{
            System.out.println();
            System.out.println("--------- Incorrect test case 2 for "+ Arrays.toString(nums2) +" , expectedOutputForNum2 = "+expectedOutputForNum2 +" , actualOutputForNum2 "+ actualOutputForNum2+"-----------");
            System.out.println();
        }

        int[] nums3 = {7,6,4,3,1};
        System.out.println("-------- TESTING FOR "+Arrays.toString(nums3)+" ---------");
        int expectedOutputForNum3 = 0;
        int actualOutputForNum3= maxProfit(nums3);
        if(expectedOutputForNum3 == actualOutputForNum3){
            System.out.println();
            System.out.println("--------- CORRECT test case 3 for "+ Arrays.toString(nums3) +" -----------");
            System.out.println();
        } else{
            System.out.println();
            System.out.println("--------- Incorrect test case 3 for "+ Arrays.toString(nums3) +" , expectedOutputForNum3 = "+expectedOutputForNum3 +" , actualOutputForNum3 "+ actualOutputForNum3+"-----------");
            System.out.println();
        }


        int[] nums4 = {1,2};
        System.out.println("-------- TESTING FOR "+Arrays.toString(nums4)+" ---------");
        int expectedOutputForNum4 = 1;
        int actualOutputForNum4= maxProfit(nums4);
        if(expectedOutputForNum4 == actualOutputForNum4){
            System.out.println();
            System.out.println("--------- CORRECT test case 4 for "+ Arrays.toString(nums4) +" -----------");
            System.out.println();
        } else{
            System.out.println();
            System.out.println("--------- Incorrect test case 4 for "+ Arrays.toString(nums4) +" , expectedOutputForNum3 = "+expectedOutputForNum4 +" , actualOutputForNum3 "+ actualOutputForNum4+"-----------");
            System.out.println();
        }


        int[] nums5 = {2,1,4};
        System.out.println("-------- TESTING FOR "+Arrays.toString(nums5)+" ---------");
        int expectedOutputForNum5 = 3;
        int actualOutputForNum5= maxProfit(nums5);
        if(expectedOutputForNum5 == actualOutputForNum5){
            System.out.println();
            System.out.println("--------- CORRECT test case 5 for "+ Arrays.toString(nums5) +" -----------");
            System.out.println();
        } else{
            System.out.println();
            System.out.println("--------- Incorrect test case 5 for "+ Arrays.toString(nums5) +" , expectedOutputForNum3 = "+expectedOutputForNum5 +" , actualOutputForNum3 "+ actualOutputForNum5+"-----------");
            System.out.println();
        }
        /*for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }*/
    }


    public static int maxProfit(int[] prices) {
        // online solution using greedy approach,
        // The clue was to en-cash everyday when stock price rises up
        int max = 0;
        int start = prices[0];
        int len = prices.length;
        for(int i = 1;i<len; i++){
            if(start < prices[i]){
                max += prices[i] - start;
            }
            start = prices[i];
        }
        return max;

        // My own solution
        /*int n = prices.length;
        if(n<1){
            return 0;
        }
        if(n==2 && prices[0]<prices[1]){
            return prices[1]-prices[0];
        }
        int maxProfit = 0;
        int buyPtr = 0;
        boolean bull=false;
        int diff;
        for(int i=1;i<n;i++){
            if( prices[i] > prices[buyPtr] && bull==false && (i!=n-1) ){
                bull = true;
            } else if( prices[i] > prices[buyPtr] && bull==false && (i==n-1) ){
                diff = prices[i] - prices[buyPtr];
                maxProfit += diff;
                bull = true;
            } else if( bull==true && i==n-1 ){
                if(prices[i] < prices[i-1]){
                    diff = prices[i-1] - prices[buyPtr];
                } else{
                    diff = prices[i] - prices[buyPtr];
                }
                maxProfit += diff;
            } else if( bull==true && prices[i] < prices[i-1] ){
                diff = prices[i-1] - prices[buyPtr];
                maxProfit += diff;
                bull = false;
                buyPtr = i;
            } else if(prices[i] < prices[buyPtr]){
                buyPtr = i;
            }
        }
        return maxProfit;*/
    }
}
