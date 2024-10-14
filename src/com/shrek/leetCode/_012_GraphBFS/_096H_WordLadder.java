package com.shrek.leetCode._012_GraphBFS;

import java.sql.Array;
import java.util.*;

/**
 *
 * A transformation sequence from word beginWord to word endWord
 * using a dictionary wordList
 * is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 *
 * Every si for 1 <= i <= k is in wordList.
 * Note that beginWord does not need to be in wordList.
 *
 * sk == endWord
 *
 * Given two words, beginWord and endWord, and a dictionary wordList,
 * return the number of words in the shortest transformation sequence from beginWord to endWord,
 * or 0 if no such sequence exists.
 *
 * Example 1:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 *
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 *
 *
 * Example 2:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 * Constraints:
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 *
 */

public class _096H_WordLadder {

    public static void main(String[] args) {
        String beginWord;
        String endWord;
        List<String> wordList;

        beginWord = "hit";
        endWord = "cog";
        wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println("ladderLength for beginWord = "+beginWord+" endWord = "+ endWord+" wordList = "+ wordList.toString()+", equals "+ ladderLength(beginWord, endWord, wordList));
        // 5  i.e. "hit" -> "hot" -> "dot" -> "dog" -> cog"
        System.out.println();


        beginWord = "hit";
        endWord = "cog";
        wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println("ladderLength for beginWord = "+beginWord+" endWord = "+ endWord+" wordList = "+ wordList.toString()+", equals "+ ladderLength(beginWord, endWord, wordList));
        // 0  i.e. The endWord "cog" is not in wordList
        System.out.println();


        beginWord = "hot";
        endWord = "dog";
        wordList = new ArrayList<>(Arrays.asList("hot","dog"));
        System.out.println("ladderLength for beginWord = "+beginWord+" endWord = "+ endWord+" wordList = "+ wordList.toString()+", equals "+ ladderLength(beginWord, endWord, wordList));
        // 0  , can't go ahead due to lack of transformative steps
        System.out.println();

        beginWord = "hit";
        endWord = "cog";
        wordList = new ArrayList<>(Arrays.asList("hot","dot","tog","cog"));
        System.out.println("ladderLength for beginWord = "+beginWord+" endWord = "+ endWord+" wordList = "+ wordList.toString()+", equals "+ ladderLength(beginWord, endWord, wordList));
        // 0
        System.out.println();

        beginWord = "hot";
        endWord = "dog";
        wordList = new ArrayList<>(Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot"));
        System.out.println("ladderLength for beginWord = "+beginWord+" endWord = "+ endWord+" wordList = "+ wordList.toString()+", equals "+ ladderLength(beginWord, endWord, wordList));
        // 3  i.e.
        System.out.println();
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> visited =  new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int ladderLength=0;
        queue.add(beginWord);
        visited.add(beginWord);
        boolean wordFound = false;
        while(!queue.isEmpty()){
            int queueLength = queue.size();
            for(int i=0;i<queueLength;i++){
                String node = queue.poll();
                // System.out.println("Debugging for node = "+node);
                if(node.equals(endWord)){
                    // System.out.println("BREAK CONDITION = node.equals(endWord)");
                    return ladderLength+1;
                }
                for(int j=97;j<=122;j++){
                    char c = (char) j;
                    for(int k=0;k<node.length();k++){
                        String s = node.substring(0, k) + c + node.substring(k+1);
                        // System.out.println("Debugging generated String, nextNodeGenerated = "+s);
                        if(!visited.contains(s) && wordList.contains(s)){
                            // System.out.println("  Adding in Queue, nextNodeGenerated = "+s);
                            queue.add(s);
                            visited.add(s);
                        }
                    }
                }
            }
            /*if(queue.size()!=0){
                ladderLength++;
            }*/
            ladderLength++;
            // System.out.println("Debugging, ladderLength = "+ladderLength+" , queue length = "+queue.size());
        }
        if(wordFound==true){
            return ladderLength;
        } else{
            return 0;
        }
    }

     // Below is solution optimised for leetcode
     /*public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         Set<String> set = new HashSet<>(wordList);
         Queue<String> queue = new LinkedList<>();
         queue.add(beginWord);
         // COUNT NUMBER OF WORDS TRANSFORMED
         int count = 1;
         while (!queue.isEmpty()) {
             int size = queue.size();
             // FOR ALL WORDS THIS ROUND
             for (int i = 0; i < size; i++) {
                 char[] current = queue.poll().toCharArray();
                 // TRAVERSE CURRENT WORD
                 for (int j = 0; j < current.length; j++) {
                     char tmp = current[j];
                     // CHANGE ONE LETTER AT A TIME
                     for (char c = 'a'; c <= 'z'; c++) {
                         current[j] = c;
                         String next = new String(current);
                         // WHEN NEXT WORD IS IN THE SET
                         if (set.contains(next)) {
                             if (next.equals(endWord)) return count + 1;
                             queue.add(next);
                             set.remove(next);
                         }
                     }
                     // HAVE TO UNDO FOR NEXT CHANGE OF LETTER
                     current[j] = tmp;
                 }
             }
             // THIS ROUND ENDS WITH ONE LETTER CHANGED
             count++;
         }
         return 0;
     }*/


}
