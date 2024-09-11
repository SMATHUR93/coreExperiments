package com.shrek.leetCode._006_Intervals;

import java.util.*;

/**
 *
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 */

public class _049M_MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{15,18}, {1,3}, {2,6}, {8,10}, {4,7}};
        System.out.println("mergeIntervals for intervals = " + Arrays.toString(intervals) + " is ");
        int[][] matrix = merge(intervals);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print( matrix[i][j] + " " );
            }
            System.out.println();
        }
        //  [[1,6],[8,10],[15,18]]
        System.out.println("-------------- BREAK -----------------");

        intervals = new int[][]{{1,4},{4,5}};
        System.out.println("mergeIntervals for intervals = " + Arrays.toString(intervals) + " is ");
        matrix = merge(intervals);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print( matrix[i][j] + " " );
            }
            System.out.println();
        }
        //  [[1,5]]
        System.out.println("-------------- BREAK -----------------");
        intervals = new int[][]{{1,4},{2,3}};
        System.out.println("mergeIntervals for intervals = " + Arrays.toString(intervals) + " is ");
        matrix = merge(intervals);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print( matrix[i][j] + " " );
            }
            System.out.println();
        }
        //  [[1,4]]
        System.out.println("-------------- BREAK -----------------");
        intervals = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        System.out.println("mergeIntervals for intervals = " + Arrays.toString(intervals) + " is ");
        matrix = merge(intervals);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print( matrix[i][j] + " " );
            }
            System.out.println();
        }
        //  [[1,10]]
        System.out.println("-------------- BREAK -----------------");
    }

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> list =  new ArrayList<int[]>();
        Arrays.sort(intervals, (a, b)->{return (a[0] < b[0]) ? -1 : ((a[0] == b[0]) ? 0 : 1);});

        int[] prev = intervals[0];
        for(int i=1;i<n;i++){
            int[] interval = intervals[i];
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                list.add(prev);
                prev = interval;
            }
        }
        list.add(prev);

        return  list.toArray(new int[list.size()][]);
    }

}
