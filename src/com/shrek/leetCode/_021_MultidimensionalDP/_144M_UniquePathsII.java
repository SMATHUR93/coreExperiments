package com.shrek.leetCode._021_MultidimensionalDP;

import java.util.Arrays;

/**
 *
 * You are given an m x n integer array grid.
 * There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 *
 * An obstacle and space are marked as 1 or 0 respectively in grid.
 * A path that the robot takes cannot include any square that is an obstacle.
 *
 * Return the number of possible unique paths
 * that the robot can take to reach the bottom-right corner.
 *
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 *
 * Example 1:
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * Example 2:
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 *
 * Constraints:
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 *
 * Hint 1
 * Use dynamic programming since, from each cell, you can move to the right or down.
 * Hint 2
 * assume dp[i][j] is the number of unique paths to reach (i, j).
 * dp[i][j] = dp[i][j -1] + dp[i - 1][j].
 * Be careful when you encounter an obstacle. set its value in dp to 0.
 *
 */

public class _144M_UniquePathsII {

    public static void main(String[] args) {
        int[][] grid;

        grid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("uniquePathsWithObstacles for grid = "+ Arrays.toString(grid)+" , equals "+uniquePathsWithObstacles(grid));
        // 2
        System.out.println();

        grid = new int[][]{
                {0, 1},
                {0, 0}
        };
        System.out.println("uniquePathsWithObstacles for grid = "+ Arrays.toString(grid)+" , equals "+uniquePathsWithObstacles(grid));
        // 1
        System.out.println();

        grid = new int[][]{
                {0, 0},
                {0, 1}
        };
        System.out.println("uniquePathsWithObstacles for grid = "+ Arrays.toString(grid)+" , equals "+uniquePathsWithObstacles(grid));
        // 0
        System.out.println();

    }

    // Tabulation method
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dp[i][j] = 0;
            }
        }
        if(obstacleGrid[0][0]==1 || obstacleGrid[rows-1][cols-1]==1){
            return 0;
        }

        dp[0][0] = 1;
        for(int i=1;i<rows;i++){
            if(obstacleGrid[i][0]==1){
                dp[i][0] = 0;
            } else{
                dp[i][0] = dp[i-1][0];
            }
        }
        for(int j=1;j<cols;j++){
            if(obstacleGrid[0][j]==1){
                dp[0][j] = 0;
            } else{
                dp[0][j] = dp[0][j-1];
            }
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                } else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[rows-1][cols-1];
    }

    // Recursion using memoization
    /*public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dp[i][j] = -1;
            }
        }
        if(obstacleGrid[0][0]==1 || obstacleGrid[rows-1][cols-1]==1){
            return 0;
        }
        return rec(obstacleGrid, dp, 0, 0, rows, cols);
    }

    public static int rec(int[][] grid, int[][] dp, int i, int j, int r, int c){
        // System.out.println("Checking recursion calls, i = "+i+" , j = "+j);
        if(i==r-1 && j==c-1){
            // System.out.println("Comnpleted one path, returning one, i = "+i+" , j = "+j);
            return 1;
        }
        if(i>r-1 || j>c-1){
            // System.out.println("Exceeding board limits, returning zero, i = "+i+" , j = "+j);
            return 0;
        }
        if(grid[i][j]==1){
            // System.out.println("Hit an obstacle, returning zero, i = "+i+" , j = "+j);
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right = rec(grid, dp,  i+1, j, r , c);
        int down = rec(grid, dp, i, j+1, r, c);
        // System.out.println("Checking return from rec calls, i = "+i+" , j = "+j+" , right = "+right+" , down = "+down);
        return dp[i][j] = right + down;
    }*/

    // Basic Recursive Method
    /*public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        return rec(obstacleGrid, 0, 0, rows, cols);
    }

    public static int rec(int[][] grid, int i, int j, int r, int c){
        // System.out.println("Checking recursion calls, i = "+i+" , j = "+j);
        if(grid[i][j]==1){
            // System.out.println("Hit an obstacle returning zero, i = "+i+" , j = "+j);
            return 0;
        }
        if(i==r-1 && j==c-1){
            // System.out.println("Comnpleted one path returning one, i = "+i+" , j = "+j);
            return 1;
        }
        int right = i+1<=r-1 ? rec(grid, i+1, j, r , c) : 0;
        int down = j+1<=c-1 ? rec(grid, i, j+1, r, c) : 0;
        // System.out.println("Checking return from rec calls, i = "+i+" , j = "+j+" , right = "+right+" , down = "+down);
        return right + down;
    }*/

}
