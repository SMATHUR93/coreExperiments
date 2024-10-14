package com.shrek.leetCode._013_Trie;

/**
 *
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 *
 * Example:
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 * Constraints:
 * 1 <= word.length <= 25
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 * There will be at most 2 dots in word for search queries.
 * At most 104 calls will be made to addWord and search.
 *
 * Hint 1
 * You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
 *
 */

public class _098M_DesignAddAndSearchWordsDS {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True

    }

    static class WordDictionary {

        class TrieNode{
            public boolean isFinal = false;
            public TrieNode[] refs =  new TrieNode[26];
        }

        TrieNode root;
        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
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
            return search(word, this.root, 0);
        }

        private boolean search(String word, TrieNode node, int index){

            if (index == word.length()) {
                return node.isFinal;
            }

            if(word.charAt(index) != '.'){
                return (
                        node.refs[word.charAt(index) - 'a'] != null  &&
                                search(word, node.refs[word.charAt(index) - 'a'], index+1)
                );
            }else{
                for(TrieNode n : node.refs){
                    if (n != null && search (word, n, index+1)) return true;
                }
                return false;
            }

        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

}
