package com.shrek.leetCode._006_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * You are given an array of non-overlapping intervals
 * intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval
 * and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
 * and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 *
 * Hint 1
 * Intervals Array is sorted. Can you use Binary Search to find the correct position to insert the new Interval.?
 * Hint 2
 * Can you try merging the overlapping intervals while inserting the new interval?
 * Hint 3
 * This can be done by comparing the end of the last interval with the start of the new interval and vice versa.
 *
 */

public class _050M_InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {6,9}};
        int[] newInterval = new int[]{2,5};
        System.out.println("insertInterval for intervals = " + Arrays.toString(intervals) + " and newInterval = "+newInterval+" is ");
        int[][] matrix = insertInterval(intervals, newInterval);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print( matrix[i][j] + " " );
            }
            System.out.println();
        }
        //  [[1,5],[6,9]]
        System.out.println("-------------- BREAK -----------------");

        intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        newInterval = new int[]{4,8};
        System.out.println("insertInterval for intervals = " + Arrays.toString(intervals) + " and newInterval = "+newInterval+" is ");
        matrix = insertInterval(intervals, newInterval);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print( matrix[i][j] + " " );
            }
            System.out.println();
        }
        //  [[1,2],[3,10],[12,16]]
        System.out.println("-------------- BREAK -----------------");

        intervals = new int[][]{};
        newInterval = new int[]{5,7};
        System.out.println("insertInterval for intervals = " + Arrays.toString(intervals) + " and newInterval = "+newInterval+" is ");
        matrix = insertInterval(intervals, newInterval);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print( matrix[i][j] + " " );
            }
            System.out.println();
        }
        //  [[5,7]]
        System.out.println("-------------- BREAK -----------------");

        intervals = new int[][]{{1,5}};
        newInterval = new int[]{2,7};
        System.out.println("insertInterval for intervals = " + Arrays.toString(intervals) + " and newInterval = "+newInterval+" is ");
        matrix = insertInterval(intervals, newInterval);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print( matrix[i][j] + " " );
            }
            System.out.println();
        }
        //  [[1,7]]
        System.out.println("-------------- BREAK -----------------");


    }

    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ll = new ArrayList<int[]>();

        if(n<1){
            return new int[][]{newInterval};
        }

        boolean added = false;
        for(int i=0;i<n;i++){
            if(newInterval[0]<intervals[i][0] && added==false){
                ll.add(newInterval);
                ll.add(intervals[i]);
                added = true;
            } else {
                ll.add(intervals[i]);
            }
        }
        if(added==false){
            ll.add(newInterval);
        }

        for(int i=0;i<ll.size();i++){
            System.out.println(Arrays.toString(ll.get(i)));
        }

        List<int[]> llMerged = new ArrayList<int[]>();
        int[] prev = ll.get(0);
        for(int i=1;i<ll.size();i++){
            int[] curr = ll.get(i);
            if(prev[1] < curr[0]){
                llMerged.add(prev);
                prev = curr;
            } else if(prev[1] >= curr[0]){
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }
        llMerged.add(prev);

        /*for(int i=0;i< llMerged.size();i++){
            System.out.println(Arrays.toString(llMerged.get(i)));
        }*/

        return llMerged.toArray(new int[llMerged.size()][]);
    }

}
