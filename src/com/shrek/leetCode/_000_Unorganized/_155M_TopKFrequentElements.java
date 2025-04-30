package com.shrek.leetCode._000_Unorganized;

/*

Attention Is All You Need

Scenario:

You are a Software Engineer at Instagram (Meta) and have been tasked with designing a data structure that can efficiently predict the next video a user is likely to watch based on their past viewing patterns. Instead of using deep learning, your goal is to develop a system that mimics similar behavior by leveraging frequency-based heuristics.

Problem Statement:

You are given a stream of watched videos in chronological order.
You are also provided with a list of specific times of the day (TOD) at which predictions need to be made.
Your data structure should predict the next video the user is likely to watch based on video frequency patterns while prioritizing recency in case of ties.

Example:
Input:

Stream of videos: [1, 2, 2, 4, 5, 3, 2, 3, 3, 3]
TOD: [5, 7, 10]

o/p = [2,2,3]

Scenario:

Your initial system has successfully been predicting the next video
a user is likely to watch based on historical viewing patterns.
Now, the system has matured and aims to provide a more advanced recommendation feature.

New Requirement:

Instead of predicting a single next video,
your algorithm must now predict the top 5 videos a user is most likely to watch next.
The predictions should be based on
frequency of previously watched videos, with recency as a tiebreaker.
You are given a list of times of the day (TOD),
and for each time in the list,
you need to determine the top 5 recommended videos.

Example:
Input:
Stream of videos: [1, 2, 2, 4, 5, 3, 2, 3, 3, 3]
TOD: [5, 7, 10]

Output:

[
  [2, 5, 4, 1], // Top 5 predictions for TOD = 5
  [2, 3, 5, 4, 1], // Top 5 predictions for TOD = 7
  [3, 2, 5, 4, 1] // Top 5 predictions for TOD = 10
]

*/

import java.util.*;

/**
 *
 * Given an integer array nums and an integer k,
 * return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 *
 */

public class _155M_TopKFrequentElements {

    public static void main(String args[] ) throws Exception {
        int[] numbers = {1,1,1,2,2,3};
        int target = 2;
        System.out.println("topKFrequent for numbers = " + Arrays.toString(numbers) + " , target = " + target + " , = "+ Arrays.toString( topKFrequent(target, numbers) ));
        // [1,2]

        System.out.println("-------------- BREAK -----------------");
        numbers = new int[]{1};
        target = 1;
        System.out.println("topKFrequent for numbers = " + Arrays.toString(numbers) + " , target = " + target + " , = "+ Arrays.toString( topKFrequent(target, numbers) ));
        // [1]

        System.out.println("-------------- BREAK -----------------");
        numbers = new int[]{1, 2, 2, 4, 5};
        target = 5;
        System.out.println("topKFrequent for numbers = " + Arrays.toString(numbers) + " , target = " + target + " , = "+ Arrays.toString( topKFrequent(target, numbers) ));
        // [2, 5, 4, 1]

        System.out.println("-------------- BREAK -----------------");
        numbers = new int[]{1, 2, 2, 4, 5, 3, 2};
        target = 5;
        System.out.println("topKFrequent for numbers = " + Arrays.toString(numbers) + " , target = " + target + " , = "+ Arrays.toString( topKFrequent(target, numbers) ));
        // [2, 3, 5, 4, 1]

        System.out.println("-------------- BREAK -----------------");
        numbers = new int[]{1, 2, 2, 4, 5, 3, 2, 3, 3, 3};
        target = 5;
        System.out.println("topKFrequent for numbers = " + Arrays.toString(numbers) + " , target = " + target + " , = "+ Arrays.toString( topKFrequent(target, numbers) ));
        // [3, 2, 5, 4, 1]

    }

    // optimal solution O(n) using bucket sort
    public static int[] topKFrequent(int k, int[] nums) {
        int n = nums.length;

        if(n==k){
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] buckets = new List[n +  1];
        for(int i=0;i<buckets.length;i++){
            buckets[i] = new ArrayList<>();
        }
        for(int key: map.keySet()){
            int freq = map.get(key);
            buckets[freq].add(key);
        }
        // System.out.println(Arrays.toString(buckets));

        List<Integer> flattenedList = new ArrayList<>();
        for(int i= buckets.length-1;i>=0;i--){
            for(int num: buckets[i]){
                flattenedList.add(num);
            }
        }
        // System.out.println(flattenedList.toString());

        int[] op = new int[k];
        for(int i=0;i<k;i++){
            op[i] = flattenedList.get(i);
        }
        return op;
    }

    // better solution using Heap for k elements
    /*public static int[] topKFrequent(int k, int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>(
            (i, j) -> map.get(i) - map.get(j)
        );
        for(int i: map.keySet()){
            heap.add(i);
            if(heap.size()>k){
                heap.poll();
            }
        }
        //System.out.println(heap.toString());

        int[] op = new int[k];
        int i = k-1;
        while(!heap.isEmpty()){
            System.out.println(heap.peek());
            op[i] = heap.poll();
            i--;
        }
        return op;
    }*/

    // Brute Force
    /*public static int[] topKFrequent(int k, int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<List<Integer>> ll = new ArrayList<>();
        for(Integer i: map.keySet()){
            List<Integer> tl = new ArrayList<>();
            tl.add(map.get(i));
            tl.add(i);
            ll.add(tl);
        }
        ll.sort((i, j) -> j.get(0) - i.get(0));
        System.out.println(ll.toString());
        int[] op = new int[k];
        for(int i=0;i<k;i++){
            if(! (ll.size()-1<i)){
                op[i] = ll.get(i).get(1);
            }
        }
        return op;
    }*/

}
