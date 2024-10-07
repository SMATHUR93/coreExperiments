package com.shrek.leetCode._011_GraphGeneral;

/**
 *
 * Given an m x n 2D binary grid
 * grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * An island is surrounded by water and is
 * formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 */

public class _088M_NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println("numIslands for grid = "+grid+" is equal to "+numIslands(grid));
        // 1
        System.out.println();

        grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("numIslands for grid = "+grid+" is equal to "+numIslands(grid));
        // 3
        System.out.println();

        grid = new char[][]{
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}
        };
        System.out.println("numIslands for grid = "+grid+" is equal to "+numIslands(grid));
        // 1
        System.out.println();

    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int noOfIslands = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    DFS(grid, i , j, m, n);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }

    public static void DFS(char[][] matrix, int row, int col, int m, int n){
        matrix[row][col] = 'X';
        int[] rId = new int[]{-1, 0, 0, 1};
        int[] cId = new int[]{0, -1, 1, 0};
        for(int k=0;k<4;k++){
            if( (row+rId[k])>=0 && (row+rId[k])<m && (col+cId[k])>=0 && (col+cId[k])<n && matrix[row+rId[k]][col+cId[k]]=='1'){
                DFS(matrix, row+rId[k] , col+cId[k], m, n);
            }
        }
    }

}
