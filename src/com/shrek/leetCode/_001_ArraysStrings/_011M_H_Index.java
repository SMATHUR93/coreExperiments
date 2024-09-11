package com.shrek.leetCode._001_ArraysStrings;

import java.util.Arrays;

/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 *
 *
 *
 * Example 1:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * Example 2:
 *
 * Input: citations = [1,3,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 *
 */

public class _011M_H_Index {

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(Arrays.toString(nums));
        System.out.println(hIndex(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{1,2,2};
        System.out.println(Arrays.toString(nums));
        System.out.println(hIndex(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{0,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(hIndex(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{0,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(hIndex(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{0,0,1,0,0,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(hIndex(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{3,0,6,1,5};
        System.out.println(Arrays.toString(nums));
        System.out.println(hIndex(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{9,7,2,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(hIndex(nums));
    }

    /**
     * CORRECT ANSWER
     * The idea behind it is some bucket sort mechanisms.
     * First, you may ask why bucket sort.
     * Well, the h-index is defined as the number of papers with reference greater than the number.
     * So assume n is the total number of papers,
     * if we have n+1 buckets, number from 0 to n,
     * then for any paper with reference corresponding to the index of the bucket,
     * we increment the count for that bucket.
     * The only exception is that for any paper with larger number of reference than n, we put in the n-th bucket.
     * Then we iterate from the back to the front of the buckets,
     * whenever the total count exceeds the index of the bucket,
     * meaning that we have the index number of papers that have reference greater than or equal to the index.
     * Which will be our h-index result.
     * The reason to scan from the end of the array is that we are looking for the greatest h-index.
     * For example, given array [3,0,6,5,1],
     * we have 6 buckets to contain how many papers have the corresponding index.
     * @param arr
     * @return
     */

    public static int hIndex(int[] arr) {
        int nofCitations = arr.length;
        int[] buckets = new int[nofCitations + 1];
        for(int citation: arr){
            if(citation>=nofCitations){
                buckets[nofCitations]++;
            } else{
                buckets[citation]++;
            }
        }
        int count = 0;
        for(int i = nofCitations; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }

    /*public static int hIndex(int[] arr) {
        int n = arr.length;
        if(n<0){
            return 0;
        }
        if(n<=1){
            if(arr[0]>=1){
                return 1;
            } else{
                return 0;
            }
        }
        int idx = 0;
        int minimum = 0;
        if(arr[0]>n){
            idx = n;
        } else{
            idx = arr[0];
        }
        if(arr[0]>0) {
            minimum = 1;
        }
        // System.out.println("n = "+n);
        for(int i=1;i<n;i++){
            System.out.println("i = "+i+" , arr[i] = "+arr[i]+" , idx = "+idx+" , minimum = "+minimum);
            if(arr[i]>idx){
                if(!((idx+1)>n)){
                    if(i==n-1){
                        if(idx==1){
                            System.out.println("NOT INCREMENTING");
                        } else{
                            System.out.println("INCREMENTING");
                            idx++;
                        }
                    } else{
                        System.out.println("INCREMENTING");
                        idx++;
                    }
                }
                if(minimum==0) {
                    minimum = 1;
                }
            } else if (idx != minimum) {
                System.out.println("DECREMENTING");
                idx--;
            }
        }
        return idx;
    }*/
}
