package com.shrek.leetCode._004_Matrix;

/**
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Example 1:
 *
 *
 * Input: board =
 * [['5','3','.','.','7','.','.','.','.']
 * ,['6','.','.','1','9','5','.','.','.']
 * ,['.','9','8','.','.','.','.','6','.']
 * ,['8','.','.','.','6','.','.','.','3']
 * ,['4','.','.','8','.','3','.','.','1']
 * ,['7','.','.','.','2','.','.','.','6']
 * ,['.','6','.','.','.','.','2','8','.']
 * ,['.','.','.','4','1','9','.','.','5']
 * ,['.','.','.','.','8','.','.','7','9']]
 * Output: true
 * Example 2:
 *
 * Input: board =
 * [['8','3','.','.','7','.','.','.','.']
 * ,['6','.','.','1','9','5','.','.','.']
 * ,['.','9','8','.','.','.','.','6','.']
 * ,['8','.','.','.','6','.','.','.','3']
 * ,['4','.','.','8','.','3','.','.','1']
 * ,['7','.','.','.','2','.','.','.','6']
 * ,['.','6','.','.','.','.','2','8','.']
 * ,['.','.','.','4','1','9','.','.','5']
 * ,['.','.','.','.','8','.','.','7','9']]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 *
 */

public class _034M_ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
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
        System.out.println("isValidSudoku for board = " + board + " == " + isValidSudoku(board) );
        // true
        System.out.println("-------------- BREAK -----------------");
        board = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("isValidSudoku for board = " + board + " == " + isValidSudoku(board) );
        // false
        System.out.println("-------------- BREAK -----------------");

    }

    public static boolean isValidSudoku(char[][] board) {
        char ch;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                ch = board[i][j];
                // System.out.println("Debugging character = "+ch);
                for(int k=0;k<9;k++){
                    if(board[i][k]!='.' && k!=j && board[i][k]==ch){
                        // System.out.println("Returning false in row check, board[i][k] = "+board[i][k]+" , ch = "+ch);
                        return false;
                    }
                }
                for(int k=0;k<9;k++){
                    if(board[k][j]!='.' && k!=i  && board[k][j]==ch){
                        // System.out.println("Returning false in column check, board[k][j] = "+board[k][j]+" , ch = "+ch);
                        return false;
                    }
                }
                int m=0;
                int n=0;
                if(i>=0 && i<3){
                    m=0;
                } else if(i>=3 && i<6){
                    m=3;
                } else if(i>=6 && i<9){
                    m=6;
                }
                if(j>=0 && j<3){
                    n=0;
                } else if(j>=3 && j<6){
                    n=3;
                } else if(j>=6 && j<9){
                    n=6;
                }
                // System.out.println("Debugging character = "+ch+", i = "+i+", j = "+j+", m = "+m+" , n = "+n);
                for(int l=m;l<m+3;l++){
                    for(int r=n;r<n+3;r++){
                        if(board[l][r]!='.' && l!=i && r!=j && board[l][r]==ch){
                            // System.out.println("Returning false in block check, board[l][r] = "+board[l][r]+" , ch = "+ch);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
