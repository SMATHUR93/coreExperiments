package com.shrek.leetCode._014_Backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 *
 */

public class _104H_NQueensII {

    public static void main(String[] args) {
        int n;

        n=4;
        System.out.println("totalNQueens for n = "+n+" equals "+totalNQueens(n));
        // [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        System.out.println();

        n=1;
        System.out.println("totalNQueens for n = "+n+" equals "+totalNQueens(n));
        // [["Q"]]
        System.out.println();

        n=5;
        System.out.println("totalNQueens for n = "+n+" equals "+totalNQueens(n));
        // [["Q"]]
        System.out.println();
    }

    public static int size;

    public static int totalNQueens(int n) {
        size = n;
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    public static int backtrack(
            int row,
            Set<Integer> diagonals,
            Set<Integer> antiDiagonals,
            Set<Integer> cols
    ) {
        // Base case - N queens have been placed
        if (row == size) {
            return 1;
        }

        int solutions = 0;
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

            // Move on to the next row with the updated board state
            solutions += backtrack(row + 1, diagonals, antiDiagonals, cols);

            // "Remove" the queen from the board since we have already
            // explored all valid paths using the above function call
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
        }

        return solutions;
    }

}
