package com.shrek.leetCode._000_Unorganized;

import java.util.Arrays;

/**
 *
 *Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 *
 * Example 1:
 *
 * Input: board = [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 *
 *  Output: [
 *  ["5","3","4","6","7","8","9","1","2"],
 *  ["6","7","2","1","9","5","3","4","8"],
 *  ["1","9","8","3","4","2","5","6","7"],
 *  ["8","5","9","7","6","1","4","2","3"],
 *  ["4","2","6","8","5","3","7","9","1"],
 *  ["7","1","3","9","2","4","8","5","6"],
 *  ["9","6","1","5","3","7","2","8","4"],
 *  ["2","8","7","4","1","9","6","3","5"],
 *  ["3","4","5","2","8","6","1","7","9"]
 *  ]
 * Explanation: The input board is shown above and the only valid solution is shown below:
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 *
 */

public class _151H_SudokuSolver {

    public static void main(String[] args) {
        char[][] board;

        board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("solveSudoku for board = ");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(" equals ");
        solveSudoku(board);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        // [[1,1,1,1],[1,1,2],[2,2]]
        System.out.println();
    }

    public static void solveSudoku(char[][] board) {
        sudokuSolver(board);
    }

    public static boolean sudokuSolver(char[][] board){
        int row = -1;
        int col = -1;
        boolean areEmptyCells = false;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    row = i;
                    col = j;
                    areEmptyCells=true;
                    break;
                }
            }
            if (areEmptyCells==true) {
                break;
            }
        }

        if(areEmptyCells==false){
            return true;
        }

        for(int i=49;i<=57;i++){
            char c = (char) i;
            if(checkCell(board, row, col, c)==true){
                board[row][col] = c;
                if (sudokuSolver(board)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    public static boolean checkCell(char[][] board, int row, int col, char val){
        for(int i=0;i<9;i++){
            if(board[row][i]==val){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==val){
                return false;
            }
        }
        int rowStart = (row/3)*3;
        int rowEnd = rowStart + 3;
        int colStart= (col/3)*3;
        int colEnd = colStart + 3;
        // System.out.println("Debugging values, row = "+row+" , col = "+col+" , rowStart = "+rowStart+" , rowEnd = "+rowEnd+" , colStart = "+colStart+" , colEnd = "+colEnd);
        for(int i=rowStart;i<rowEnd;i++){
            for(int j=colStart;j<colEnd;j++){
                if(board[i][j]==val){
                    return false;
                }
            }
        }
        return true;
    }

}
