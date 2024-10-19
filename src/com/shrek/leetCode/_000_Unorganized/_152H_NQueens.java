package com.shrek.leetCode._000_Unorganized;

import java.util.*;

/**
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 * Example 1:
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 *
 *  Example 2:
 * Input: n = 1
 * Output: [["Q"]]
 *
 * Constraints:
 * 1 <= n <= 9
 *
 */

public class _152H_NQueens {

    public static void main(String[] args) {
        int n;

        n=4;
        System.out.println("solveNQueens for n = "+n+" equals "+solveNQueens(n).toString());
        // [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        System.out.println();

        n=1;
        System.out.println("solveNQueens for n = "+n+" equals "+solveNQueens(n).toString());
        // [["Q"]]
        System.out.println();

        n=5;
        System.out.println("solveNQueens for n = "+n+" equals "+solveNQueens(n).toString());
        // [["Q"]]
        System.out.println();
    }

    public static int size;
    public static List<List<String>> solutions = new ArrayList<List<String>>();

    public static List<List<String>> solveNQueens(int n) {
        size = n;
        char emptyBoard[][] = new char[size][size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                emptyBoard[i][j] = '.';
            }
        }

        backtrack(
                0,
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(),
                emptyBoard
        );
        return solutions;
    }

    // Making use of a helper function to get the
    // solutions in the correct output format
    public static List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < size; row++) {
            String current_row = new String(state[row]);
            board.add(current_row);
        }

        return board;
    }

    public static void backtrack(
            int row,
            Set<Integer> diagonals,
            Set<Integer> antiDiagonals,
            Set<Integer> cols,
            char[][] state
    ) {
        // Base case - N queens have been placed
        if (row == size) {
            solutions.add(createBoard(state));
            return;
        }

        for (int col = 0; col < size; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            // If the queen is not placeable
            if (
                    cols.contains(col) ||
                            diagonals.contains(currDiagonal) ||
                            antiDiagonals.contains(currAntiDiagonal)
            ) {
                continue;
            }

            // "Add" the queen to the board
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            state[row][col] = 'Q';

            // Move on to the next row with the updated board state
            backtrack(row + 1, diagonals, antiDiagonals, cols, state);

            // "Remove" the queen from the board since we have already
            // explored all valid paths using the above function call
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            state[row][col] = '.';
        }
    }

}
