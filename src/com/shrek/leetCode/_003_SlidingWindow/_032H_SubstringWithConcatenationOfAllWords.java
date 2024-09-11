package com.shrek.leetCode._003_SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * You are given a string s and an array of strings words.
 * All the strings of words are of the same length.
 *
 * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
 *
 * For example, if words = ["ab","cd","ef"],
 * then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings.
 * "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
 *
 * Return an array of the starting indices of all the concatenated substrings in s.
 * You can return the answer in any order.
 *
 *
 * Example 1:
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 *
 * Output: [0,9]
 *
 * Explanation:
 *
 * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
 *
 * Example 2:
 *
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 *
 * Output: []
 *
 * Explanation:
 *
 * There is no concatenated substring.
 *
 * Example 3:
 *
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 *
 * Output: [6,9,12]
 *
 * Explanation:
 *
 * The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
 * The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
 * The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * s and words[i] consist of lowercase English letters.
 *
 */

public class _032H_SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        System.out.println("lengthOfLongestSubstring for string s = " + s + " , and words = "+words+" == " + findSubstring(s, words) );
        // [0,9]
        System.out.println("-------------- BREAK -----------------");
        s = "wordgoodgoodgoodbestword";
        words = new String[]{"par", "cat", "nil", "taz"};
        System.out.println("lengthOfLongestSubstring for string s = " + s + " , and words = "+words+" == " + findSubstring(s, words) );
        // [6,9,12]
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = words.length;
        int w = words[0].length();

        HashMap<String,Integer> map = new HashMap<>();
        for(String x : words){
            map.put(x, map.getOrDefault(x,0)+1);
        }


        for(int i=0; i<w; i++){
            HashMap<String,Integer> temp = new HashMap<>();
            int count = 0;
            for(int j=i,k=i; j+w <= n; j=j+w){
                String word = s.substring(j,j+w);
                temp.put(word,temp.getOrDefault(word,0)+1);
                count++;

                if(count==m){
                    if(map.equals(temp)){
                        ans.add(k);
                    }
                    String remove = s.substring(k,k+w);
                    temp.computeIfPresent(remove, (a, b) -> (b > 1) ? b - 1 : null);
                    count--;
                    k=k+w;
                }
            }//inner for loop
        }//outer for loop
        return ans;
    }

}
