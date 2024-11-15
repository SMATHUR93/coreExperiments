package com.shrek.leetCode._016_BinarySearch;

import java.util.Arrays;

/**
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 */

public class _119H_MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1, nums2;

        nums1 = new int[]{1,3};
        nums2 = new int[]{2};
        System.out.println("findMin for nums1 = "+ Arrays.toString(nums1) + " ,and nums2 = " + Arrays.toString(nums2) +" , equals "+findMedianSortedArrays(nums1, nums2));
        // 2.00000
        System.out.println();

        nums1 = new int[]{1,2};
        nums2 = new int[]{3,4};
        System.out.println("findMin for nums1 = "+ Arrays.toString(nums1) + " ,and nums2 = " + Arrays.toString(nums2) +" , equals "+findMedianSortedArrays(nums1, nums2));
        // 2.50000
        System.out.println();

    }

    // binary search
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partitionA - 1];
            int minRightA = (partitionA == m)
                    ? Integer.MAX_VALUE
                    : nums1[partitionA];
            int maxLeftB = (partitionB == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partitionB - 1];
            int minRightB = (partitionB == n)
                    ? Integer.MAX_VALUE
                    : nums2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (
                            (Math.max(maxLeftA, maxLeftB) +
                                    Math.min(minRightA, minRightB)) /
                                    2.0
                    );
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }
        }
        return 0.0;
    }

    // my solution starigh forward merging, beats in tspace complexity
    /*public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] combined = new int[m+n];
        int p=m-1;
        int q=n-1;
        int el=0;
        for(int k=m+n-1;k>=0;k--){
            if(q<0 && p>=0){
                el = nums1[p];
                p--;
            } else if(p<0 && q>=0){
                el = nums2[q];
                q--;
            } else if(nums1[p]>nums2[q]){
                el = nums1[p];
                p--;
            } else if(nums1[p]<=nums2[q]){
                el = nums2[q];
                q--;
            }
            combined[k] = el;
        }
        int mid = (m+n-1)/2;
        double median = combined[mid];
        if(combined.length%2==0){
            median = (double) (combined[mid] + combined[mid+1] )/ 2.0;
        }
        return median;
    }*/

}
