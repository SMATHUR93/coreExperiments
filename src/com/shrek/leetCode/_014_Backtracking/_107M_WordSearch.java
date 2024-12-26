package com.shrek.leetCode._014_Backtracking;

/**
 *
 * Given an m x n grid of characters board and a string word,
 * return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Example 3:
 * Output: false
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 *
 */

public class _107M_WordSearch {

    public static void main(String[] args) {
        char[][] board;
        String word;

        board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        word = "ABCCED";
        System.out.println("solveSudoku for word = "+word+" , board = "+board);
        System.out.println(" equals " + exist(board, word) );
        // true
        System.out.println();

        board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        word = "SEE";
        System.out.println("solveSudoku for word = "+word+" , board = "+board);
        System.out.println(" equals " + exist(board, word) );
        // true
        System.out.println();

        board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        word = "ABCB";
        System.out.println("solveSudoku for word = "+word+" , board = "+board);
        System.out.println(" equals " + exist(board, word) );
        // false
        System.out.println();

        board = new char[][]{
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
        word = "AAB";
        System.out.println("solveSudoku for word = "+word+" , board = "+board);
        System.out.println(" equals " + exist(board, word) );
        // true
        System.out.println();

    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        /*for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }*/
        boolean[][] visted = new boolean[m][n];
        char[] arr = word.toCharArray();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    // System.out.println("Conducting DFS for char = "+board[i][j]);
                    if(dfs(board, visted, i, j, m, n, 1, word)==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(
            char[][] board,
            boolean[][] visted,
            int row,
            int col,
            int m,
            int n,
            int currLen,
            String word
    ){
        if(currLen==word.length()){
            System.out.println("         currLen = "+currLen+ " , word.length()  = "+word.length());
            return true;
        }
        visted[row][col] = true;
        int[] rId = new int[]{-1, 0, 0, 1};
        int[] cId = new int[]{0, -1, 1, 0};
        for(int k=0;k<4;k++){
            if(
                (row+rId[k])>=0 &&
                (row+rId[k])<m &&
                (col+cId[k])>=0 &&
                (col+cId[k])<n &&
                visted[row+rId[k]][col+cId[k]]==false &&
                board[row+rId[k]][col+cId[k]]==word.charAt(currLen)
            ) {
                System.out.println("         recursion block currLen = "+currLen+", Checking neighbours for board char = "+board[row][col]+" , and string char = "+word.charAt(currLen) + ", current neighbour is = "+board[row+rId[k]][col+cId[k]]);
                if(dfs(
                    board,
                    visted,
                    row + rId[k],
                    col + cId[k],
                    m,
                    n,
                    currLen + 1,
                    word
                )==true){
                    return true;
                }
            }
        }
        visted[row][col] = false;
        return false;
    }
}
