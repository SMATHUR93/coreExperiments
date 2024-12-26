package com.shrek.leetCode._016_BinarySearch;

import java.util.Arrays;

/**
 *
 * You are given an m x n integer matrix matrix with the following two properties:
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 *
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 *  Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 */

public class _115M_Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix;
        int target;

        matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        target = 3;
        System.out.println("searchMatrix for nums = "+ Arrays.toString(matrix) +" , target = "+target+" , equals "+searchMatrix(matrix, target));
        // true
        System.out.println();

        matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        target = 13;
        System.out.println("searchMatrix for nums = "+ Arrays.toString(matrix) +" , target = "+target+" , equals "+searchMatrix(matrix, target));
        // false
        System.out.println();

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i=0;
        int left, right, mid;
        while(i<m){
            if(target>matrix[i][0] && target<matrix[i][n-1]){
                left = 0;
                right = n-1;
                while(left<=right){
                    mid = left + (right-left)/2;
                    if(matrix[i][mid]==target){
                        return true;
                    }
                    if(matrix[i][mid]<target){
                        left = mid+1;
                    } else {
                        right = mid-1;
                    }
                }
            } else if(target==matrix[i][0] || target==matrix[i][n-1]){
                return true;
            }
            i++;
        }
        return false;
    }

}
