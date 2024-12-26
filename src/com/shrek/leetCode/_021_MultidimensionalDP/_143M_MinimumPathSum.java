package com.shrek.leetCode._021_MultidimensionalDP;

import java.util.Arrays;

/**
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 *
 */

public class _143M_MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid;

        grid = new int[][]{
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println("minPathSum for grid = "+ Arrays.toString(grid)+" , equals "+minPathSum(grid));
        // 7
        System.out.println();

        grid = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println("minPathSum for grid = "+ Arrays.toString(grid)+" , equals "+minPathSum(grid));
        // 12
        System.out.println();

    }

    // 2D tabulation method, processing bottom-up
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j!=n-1){
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                } else if(j==n-1 && i!=m-1){
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                } else if(j!=n-1 && i!=m-1){
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                } else{
                    dp[i][j] = grid[i][j];
                }
            }
        }

        return dp[0][0];
    }

    // Basic Recursive solution
    /*public static int minPathSum(int[][] grid) {
        return calculate(grid, 0, 0);
    }

    public static int calculate(int[][] grid, int i, int j){
        if(i==grid.length || j==grid[0].length ){
            return Integer.MAX_VALUE;
        }
        if(i==grid.length-1 && j==grid[0].length-1 ){
            return grid[i][j];
        }
        return (
                grid[i][j] +
                        Math.min(calculate(grid, i+1, j), calculate(grid, i, j+1))
        );
    }*/

}
