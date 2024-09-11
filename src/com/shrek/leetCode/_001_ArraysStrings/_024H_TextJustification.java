package com.shrek.leetCode._001_ArraysStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Given an array of strings words and a width maxWidth,
 * format the text such that each line has exactly maxWidth characters
 * and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach;
 * that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line does not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."],
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"],
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 * Example 3:
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"],
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 *
 */

public class _024H_TextJustification {

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println("convert for words = " + Arrays.toString(words) + " , and maxWidth = "+maxWidth+" = "+ fullJustify(words, maxWidth));
        /**
         * [
         *   "This    is    an",
         *   "example  of text",
         *   "justification.  "
         * ]
         */
        System.out.println("-------------- BREAK -----------------");
        words = new String[]{"What","must","be","acknowledgment","shall","be"};
        maxWidth = 16;
        System.out.println("convert for words = " + Arrays.toString(words) + " , and maxWidth = "+maxWidth+" = "+ fullJustify(words, maxWidth));
        /**
         * [
         *   "What   must   be",
         *   "acknowledgment  ",
         *   "shall be        "
         * ]
         */
        System.out.println("-------------- BREAK -----------------");
        words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        maxWidth = 20;
        System.out.println("convert for words = " + Arrays.toString(words) + " , and maxWidth = "+maxWidth+" = "+ fullJustify(words, maxWidth));
        /**
         * [
         *   "Science  is  what we",
         *   "understand      well",
         *   "enough to explain to",
         *   "a  computer.  Art is",
         *   "everything  else  we",
         *   "do                  "
         * ]
         */
        System.out.println("-------------- BREAK -----------------");
    }

    // Solution: is to first add elemetns in line format and just checking if adding new element crosses maxWIdth
    // once els are added in one line, we apply text justifaction logic utilizing MODULO function on the string.
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        int num_of_letters = 0;

        int key;
        String value;
        for (String word : words) {
            if (word.length() + cur.size() + num_of_letters > maxWidth) {
                for (int i = 0; i < maxWidth - num_of_letters; i++) {
                    key = i % (cur.size() - 1 > 0 ? cur.size() - 1 : 1);
                    value = cur.get(i % (cur.size() - 1 > 0 ? cur.size() - 1 : 1)) + "X";
                    System.out.println("Debugging in loop, key = " + key + " , value = "+ value);
                    cur.set(key, value);
                }
                System.out.println("Debugging on loop completion cur = " + cur);
                StringBuilder sb = new StringBuilder();
                for (String s : cur) sb.append(s);
                res.add(sb.toString());
                cur.clear();
                num_of_letters = 0;
            }
            cur.add(word);
            num_of_letters += word.length();
        }

        StringBuilder lastLine = new StringBuilder();
        for (int i = 0; i < cur.size(); i++) {
            lastLine.append(cur.get(i));
            if (i != cur.size() - 1) lastLine.append(" ");
        }
        while (lastLine.length() < maxWidth) lastLine.append(" ");
        res.add(lastLine.toString());

        return res;
    }

}
