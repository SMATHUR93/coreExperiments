package com.shrek.leetCode._011_GraphGeneral;

/**
 *
 * You are given an m x n matrix board containing letters 'X' and 'O',
 * capture regions that are surrounded:
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
 * A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.
 *
 * Example 1:
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 *
 * Explanation:
 * In the above diagram, the bottom region is not captured
 * because it is on the edge of the board and cannot be surrounded.
 *
 * Example 2:
 * Input: board = [["X"]]
 * Output: [["X"]]
 *
 *
 *
 * Constraints:
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 *
 */

public class _090M_SurroundedRegions {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        System.out.println("SurroundedRegions for grid = "+grid+" is equal to ");
        solve(grid);
        // [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
        System.out.println();

        grid = new char[][]{
                {'X'}
        };
        System.out.println("SurroundedRegions for grid = "+grid+" is equal to ");
        solve(grid);
        // [["X"]]
        System.out.println();

    }

    public static boolean surroundable = false;
    public static void solve(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        markVisitedClear(visited, m, n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='O' && visited[i][j]==false){
                    markVisitedClear(visited, m, n);
                    surroundable = true;
                    DFS(grid, i , j, m, n, visited);
                    markVisitedClear(visited, m, n);
                    if(surroundable==true){
                        captureDFS(grid, i , j, m, n, visited);
                    }
                }
            }
        }
    }
    public static void markVisitedClear(boolean[][] visited, int m, int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visited[i][j]=false;
            }
        }
    }

    public static void DFS(char[][] matrix, int row, int col, int m, int n, boolean[][] visited){
        visited[row][col] = true;
        if(row==0 || row==m-1 || col==0 || col==n-1){
            surroundable = false;
        }
        int[] rId = new int[]{-1, 0, 0, 1};
        int[] cId = new int[]{0, -1, 1, 0};
        int r=0,c=0;
        for(int k=0;k<4;k++){
            r = row+rId[k];
            c = col+cId[k];
            if( r>=0 && r<m && c>=0 && c<n && matrix[r][c]=='O' && visited[r][c]==false){
                DFS(matrix, r, c, m, n, visited);
            }
        }
    }

    public static void captureDFS(char[][] matrix, int row, int col, int m, int n, boolean[][] visited){
        visited[row][col] = true;
        matrix[row][col] = 'X';
        int[] rId = new int[]{-1, 0, 0, 1};
        int[] cId = new int[]{0, -1, 1, 0};
        int r=0,c=0;
        for(int k=0;k<4;k++){
            r = row+rId[k];
            c = col+cId[k];
            if( r>=0 && r<m && c>=0 && c<n && matrix[r][c]=='O' && visited[r][c]==false){
                captureDFS(matrix, r, c, m, n, visited);
            }
        }
    }

}
