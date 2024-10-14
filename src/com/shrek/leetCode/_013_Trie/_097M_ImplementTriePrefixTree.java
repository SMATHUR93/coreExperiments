package com.shrek.leetCode._013_Trie;

import java.util.Arrays;

/**
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 * Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 *
 */

public class _097M_ImplementTriePrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }

    static class Trie {

        class TrieNode{
            public boolean isFinal = false;
            public TrieNode[] refs =  new TrieNode[26];

            public boolean doesRefExists(int index){
                return refs[index]!=null;
            }

            public void setFinal(boolean aFinal) {
                isFinal = aFinal;
            }

            public boolean getFinal(){
                return isFinal;
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode currNode = root;
            TrieNode newNode = null;
            for(int i=0;i<word.length();i++){
                int index = (int) (word.charAt(i)-'a');
                if(currNode.doesRefExists(index)){
                    currNode = currNode.refs[index];
                } else {
                    newNode = new TrieNode();
                    currNode.refs[index] = newNode;
                    currNode = newNode;
                }
                if(i==word.length()-1){
                    currNode.setFinal(true);
                }
            }
        }

        public boolean search(String word) {
            boolean isFound = true;
            TrieNode currNode = root;
            for(int i=0;i<word.length();i++){
                int index = (int) (word.charAt(i)-'a');
                if(currNode.doesRefExists(index)){
                    currNode = currNode.refs[index];
                } else {
                    return false;
                }
                if(i==word.length()-1){
                    isFound = currNode.getFinal();
                }
            }
            return isFound;
        }

        public boolean startsWith(String prefix) {
            boolean isFound = true;
            TrieNode currNode = root;
            for(int i=0;i<prefix.length();i++){
                int index = (int) (prefix.charAt(i)-'a');
                if(currNode.doesRefExists(index)){
                    currNode = currNode.refs[index];
                } else {
                    return false;
                }
            }
            return isFound;
        }
    }

    // More simplified solution
    /*class Trie {
        class TrieNode{
            public boolean isFinal = false;
            public TrieNode[] refs =  new TrieNode[26];
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                int index = (int) (word.charAt(i)-'a');
                if(curr.refs[index]!=null){
                    curr = curr.refs[index];
                } else {
                    TrieNode newNode = new TrieNode();
                    curr.refs[index] = newNode;
                    curr = newNode;
                }
            }
            curr.isFinal = true;
        }

        public boolean search(String word) {
            boolean isFound = true;
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                int index = (int) (word.charAt(i)-'a');
                if(curr.refs[index]!=null){
                    curr = curr.refs[index];
                } else {
                    return false;
                }
            }
            isFound = curr.isFinal;
            return isFound;
        }

        public boolean startsWith(String prefix) {
            boolean isFound = true;
            TrieNode curr = root;
            for(int i=0;i<prefix.length();i++){
                int index = (int) (prefix.charAt(i)-'a');
                if(curr.refs[index]!=null){
                    curr = curr.refs[index];
                } else {
                    return false;
                }
            }
            return isFound;
        }
    }*/

}
