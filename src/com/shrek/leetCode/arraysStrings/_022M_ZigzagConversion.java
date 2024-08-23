package com.shrek.leetCode.arraysStrings;

import java.util.Arrays;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */

public class _022M_ZigzagConversion {

    public static void main(String[] args) {
        String s = "ABCDEFGHIJKL";
        int numRows = 4;
        System.out.println("convert for "+s+" , for numRows = "+numRows+" = "+convert(s, numRows));
        // AG BFHL CEIK DJ
        System.out.println("-------------- BREAK -----------------");
        s = "PAYPALISHIRING";
        numRows = 3;
        System.out.println("convert for "+s+" , for numRows = "+numRows+" = "+convert(s, numRows));
        // PAHNAPLSIIGYIR
        System.out.println("-------------- BREAK -----------------");
        s = "PAYPALISHIRING";
        numRows = 4;
        System.out.println("convert for "+s+" , for numRows = "+numRows+" = "+convert(s, numRows));
        // PINALSIGYAHRPI
        System.out.println("-------------- BREAK -----------------");
        s = "A";
        numRows = 1;
        System.out.println("convert for "+s+" , for numRows = "+numRows+" = "+convert(s, numRows));
        // A
        System.out.println("-------------- BREAK -----------------");
        s = "AB";
        numRows = 1;
        System.out.println("convert for "+s+" , for numRows = "+numRows+" = "+convert(s, numRows));
        // A
        System.out.println("-------------- BREAK -----------------");
    }

    // Trick is to save info in arrays UP or DOWN
    public static String convert(String s, int n) {

        if(n<=1){
            return s;
        }

        char[] arr = s.toCharArray();
        int len = arr.length;

        StringBuffer sb = new StringBuffer();

        String[] subStrings = new String[n];
        Arrays.fill(subStrings, new String());

        int level = 0;
        boolean increaseLevel = true;
        for(int i=0;i<len;i++){
            System.out.println("Adding arr[i] = " + arr[i] + " , at level = "+ level + " with increment flag as = "+increaseLevel);

            subStrings[level] = subStrings[level].concat(String.valueOf(arr[i]));

            System.out.println("Value of subStrings[level] = "+subStrings[level]);

            if(level==n-1){
                increaseLevel = false;
            } else if(level==0){
                increaseLevel = true;
            }

            if(increaseLevel==true){
                level++;
            } else{
                level--;
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(subStrings[i]);
            sb.append(subStrings[i]);
        }

        return sb.toString();
    }

}
