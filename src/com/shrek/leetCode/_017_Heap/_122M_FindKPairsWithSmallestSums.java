package com.shrek.leetCode._017_Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 *
 * Example 1:
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 * Example 2:
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 105
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1 and nums2 both are sorted in non-decreasing order.
 * 1 <= k <= 104
 * k <= nums1.length * nums2.length
 *
 */

public class _122M_FindKPairsWithSmallestSums {

    public static void main(String[] args) {
        int[] nums1;
        int[] nums2;
        int k;

        nums1 = new int[]{1,7,11};
        nums2 = new int[]{2,4,6};
        k = 3;
        System.out.println("searchRange for nums1 = "+ Arrays.toString(nums1)+" , nums2 = "+ Arrays.toString(nums2) + " and k = "+k+" , equals "+kSmallestPairs(nums1, nums2, k));
        // [[1,2],[1,4],[1,6]]
        System.out.println();

        nums1 = new int[]{1,1,2};
        nums2 = new int[]{1,2,3};
        k = 2;
        System.out.println("searchRange for nums1 = "+ Arrays.toString(nums1)+" , nums2 = "+ Arrays.toString(nums2) + " and k = "+k+" , equals "+kSmallestPairs(nums1, nums2, k));
        // [[1,1],[1,1]]
        System.out.println();

        nums1 = new int[]{1,2,4,5,6};
        nums2 = new int[]{3,5,7,9};
        k = 3;
        System.out.println("searchRange for nums1 = "+ Arrays.toString(nums1)+" , nums2 = "+ Arrays.toString(nums2) + " and k = "+k+" , equals "+kSmallestPairs(nums1, nums2, k));
        // [[1,3],[2,3],[1,5]]
        System.out.println();

    }

    // Logic is to create a priority queue with inital sets from arr1 and 1st el of arr2,
    // then we moving to next element for EACH SET in queue while maintaining logical order
    // by saving them in priorityQueue min heap, this way sets with least value are processed first
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> op = new ArrayList<>();
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b)->( (a[0]+a[1]) - (b[0]+b[1]) ));
        for(int i=0;i<nums1.length && i<k;i++){
            queue.offer( new Integer[]{nums1[i], nums2[0], 0} );
        }
        System.out.println("START:: INIT queue");
        for(Integer[] ptr:queue){
            System.out.println(Arrays.toString(ptr));
        }
        System.out.println("ENDLL:: INIT queue");
        while(k-->0 && !queue.isEmpty()){
            Integer[] arr = queue.poll();
            System.out.println("DEBUGGING k = "+k+" , and polled element = "+Arrays.toString(arr));
            op.add(Arrays.asList(arr[0], arr[1]));
            if(arr[2]==nums2.length-1){
                continue;
            }
            queue.offer(new Integer[]{arr[0], nums2[arr[2]+1], arr[2]+1});
            System.out.println("   START:: Checking queue");
            for(Integer[] ptr:queue){
                System.out.println("            "+Arrays.toString(ptr));
            }
            System.out.println("  ENDLL:: Checking queue");
        }
        return op;
    }

}
