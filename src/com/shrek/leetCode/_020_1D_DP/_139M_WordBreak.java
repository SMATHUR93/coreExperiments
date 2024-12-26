package com.shrek.leetCode._020_1D_DP;

/**
 *
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 *
 * Constraints:
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 *
 */

import java.util.*;

public class _139M_WordBreak {

    public static void main(String[] args) {
        String s;
        List<String> wordDict;

        s = "leetcode";
        wordDict = new ArrayList<>(Arrays.asList("leet","code"));
        System.out.println("rob for s = "+s+" , wordDict = "+ wordDict.toString()+" , equals "+wordBreak(s, wordDict));
        // true
        System.out.println();

        s = "applepenapple";
        wordDict = new ArrayList<>(Arrays.asList("apple","pen"));
        System.out.println("rob for s = "+s+" , wordDict = "+ wordDict.toString()+" , equals "+wordBreak(s, wordDict));
        // true
        System.out.println();

        s = "catsandog";
        wordDict = new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"));
        System.out.println("rob for s = "+s+" , wordDict = "+ wordDict.toString()+" , equals "+wordBreak(s, wordDict));
        // false
        System.out.println();

    }

    // Solved this using BFS while considering the String as a graph
    // where traversal between 2 nodes is possible if it exists in dictionary,
    // Solution using DP is NOT DONE
    public static boolean wordBreak(String str, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[str.length() + 1];
        queue.add(0);
        while(!queue.isEmpty()){
            int startIdx = queue.remove();
            if(startIdx == str.length()){
                return true;
            }
            for(int endIdx = startIdx + 1; endIdx <= str.length(); endIdx++){
                if(visited[endIdx] == true){
                    continue;
                }
                if(wordSet.contains( str.substring(startIdx, endIdx) )){
                    queue.add(endIdx);
                    visited[endIdx] = true;
                }
            }
        }
        return false;
    }

}
