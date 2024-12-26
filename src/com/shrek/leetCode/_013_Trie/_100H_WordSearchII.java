package com.shrek.leetCode._013_Trie;

import java.util.*;

/**
 *
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 * Example 1:
 * Input:
 * board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 * words = ["oath","pea","eat","rain"]
 * Output:
 * ["eat","oath"]
 *
 * Example 2:
 * Input:
 * board = [["a","b"],["c","d"]],
 * words = ["abcb"]
 * Output: []
 *
 * Constraints:
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 *
 * Hint 1
 * You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
 *
 * Hint 2
 * If the current candidate does not exist in all words' prefix, you could stop backtracking immediately.
 * What kind of data structure could answer such query efficiently? Does a hash table work?
 * Why or why not? How about a Trie?
 * If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
 *
 */

public class _100H_WordSearchII {

    public static void main(String[] args) {

        char[][] board;
        String[] words;

        board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        words = new String[]{"oath","pea","eat","rain"};
        System.out.println("findWords for board = "+Arrays.toString(board)+" words = "+ Arrays.toString(words)+", equals "+ findWords(board, words).toString());
        // ["eat","oath"]
        System.out.println();

        board = new char[][]{
                {'a','b'},
                {'c','d'}
        };
        words = new String[]{"abcb", "abc", "abd", "ad", "e"};
        System.out.println("findWords for board = "+Arrays.toString(board)+" words = "+ Arrays.toString(words)+", equals "+ findWords(board, words).toString());
        // ["eat","oath"]
        System.out.println();

        board = new char[][]{
                {'o','a','b','n'},
                {'o','t','a','e'},
                {'a','h','k','r'},
                {'a','f','l','v'}
        };
        words = new String[]{"oa","oaa"};
        System.out.println("findWords for board = "+Arrays.toString(board)+" words = "+ Arrays.toString(words)+", equals "+ findWords(board, words).toString());
        // ["oa","oaa"]
        System.out.println();
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> op = new HashSet<>();
        int m = board.length;
        int n = board[0].length;

        Trie trie = new Trie();
        for(String word:words){
            trie.insert(word);
        }

        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                String str = String.valueOf(board[i][j]);
                dfs(board, visited, i, j, m, n, str, trie, op);
            }
        }
        return new ArrayList<>(op);
    }

    public static void dfs(char[][] board, boolean[][] visited, int row, int col, int m, int n, String str, Trie trie, Set<String> op){
        if(!trie.startWith(str)){
            return;
        } else if(trie.search(str)==true){
            op.add(str);
        }
        visited[row][col] = true;
        int[] rId = new int[]{-1, 0, 0, 1};
        int[] cId = new int[]{0, -1, 1, 0};
        for(int k=0;k<4;k++){
            if( (row+rId[k])>=0 && (row+rId[k])<m && (col+cId[k])>=0 && (col+cId[k])<n && visited[row+rId[k]][col+cId[k]]==false){
                String s = str.concat(String.valueOf(board[row+rId[k]][col+cId[k]]));
                dfs(board, visited, row+rId[k] , col+cId[k], m, n, s, trie, op);
            }
        }
        visited[row][col] = false;
    }

    static class Trie{
        class TrieNode{
            boolean isFinal = false;
            TrieNode[] links = new TrieNode[26];
        }

        TrieNode root;
        Trie(){
            root = new TrieNode();
        }

        void insert(String word){
            TrieNode curr = this.root;
            for(int i=0;i<word.length();i++){
                int index = (int)(word.charAt(i) - 'a');
                if(curr.links[index]!=null){
                    curr = curr.links[index];
                } else{
                    TrieNode newNode = new TrieNode();
                    curr.links[index] = newNode;
                    curr = newNode;
                }
            }
            curr.isFinal = true;
        }

        boolean search(String word){
            boolean isFound = true;
            TrieNode curr = this.root;
            for(int i=0;i<word.length();i++){
                int index = (int)(word.charAt(i) - 'a');
                if(curr.links[index]!=null){
                    curr = curr.links[index];
                } else{
                    return false;
                }
            }
            isFound = curr.isFinal;
            return isFound;
        }

        boolean startWith(String prefix){
            boolean isFound = true;
            TrieNode curr = this.root;
            for(int i=0;i<prefix.length();i++){
                int index = (int)(prefix.charAt(i) - 'a');
                if(curr.links[index]!=null){
                    curr = curr.links[index];
                } else{
                    return false;
                }
            }
            return isFound;
        }
    }

}
