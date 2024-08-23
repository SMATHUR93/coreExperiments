package com.shrek.leetCode.arraysStrings;

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

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<String>();

        if(words.length==1){
            list.add(words[0]);
            return list;
        }

        int noOfWords = words.length;

        // Greedy Addition with padding or justification
        String listEl = new String(words[0] + " ");
        for(int i=1;i<noOfWords;i++){
            System.out.println("Debugging in loop, i = "+i+" , words[i] = "+words[i]+" , liEl = " + listEl );
            if( maxWidth < (listEl.length() + words[i].length() + 1)){
                list.add(listEl);
                listEl = new String();
                System.out.println("Inside new element condition");
            }
            listEl = listEl.concat(words[i]);
            if(i!=noOfWords-1){
                listEl = listEl.concat(" ");
            }
        }
        list.add(listEl);

        System.out.println("Debugging li = " + list );

        return list;
    }

}
