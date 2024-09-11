package com.shrek.leetCode._001_ArraysStrings;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together.
 * 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII.
 * Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 *
 *
 * Hint 1
 * Problem is simpler to solve by working the string from back to front and using a map.
 *
 */

public class _017E_RomanToInteger {

    public static void main(String[] args) {
        String s = "III";
        System.out.println(s);
        System.out.println("romanToInt for "+s+" = "+romanToInt(s));
        System.out.println("-------------- BREAK -----------------");
        s = "LVIII";
        System.out.println(s);
        System.out.println("romanToInt for "+s+" = "+romanToInt(s));
        System.out.println("-------------- BREAK -----------------");
        s = "MCMXCIV";
        System.out.println(s);
        System.out.println("romanToInt for "+s+" = "+romanToInt(s));
        System.out.println("-------------- BREAK -----------------");
        /*nums = new int[]{1,2,3,3,3,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(romanToInt(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{0,0,1,0,0,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(romanToInt(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{3,0,6,1,5};
        System.out.println(Arrays.toString(nums));
        System.out.println(romanToInt(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{9,7,2,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(romanToInt(nums));*/
    }

    public static int romanToInt(String s) {
        int num = 0;
        /*Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);*/
        char[] arr = s.toCharArray();
        char c;
        for(int i=arr.length-1;i>=0;i--){
            // System.out.print("i = "+i+" , ");
            c = arr[i];

            if(c=='I'){
                // System.out.println("1");
                num += 1;
            }
            if( c=='V' && i!=0 && arr[i-1]=='I') {
                // System.out.println("4");
                num += 4;
                i--;
            } else if(c=='V'){
                // System.out.println("5");
                num += 5;
            }

            if( c=='X' && i!=0 && arr[i-1]=='I' ) {
                // System.out.println("9");
                num += 9;
                i--;
            } else if(c=='X'){
                // System.out.println("10");
                num += 10;
            }

            if( c=='L' && i!=0 && arr[i-1]=='X') {
                // System.out.println("40");
                num += 40;
                i--;
            } else if(c=='L'){
                // System.out.println("50");
                num += 50;
            }

            if( c=='C' && i!=0 && arr[i-1]=='X' ) {
                // System.out.println("90");
                num += 90;
                i--;
            } else if(c=='C'){
                // System.out.println("100");
                num += 100;
            }

            if( c=='D' && i!=0 && arr[i-1]=='C') {
                // System.out.println("400");
                num += 400;
                i--;
            } else if(c=='D'){
                // System.out.println("500");
                num += 500;
            }

            if( c=='M' && i!=0 && arr[i-1]=='C' ) {
                // System.out.println("900");
                num += 900;
                i--;
            } else if(c=='M'){
                // System.out.println("1000");
                num += 1000;
            }
        }
        return num;
    }

}
