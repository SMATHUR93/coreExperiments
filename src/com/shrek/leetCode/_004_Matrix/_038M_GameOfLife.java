package com.shrek.leetCode._004_Matrix;

/**
 *
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * Example 2:
 *
 *
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] is 0 or 1.
 *
 *
 * Follow up:
 *
 * Could you solve it in-place? Remember that the board needs to be updated simultaneously:
 * You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array.
 * In principle, the board is infinite,
 * which would cause problems when the active area encroaches upon the border of the array
 * (i.e., live cells reach the border).
 * How would you address these problems?
 *
 */

public class _038M_GameOfLife {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        System.out.println("rotate for matrix = " + matrix + " is ");
        gameOfLife(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(" "+ matrix[i][j]);
            }
            System.out.println();
        }
        // [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
        System.out.println("-------------- BREAK -----------------");
        matrix = new int[][]{
                {1, 1},
                {1, 0}
        };
        System.out.println("rotate for matrix = " + matrix + " is ");
        gameOfLife(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(" "+ matrix[i][j]);
            }
            System.out.println();
        }
        // [[1,1],[1,1]]
        System.out.println("-------------- BREAK -----------------");
    }

    public static void gameOfLife(int[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        int top, bottom, left, right, topLeft, topRight, bottomLeft, bottomRight;
        int el, sum;
        int[][] copyBoard = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++) {
                // System.out.println(rows + " || "+ columns + " || "+ board[i][j]);
                copyBoard[i][j] = board[i][j];
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                el = copyBoard[i][j];
                System.out.println(i + " || "+ j + " || "+ copyBoard[i][j]);
                top = i-1<0 ? 0 : copyBoard[i-1][j];
                bottom = i+1>rows-1 ? 0 : copyBoard[i+1][j];
                left = j-1<0 ? 0 : copyBoard[i][j-1];
                right = j+1>columns-1 ? 0 : copyBoard[i][j+1];
                topLeft = i-1<0 || j-1<0 ? 0 : copyBoard[i-1][j-1];
                topRight = i-1<0 || j+1>columns-1 ? 0 : copyBoard[i-1][j+1];
                bottomLeft = i+1>rows-1 || j-1<0 ? 0 : copyBoard[i+1][j-1];
                bottomRight = i+1>rows-1 || j+1>columns-1 ? 0 : copyBoard[i+1][j+1];
                sum = top + bottom + left + right + topLeft + topRight + bottomLeft + bottomRight;
                if(el==0 && sum==3){
                    board[i][j] = 1;
                } else if(el==1 && (sum<2 || sum>3)){
                    board[i][j] = 0;
                } else if(el==1 && (sum>2 || sum<3)){
                    board[i][j] = 1;
                }
            }
        }
    }

}
