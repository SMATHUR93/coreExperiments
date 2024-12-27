package com.shrek.leetCode._021_MultidimensionalDP;

import java.util.Arrays;

/**
 *
 * Given an m x n binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 *
 * Example 1:
 * Input:
 * matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output:
 * 4
 *
 *
 * Example 2:
 * Input:
 * matrix = [["0","1"],["1","0"]]
 * Output: 1
 *
 * Example 3:
 * Input: matrix = [["0"]]
 * Output: 0
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 *
 */

public class _150M_MaximalSquare {

    public static void main(String[] args) {
        char[][] matrix;

        matrix = new char[][]{{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println("maximalSquare for matrix = ");
        for(int i=0;i<matrix.length;i++){
            Arrays.toString(matrix[i]);
        }
        System.out.println(" , equals "+ maximalSquare(matrix));
        // 2
        System.out.println();

        matrix = new char[][]{{'0','1'},
                {'1','0'}
        };
        System.out.println("maximalSquare for matrix = ");
        for(int i=0;i<matrix.length;i++){
            Arrays.toString(matrix[i]);
        }
        System.out.println(" , equals "+ maximalSquare(matrix));
        // 1
        System.out.println();

        matrix = new char[][]{{'0'}};
        System.out.println("maximalSquare for matrix = ");
        for(int i=0;i<matrix.length;i++){
            Arrays.toString(matrix[i]);
        }
        System.out.println(" , equals "+ maximalSquare(matrix));
        // 0
        System.out.println();

    }

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m+1][n+1];

        int maxLen = 0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = 1 + Math.min(
                            dp[i-1][j-1],
                            Math.min(dp[i-1][j], dp[i][j-1])
                    );
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        /*for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Check DP");

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/


        return maxLen*maxLen;
    }

}
