package com.shrek.leetCode._004_Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * Hint 1
 * Well for some problems, the best way really is to come up with some algorithms for simulation.
 * Basically, you need to simulate what the problem asks us to do.
 *
 * Hint 2
 * We go boundary by boundary and move inwards.
 * That is the essential operation.
 * First row, last column, last row, first column, and then we move inwards by 1 and repeat.
 * That's all. That is all the simulation that we need.
 *
 * Hint 3
 * Think about when you want to switch the progress on one of the indexes.
 * If you progress on i out of [i, j], you'll shift in the same column.
 * Similarly, by changing values for j, you'd be shifting in the same row.
 * Also, keep track of the end of a boundary so that you can move inwards and then keep repeating.
 * It's always best to simulate edge cases like a single column or a single row to see if anything breaks or not.
 *
 */

public class _035M_SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        System.out.println("spiralOrder for matrix = " + matrix + " == " + spiralOrder(matrix) );
        // [1,2,3,6,9,8,7,4,5]
        System.out.println("-------------- BREAK -----------------");
        matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };
        System.out.println("spiralOrder for matrix = " + matrix + " == " + spiralOrder(matrix) );
        // [1,2,3,4,8,12,11,10,9,5,6,7]
        System.out.println("-------------- BREAK -----------------");
    }

    // Trick is to continue updating up, down, left, right
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ll = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = columns - 1;
        int down = rows - 1;
        int n = rows*columns;
        while(ll.size() < n){
            for(int i = left; i <= right; i++){
                ll.add(matrix[up][i]);
            }
            for(int i = up + 1; i <= down; i++){
                ll.add(matrix[i][right]);
            }
            if (up != down) {
                for (int i = right - 1; i >= left; i--) {
                    ll.add(matrix[down][i]);
                }
            }
            if (left != right) {
                for (int i = down - 1; i > up; i--) {
                    ll.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return ll;
    }

}
